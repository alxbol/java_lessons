package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().AddNewPage();
            app.contact().create(new ContactData().withFirstname("Alexey"));
            app.goTo().HomePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstname("Alexey").withLastname("Bolshakov").withAddress("Saratov").withMobilePhone("+79855005795").withEmail("bolshakov.alexey@gmail.com");
        app.contact().modify(contact);
        app.goTo().HomePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}