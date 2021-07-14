package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
