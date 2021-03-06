package ru.qa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;
import ru.qa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("TestTT"));
        }
    }

        @Test
        public void testGroupModification () {
            Groups before = app.db().groups();
            GroupData modifiedGroup = before.iterator().next();
            GroupData group = new GroupData()
                    .withId(modifiedGroup.getId()).withName("TestT1").withHeader("TestT2").withFooter("TestT3");
            app.group().modify(group);
            assertThat(app.group().count(), equalTo(before.size()));
            Groups after = app.db().groups();
            assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        }

    }
