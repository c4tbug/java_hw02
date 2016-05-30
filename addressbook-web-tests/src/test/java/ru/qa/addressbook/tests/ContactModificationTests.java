package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification () {
        app.getContactHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact ()) {
            app.getContactHelper().createContact(new ContactData("TesT", null, null, null));

        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("TesT", "TestS", "78885525", "test@@.dd"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}
