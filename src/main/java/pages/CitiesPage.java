package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }
    public WebElement getNewItemInput() {
        return driver.findElement(By.id("name"));
    }
    public void waitForDialogForCreatingAndEditingToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }
    public void waitForDialogForDeleteToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='v-dialog v-dialog--active']/div")));
    }
    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("//button/span[contains(text(), 'Delete')]"));
    }
    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//button/span[contains(text(), 'Save')]"));
    }
    public void waitForRowsToBePresent (int numberOfRows) {
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody"), numberOfRows));
    }
    public WebElement getCellFromTheRow (int cell, int row) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td["+cell+"]"));
    }
    public WebElement getEditButtonFromTheRow (int row) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td/div/button[@id='edit']"));
    }
    public WebElement getDeleteButtonFromTheRow (int row) {
        return driver.findElement
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr["+row+"]/td/div/button[@id='delete']"));
    }

}
