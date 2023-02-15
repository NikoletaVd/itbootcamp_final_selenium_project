package tests;

import jdk.jfr.Description;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test (priority = 10)
    @Description ("Test #1: Visits the login page")
    public void visitTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain /login.");
    }
    @Test (priority = 20)
    @Description ("Test #2: Checks input types")
    public void checkInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
                "Input type does not match.");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
                "Input type does not match.");
    }
    @Test (priority = 30)
    @Description ("Test #3: Displays errors when user does not exist")
    public void displaysErrorWhenUserDoesNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(), "User does not exists",
                "Error message does not match.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain /login.");
    }

    @Test (priority = 40)
    @Description ("Test #4: Displays errors when password is wrong")
    public void displaysErrorWhenPasswordIsWrong() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(), "Wrong password",
                "Error message does not match.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL does not contain /login.");
    }
    @Test (priority = 50)
    @Description ("Test #5: Login")
    public void successfulLogin() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "URL does not contain /home");
    }
    @Test (priority = 60)
    @Description ("Test #6: Logout")
    public void logout() {
        navPage.waitForLogoutButtonToBeVisible();
        navPage.getLogoutButton().click();
    }

}
