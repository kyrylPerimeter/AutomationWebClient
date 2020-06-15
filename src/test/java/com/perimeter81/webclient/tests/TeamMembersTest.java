package com.perimeter81.webclient.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TeamMembersTest extends TestBase {

    String url = "https://dnspremium.perimeter81.com/team/members";

    @BeforeMethod
    public void checkMyCurrentPage() throws InterruptedException {
        session.myCurrentPage(url);
        System.out.println("executed");
    }
    @Test(priority = 1)
    public void inviteMember() throws InterruptedException {
        //Invite Members button
        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_outline__3H9lB Button_invert__1WAql Button_small__1WtpK ControlButtons_createButton__1kY8A']"));
        //add email address field
        session.type(By.xpath("//input[@placeholder='Add email address here, separated with commas or spaces']"), "kyryl@perimeter81.com ");
        //Invite Members button (pop up)
        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_primary__3FZ3f Button_small__1WtpK Footer_buttonsCell__Dv5iV']"));
        String str1 = session.findElemetnReturnString(By.xpath("//span[contains(text(),'kyryl@perimeter81.com')]"));
        Assert.assertEquals(str1, "kyryl@perimeter81.com");
    }

    @Test(priority = 2)
    public void deleteMember() throws InterruptedException {
        Thread.sleep(10000);
       List<WebElement> numberOfMembersBefore = session.driver.findElements(By.xpath("//*[@class=\"MembersGridRow_base__28p_k Row_withBorder__19nL4\"]"));
       int membersBefore = numberOfMembersBefore.size();
        session.click(By.xpath("//tr[1]//td[6]//span[1]//div[1]//button[1]")); // click on trash - icon
        Thread.sleep(2000);
        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_primary__3FZ3f Button_small__1WtpK Footer_buttonsCell__Dv5iV']")); // delete - button
        Thread.sleep(2000);
        List<WebElement> numberOfMembersAfter = session.driver.findElements(By.xpath("//*[@class=\"MembersGridRow_base__28p_k Row_withBorder__19nL4\"]"));
        int membersAfter = numberOfMembersAfter.size();
        Assert.assertEquals(membersBefore, membersAfter + 1);
        Thread.sleep(2000);
    }


     @Test(priority = 3)
    public void changeRole() throws InterruptedException {
        session.click(By.xpath("//tr[1]//td[6]//button[1]//span[1]"));
        session.click(By.xpath("//button[contains(text(),'Change role')]"));
        session.click(By.xpath("//h6[contains(text(),'Admin')]"));
        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_primary__3FZ3f Button_small__1WtpK ChangeMemberRole_buttonsCell__U1Zg3']"));
        Thread.sleep(3000);
        String str = session.findElemetnReturnString(By.xpath("//tbody[@class='Body_base__1gTlH']//tr[1]//td[3]"));
        Assert.assertEquals(str, "Admin");
        Thread.sleep(2000);
    }
    


    @Test(priority = 4)
    public void filterByMemeberNameOrEmail() throws InterruptedException {
        session.type(By.xpath("//input[@placeholder='Filter by member name or email']"), "kyryl+test@perimeter81.com");
       // Thread.sleep(4000);
        String str = session.findElemetnReturnString(By.xpath("//mark[contains(@class,'EntityText_highlight__2rgkS')]"));
        Assert.assertEquals(str, "kyryl+test@perimeter81.com");
        Thread.sleep(2000);
    }



     @Test(priority = 5)
     public void clickOnActivityIcon() throws InterruptedException {
        session.click(By.xpath("//a[@class='MembersGridRow_activityLink__3ENL2']"));
        String str = session.findElemetnReturnString(By.xpath("//p[@class='Text_base__ghryT']"));
        System.out.println(str);
        Assert.assertEquals(str, "Monitor your network by identifying and classifying all your team's activities.");
        Thread.sleep(2000);
     }






    //@Test
    public void addMemberLicencesWithPaymentMethod() throws InterruptedException {

        String str1 = session.findElemetnReturnString(By.xpath("//span[@class='LicensesRemaining_count__1m4vH']"));
        String[] res1 = str1.split("/");
        int x1 = Integer.parseInt(res1[1]);
        System.out.println(x1);

        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_primary__3FZ3f Button_small__1WtpK']"));
        session.type(By.xpath("//input[@name='amount']"), "0");
        session.click(By.xpath("//button[@class='Button_base__3BYBd Button_primary__3FZ3f Button_small__1WtpK Footer_buttonsCell__Dv5iV']"));
        Thread.sleep(3000);
        String str2 = session.findElemetnReturnString(By.xpath("//span[@class='LicensesRemaining_count__1m4vH']"));
        String[] res2 = str2.split("/");
        int x2 = Integer.parseInt(res2[1]);
        Assert.assertEquals(x1 + 10, x2);
    }
}
