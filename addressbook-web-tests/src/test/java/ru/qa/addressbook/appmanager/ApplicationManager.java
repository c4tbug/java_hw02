package ru.qa.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.addressbook.ContactCreationTests;

import java.util.concurrent.TimeUnit;

/**
 * Created by lero on 5/12/16.
 */
public class ApplicationManager {
    public static ContactCreationTests app;
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private  GroupHelper groupHelper;



    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }



    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
