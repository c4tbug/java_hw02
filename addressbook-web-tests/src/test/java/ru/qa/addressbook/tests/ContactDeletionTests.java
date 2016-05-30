package ru.qa.addressbook.tests;


import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        app.getContactHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact ()) {
            app.getContactHelper().createContact(new ContactData("TesT", null, null, null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
    }

}
