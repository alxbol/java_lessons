package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private final String browser;
    private final Properties properties;
    WebDriver wd;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));
//        if (browser.equals(BrowserType.CHROME)) {
//            wd = new ChromeDriver();
//        } else if (browser.equals(BrowserType.FIREFOX)) {
//            wd = new FirefoxDriver();
//        }
//
//        new WebDriverWait(wd, Duration.ofSeconds(30));
//        wd.get(properties.getProperty("web.baseUrl"));
        String prop = properties.getProperty("web.baseUrl");
    }


    public void stop() {
        wd.quit();
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
