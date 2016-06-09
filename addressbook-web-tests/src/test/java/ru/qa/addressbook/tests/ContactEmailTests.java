package ru.qa.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactEmailTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().gotoHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("TesT").withLastname("TestS").withPhone("78885521").withMail("test1@@.dd"));
        }
    }

    @Test
    public void testContactEmail () {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }


    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getMail(), contact.getSecondEmail(), contact.getThirdEmail())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
        }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "");
    }


}
