package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initEdit();
        app.getContactHelper().fillNewContact(new ContactData("Alexey", "Bolshakov", "Saratov", "+79855005795", "bolshakov.alexey@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}
