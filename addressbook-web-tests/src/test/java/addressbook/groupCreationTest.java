package addressbook;

import org.testng.annotations.Test;

public class groupCreationTest extends TestBase {

  @Test
  public void testUntitledTestCase() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
