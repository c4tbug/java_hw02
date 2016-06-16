package ru.qa.addressbook.appmanager;


import org.openqa.selenium.*;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);

    }

    public void returnToHomePage() {
        click(By.xpath("//*[@id='logo']"));
    }

    public void gotoHomePage() {
        click(By.xpath("//*[@id='nav']/ul/li[1]/a"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    private void click() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getMail());
        type(By.name("email2"), contactData.getSecondEmail());
        type(By.name("email3"), contactData.getThirdEmail());
        attach(By.name("photo"), contactData.getPhoto());
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initContactCreation() {
        click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        Alert alt = wd.switchTo().alert();
        alt.accept();
    }

    private void goToModification() {
        wd.findElement(By.name("modifiy")).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }


    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification();
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
        returnToHomePage();
    }

    private void selectContactGetInfo(int id) {
        wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            String address = element.findElement(By.xpath(".//td[4]")).getText();
            contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname)
                    .withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        selectContactById(contact.getId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String phone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workphone = wd.findElement(By.name("work")).getAttribute("value");
        String mail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname)
                .withPhone(phone).withMobilePhone(mobilephone).withWorkPhone(workphone).withAddress(address)
                .withMail(mail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);

    }

    public ContactData infoFromModifyForm(ContactData contact) {
        selectContactGetInfo(contact.getId());
        goToModification();
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String phone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workphone = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String mail = wd.findElement(By.name("email")).getAttribute("value");
        String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
        String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname)
                .withPhone(phone).withMobilePhone(mobilephone).withWorkPhone(workphone).withAddress(address)
                .withMail(mail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
    }


    public ContactData infoFromDetailsForm(ContactData contact) {
        String contactInfo;
        selectContactGetInfo(contact.getId());
        String data = wd.findElement(By.id("content")).getText();
        if (isElementPresent(By.xpath(".//i"))) {
            String group = wd.findElement(By.xpath(".//i")).getText();
            contactInfo = data.replace(group, "");
        } else {
            contactInfo = data;
        }
        wd.navigate().back();
        return new ContactData().withData(contactInfo);

    }
}


