package ru.qa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().gotoHomePage();
            app.contact().create(new ContactData().withName("TestT"));
        }
    }

    @Test
    public void testContactModification () {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("TesT").withLastname("TestS").withPhone("78885525").withMail("test@@.dd");
        app.contact().gotoHomePage();
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }

}
