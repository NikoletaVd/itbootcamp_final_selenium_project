package tests;

import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTests extends BasicTest{
    @Test (priority = 10)
    @Description ("Test #1: Visits the profile page")
    public void visitsTheProfilePage() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getMyProfileLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "URL does not contain /profile route.");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"), "admin@admin.com",
                "Email's input value is not admin@admin.com");
        navPage.getLogoutButton().click();
    }
    @Test (priority = 20)
    @Description ("Test #2: Checks input types")
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getMyProfileLink().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputEmailElement = profilePage.getEmailInput();
        String attrType = (String) js.executeScript("return arguments[0].getAttribute('type');",
                inputEmailElement);
        String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');",
                inputEmailElement);
        Assert.assertEquals(attrType, "email", "Type is not email.");
        Assert.assertEquals(attrDisabled, "disabled", "Value is not disabled.");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"), "text",
                "Name's input type is not text.");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"), "text",
                "City's input type is not text.");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"), "text",
                "Country's input type is not text.");
        Assert.assertEquals(profilePage.getTwitterInput().getAttribute("type"), "url",
                "Twitter's input type is not url.");
        Assert.assertEquals(profilePage.getGitHubInput().getAttribute("type"), "url",
                "GitHub's input type is not url.");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"), "tel",
                "Phone's input type is not tel.");
    }
    @Test (priority = 30)
    @Description ("Test #3: Edits profile")
    public void editsProfile() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getMyProfileLink().click();
        profilePage.getNameInput().click();
        profilePage.getNameInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getNameInput().sendKeys("Nikoleta Vdovenko");
        profilePage.getPhoneInput().click();
        profilePage.getPhoneInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getPhoneInput().sendKeys("+38161283223");
        profilePage.getCityInput().click();
        profilePage.getCityInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getCityInput().sendKeys("Bucaramanga");
        profilePage.getCountryInput().click();
        profilePage.getCountryInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getCountryInput().sendKeys("Spain");
        profilePage.getTwitterInput().click();
        profilePage.getTwitterInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getTwitterInput().sendKeys("https://twitter.com/profile/milan1232");
        profilePage.getGitHubInput().click();
        profilePage.getGitHubInput().sendKeys(Keys.COMMAND + "a" + Keys.BACK_SPACE);
        profilePage.getGitHubInput().sendKeys("https://github.com/NikoletaVd");
        profilePage.getSaveButton().click();
        messagePopUpPage.waitForPopUpToBePresent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profilePage.getProfileMessage().getText(), "Profile saved successfuly",
                "Message does not match.");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("value"), "Nikoleta Vdovenko",
                "Value does not match.");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("value"), "+38161283223",
                "Value does not match.");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("value"), "Bucaramanga",
                "Value does not match.");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("value"), "Spain",
                "Value does not match.");
        Assert.assertEquals(profilePage.getTwitterInput().getAttribute("value"),
                "https://twitter.com/profile/milan1232", "Value does not match.");
        Assert.assertEquals(profilePage.getGitHubInput().getAttribute("value"),
                "https://github.com/NikoletaVd", "Value does not match.");
        navPage.getLogoutButton().click();
    }

}
