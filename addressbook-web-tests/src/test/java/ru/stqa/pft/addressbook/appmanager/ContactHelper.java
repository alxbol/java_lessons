package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillNewContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getFirstname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
    }

    public void submitNewContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void submitContactDeletionFromHomeMenu() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initContactModifiactionById(int id) {
        wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", id))).click();
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public int count() {
        return wd.findElements(By.name("entry")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath("./td[1]")).getText();
            String firstName = element.findElement(By.xpath("./td[2]")).getText();
            String address = element.findElement(By.xpath("./td[4]")).getText();
            String allEmails = element.findElement(By.xpath("./td[5]")).getText();
            String allPhones = element.findElement(By.xpath("./td[6]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName).withAllPhones(allPhones)
                    .withAddress(address).withAllEmails(allEmails));
        }
        return contacts;
    }

    public void create(ContactData contact) {
        fillNewContact(contact);
        submitNewContactCreation();
        contactCache = null;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitContactDeletionFromHomeMenu();
        acceptAlert();
        contactCache = null;
    }

    public void modify(ContactData contact) {
        initContactModifiactionById(contact.getId());
        fillNewContact(contact);
        submitContactModification();
        contactCache = null;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModifiactionById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        return new ContactData().withId(contact.getId()).withFirstname(firstname)
                .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }
}