package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testCreationNewContact() {
    app.goTo().AddNewPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Alexey").withLastname("Bolshakov").withAddress("Saratov").withMobilePhone("+79855005795").withEmail("bolshakov.alexey@gmail.com");
    app.contact().create(contact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt());
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
