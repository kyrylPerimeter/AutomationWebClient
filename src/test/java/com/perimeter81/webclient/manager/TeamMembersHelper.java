package com.perimeter81.webclient.manager;

import com.perimeter81.webclient.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TeamMembersHelper extends TestBase {


    public int countMembers(){

        List<WebElement> numberOfMembersBefore = session.driver.findElements(By.xpath("//*[@class=\"MembersGridRow_base__28p_k Row_withBorder__19nL4\"]"));
        int membersOnPage = numberOfMembersBefore.size();

        return membersOnPage;
    }


}