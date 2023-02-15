package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTests extends BasicTest{

    @Test (priority = 10)
    @Description ("Test #1: Visits the signup page")
    public void visitsTheSignupPage() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain /signup.");
    }
    @Test (priority = 20)
    @Description ("Test #2: Checks input types")
    public void checksInputTypes() {
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email",
                "Type does not match.");
        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), "password",
                "Type does not match.");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), "password",
                "Type does not match.");
    }
    @Test (priority = 30)
    @Description ("Test #3: Displays errors when user already exists")
    public void displaysErrorWhenUserAlreadyExists() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain /signup.");
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(), "E-mail already exists",
                "Error message does not match.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL does not contain /signup.");
    }
    @Test (priority = 40)
    @Description ("Test #4: Signup")
    public void signup() throws InterruptedException {
        navPage.getSignUpButton().click();
        signupPage.getNameInput().sendKeys("Nikoleta Vdovenko");
        signupPage.getEmailInput().sendKeys("nikoleta.vdovenko@itbootcamp.rs");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        navPage.getHomeLink().click();
        messagePopUpPage.waitForVerifyAccountDialogToBePresent();
        Thread.sleep(2000);
        Assert.assertEquals(messagePopUpPage.getVerifyAccountDialogTitle().getText(),
                "IMPORTANT: Verify your account", "Message does not match.");
        messagePopUpPage.getVerifyAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }
}
