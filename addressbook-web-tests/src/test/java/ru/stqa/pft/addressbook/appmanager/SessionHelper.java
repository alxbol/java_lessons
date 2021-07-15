package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {
    protected ChromeDriver wd;

    public SessionHelper(ChromeDriver wd) {
        super(wd);
    }

    protected void login(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}
