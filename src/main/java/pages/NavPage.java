package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//a[@href='/home']"));
    }
    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//a[@href='/about']"));
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    public void waitForLogoutButtonToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]")));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]"));
    }
    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement getLanguageButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getEnglishLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div"));
    }
    public WebElement getSpanishLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[2]"));
    }
    public WebElement getFrenchLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[3]"));
    }
    public WebElement getChineseLanguageButton() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[4]"));
    }
    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//a[@href='/profile']"));
    }
    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesLink() {
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }
    public WebElement getUsersLink() {
        return driver.findElement(By.xpath("//a[@href='/admin/users']"));
    }
    public WebElement getHeader() {
        return driver.findElement(By.xpath("//div[@class='layout row wrap']/div/h1"));
    }



}
