package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testAdditionNewContact() {
    app.getNavigationHelper().goToAddNewPage();
    app.getContactHelper().fillNewContact(new ContactData("Alexey", "Bolshakov", "Saratov", "+79855005795", "bolshakov.alexey@gmail.com"));
    app.getContactHelper().submitNewContactCreation();
    app.getNavigationHelper().goToHomePage();
  }
}
