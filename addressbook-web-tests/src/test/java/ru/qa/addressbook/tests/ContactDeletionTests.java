package ru.qa.addressbook.tests;


import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {


    
    @Test
    public void testContactDeletion() {
        app.getContactHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
    }

}
