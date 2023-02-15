package tests;

import jdk.jfr.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
    @Test (priority = 10)
    @Description ("Test #1: Set locale to ES")
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Página de aterrizaje",
                "Header does not match.");
    }
    @Test (priority = 20)
    @Description ("Test #2: Set locale to EN")
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Landing",
                "Header does not match.");
    }
    @Test (priority = 30)
    @Description ("Test #3: Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertEquals(navPage.getHeader().getText(), "首页", "Header does not match.");
    }
    @Test (priority = 40)
    @Description ("Test #4: Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertEquals(navPage.getHeader().getText(), "Page d'atterrissage",
                "Header does not match.");
    }
}
