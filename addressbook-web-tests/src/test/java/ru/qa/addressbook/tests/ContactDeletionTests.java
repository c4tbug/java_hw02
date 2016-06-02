package ru.qa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        app.getContactHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact ()) {
            app.getContactHelper().createContact(new ContactData("TesT", null, null, null));
        }
        List<ContactData> before = app.getContactHelper().getContactList ();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList ();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove (before.size() - 1);
        Assert.assertEquals (before, after);

    }

}
