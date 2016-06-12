package ru.qa.addressbook.generators;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.qa.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


        @Parameter(names = "-c", description = "Contact count")
        public int count;

        @Parameter(names = "-f", description = "Target file")
        public String file;

        @Parameter(names = "-d", description = "Data format")
        public String format;


        public static void main(String[] args) throws IOException {
            ru.qa.addressbook.generators.ContactDataGenerator generator = new ru.qa.addressbook.generators.ContactDataGenerator();
            JCommander jCommander = new JCommander(generator);

            try {
                jCommander.parse(args);
            } catch (ParameterException ex) {
                jCommander.usage();
                return;
            }
            generator.run();
        }


        private void run() throws IOException {
            List<ContactData> contacts = generateContact(count);
            if(format.equals("csv")) {
                saveAsCsv(contacts, new File(file));
            } else if (format.equals("xml")){
                saveAsXml(contacts, new File (file));
            } else {
                System.out.println("Unrecognized format" + format);
            }

        }

        private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
            XStream xStream = new XStream();
            xStream.processAnnotations(ContactData.class);
            String xml = xStream.toXML(contacts);
            try (Writer writer = new FileWriter(file)) {
                writer.write(xml);
            }
        }

        private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
            Writer writer = new FileWriter(file);
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getName(), contact.getLastname(),
                        contact.getPhone(), contact.getAddress(),contact.getMail()));
            }
            writer.close();
        }

        private List<ContactData> generateContact(int count) {
            List<ContactData> contacts = new ArrayList<ContactData>();
            for (int i = 0; i < count; i++) {
                contacts.add(new ContactData().withName(String.format("name %s", i))
                        .withLastname(String.format("lastname %s", i)).withPhone(String.format("12345 %s", i))
                .withAddress(String.format("address %s", i)).withMail(String.format("email@test.dd %s", i)));
            }

            return contacts;
        }
    }


