package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testCreationNewContact() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Alexey").withLastname("Bolshakov").withAddress("Saratov")
            .withMobilePhone("+79855005795").withWorkPhone("11-11").withHomePhone("7(985)")
            .withEmail("bolshakov.alexey@gmail.com");
    app.goTo().AddNewPage();
    app.contact().create(contact);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
