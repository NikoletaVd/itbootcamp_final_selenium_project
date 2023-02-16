package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheAdminCitiesPageAndListCities() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "URL does not match");
    }
    @Test (priority = 20)
    @Description ("Test #2: Checks input types for create/edit new city")
    public void checkInputTypesForCreateEditNewcity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogForCreatingAndEditingToBeVisible();
        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"), "text",
                "Type does not match.");
    }
    @Test (priority = 30)
    @Description ("Test #3: Create new city")
    public void createNewCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDialogForCreatingAndEditingToBeVisible();
        citiesPage.getNewItemInput().sendKeys("Nikoleta Vdovenko's city");
        citiesPage.getSaveButton().click();
        Assert.assertTrue(messagePopUpPage.getConfirmationMessage().getText().contains("Saved successfully"),
                "Message does not match.");
     }
    @Test (priority = 40)
    @Description ("Test #4: Edit city")
    public void editCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Nikoleta Vdovenko's city");
        citiesPage.waitForRowsToBePresent(1);
        citiesPage.getEditButtonFromTheRow(1).click();
        citiesPage.getNewItemInput().click();
        citiesPage.getNewItemInput().sendKeys(Keys.COMMAND + "a");
        citiesPage.getNewItemInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNewItemInput().sendKeys("Nikoleta Vdovenko's city edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUpToBePresent();
        Assert.assertTrue(messagePopUpPage.getConfirmationMessage().getText().contains("Saved successfully"),
                "Message does not match.");
    }
    @Test (priority = 50)
    @Description ("Test #5: Search city")
    public void searchCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Nikoleta Vdovenko's city edited");
        citiesPage.waitForRowsToBePresent(1);
        Assert.assertTrue(citiesPage.getCellFromTheRow(2, 1).getText().
                        contains("Nikoleta Vdovenko's city edited"), "Text does not match.");
    }
    @Test (priority = 60)
    @Description ("Test #5: Delete city")
    public void deleteCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Nikoleta Vdovenko's city edited");
        citiesPage.waitForRowsToBePresent(1);
        Assert.assertTrue(citiesPage.getCellFromTheRow(2, 1).getText().
                        contains("Nikoleta Vdovenko's city edited") , "Text does not match.");
        citiesPage.getDeleteButtonFromTheRow(1).click();
        citiesPage.waitForDialogForDeleteToBeVisible();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForPopUpToBePresent();
        Assert.assertTrue(messagePopUpPage.getConfirmationMessage().getText().contains("Deleted successfully"),
                "Message does not match");
    }

}
