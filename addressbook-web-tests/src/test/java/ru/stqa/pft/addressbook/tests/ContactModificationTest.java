package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().AddNewPage();
            app.contact().create(new ContactData().withFirstname("Alexey"));
            app.goTo().HomePage();
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstname("Alexey").withLastname("Bolshakov").withAddress("Saratov").withMobilePhone("+79855005795").withEmail("bolshakov.alexey@gmail.com");
        app.contact().modify(contact);
        app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, CoreMatchers.hasItem(contact));
        verifyGroupListInUI();
    }
}
