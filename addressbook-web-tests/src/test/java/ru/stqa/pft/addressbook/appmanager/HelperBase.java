package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected final WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String firstname2) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(firstname2);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public void acceptAlert() {
        wd.switchTo().alert().accept();
    }
}
