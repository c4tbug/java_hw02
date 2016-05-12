package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by lero on 5/12/16.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper (FirefoxDriver wd) {
        super(wd);
    }
    public void gotoGroupPage () {
        wd.findElement(By.linkText("groups")).click();
    }
}
