package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeletionContactFromHomePage() {
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletionFromHomeMenu();
    app.getContactHelper().acceptAlert();
  }
}
