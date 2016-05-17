package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.addressbook.model.GroupData;


public class GroupHelper extends HelperBase{

    public GroupHelper (FirefoxDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        click(By.xpath("//div[@id='content']/form"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
        
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
