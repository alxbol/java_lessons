package addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class groupCreationTest {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() {
    driver = new ChromeDriver();
    new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.get("http://localhost/addressbook/index.php");
    login("admin", "secret");
  }

  private void login(String user, String password) {
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(user);
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testUntitledTestCase() {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm("test1", "test2", "test3");
    submitGroupCreation();
    returnToGroupPage();
  }

  private void returnToGroupPage() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void submitGroupCreation() {
    driver.findElement(By.linkText("group page")).click();
  }

  private void fillGroupForm(String name, String header, String footer) {
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(name);
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(header);
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(footer);
    driver.findElement(By.name("submit")).click();
  }

  private void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }

  private void goToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
