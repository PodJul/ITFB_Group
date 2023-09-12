package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstProductPageMarketYandex {
    WebDriver driver;
    // текст "Сравнить"
    private final By compareText = By.cssSelector("[data-auto='compare-button']");
    // название первого продукта
    private final By whiskasProductName = By.xpath("//h1[@data-additional-zone='title']");
    public FirstProductPageMarketYandex (WebDriver driver) {
        this.driver = driver;
    }
    @Step("Wait for load first product page")
    public void waitForLoadFirstProductPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(compareText));
    }
    @Step("Click compare text")
    public void clickCompareText() {driver.findElement (compareText).click();
        }
    @Step("Get name of Whiskas product")
    public String getWhiskasProductName() {
        return driver.findElement(whiskasProductName).getText();}
    @Step("Add first product to comparison")
    public void addFirstProductToComparison (){
        waitForLoadFirstProductPage();
        clickCompareText();
    }
}

