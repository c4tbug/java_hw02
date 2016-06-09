package ru.qa.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddressTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().gotoHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("TesT").withLastname("TestS").withPhone("78885521").withMail("test1@@.dd"));
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    }

    public static String cleaned(String address) {
        return address.replaceAll("\\s", "");
        }
}