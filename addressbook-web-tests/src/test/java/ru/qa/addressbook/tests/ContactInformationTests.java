package ru.qa.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().gotoHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("TesT").withLastname("TestS").withPhone("78885521").withMail("test1@@.dd"));
        }
    }

    @Test
    public void testContactInformation() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        ContactData contactInfoFromModifyForm = app.contact().infoFromModifyForm(contact);

        assertThat(cleaned(contactInfoFromDetailsForm.getData()),
                equalTo(mergeInformation(contactInfoFromModifyForm)));
    }


    private String mergeInformation(ContactData contact) {
        return Arrays.asList(contact.getName(), contact.getLastname(), contact.getAddress(),
                contact.getPhone(), contact.getMobilephone(), contact.getWorkphone(), contact.getMail(),
                contact.getSecondEmail(), contact.getThirdEmail())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactInformationTests::cleaned)
                .collect(Collectors.joining(""));
    }

    private static String cleaned(String information) {
        return information.replaceAll("\\s", "").replaceAll("[-:HMW]", "").replaceAll("\\(.*?\\) ?", "");
    }

}

