package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeletionContactFromHomePage() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNewPage();
      app.getContactHelper().createContact(new ContactData("Alexey", null, null, null, null));
      app.getNavigationHelper().goToHomePage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletionFromHomeMenu();
    app.getContactHelper().acceptAlert();
  }
}
