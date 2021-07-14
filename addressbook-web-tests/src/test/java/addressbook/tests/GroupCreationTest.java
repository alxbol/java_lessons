package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testUntitledTestCase() {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
