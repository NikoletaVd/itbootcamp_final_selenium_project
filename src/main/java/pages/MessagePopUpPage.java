package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForPopUpToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-snack__wrapper')]")));
    }
    public void waitForPopUpToBePresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[contains(@class, 'v-snack__wrapper')]/div")));
    }
    public WebElement getErrorMessage() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper')]/div/ul/li"));
    }
    public WebElement getConfirmationMessage() {
        return driver.findElement
                (By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
    }
    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper')]/div/button"));
    }
    public void waitForVerifyAccountDialogToBePresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog--active')]/div")));
    }
    public WebElement getVerifyAccountDialogTitle() {
        return driver.findElement
                (By.xpath("//div[contains(@class, 'v-dialog--active')]/div/div[1]"));
    }
    public WebElement getVerifyAccountCloseButton() {
        return driver.findElement(By.className("btnClose"));
    }


}
