package ru.qa.addressbook.tests;


import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getGroupHelper().createGroup(new GroupData("TestTT", null, null));

  }

}