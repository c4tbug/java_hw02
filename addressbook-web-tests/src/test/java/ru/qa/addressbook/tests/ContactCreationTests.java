package ru.qa.addressbook.tests;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.contact().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withName("TesT").withLastname("TestS").withPhone("78885521").withMail("test1@@.dd");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() +1));

        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

}
