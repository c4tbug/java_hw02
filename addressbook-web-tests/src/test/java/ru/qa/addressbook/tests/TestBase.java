package ru.qa.addressbook.tests;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.qa.addressbook.appmanager.ApplicationManager;


public class TestBase extends ApplicationManager{

    public  ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }


    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
