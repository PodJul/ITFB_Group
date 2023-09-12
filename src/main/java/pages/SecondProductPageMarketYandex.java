package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondProductPageMarketYandex {
    WebDriver driver;
    // текст "Сравнить"
    private final By compareText = By.cssSelector("[data-auto='compare-button']");
    // кнопка "Сравнить"
    private final By compareButton = By.cssSelector("[href='/my/compare-lists']");
    // название второго продукта
    private final By mnyamsProductName = By.xpath("//h1[@data-additional-zone='title']");
    public SecondProductPageMarketYandex (WebDriver driver) {
        this.driver = driver;
    }
    @Step("Wait for load second product page")
    public void waitForLoadSecondProductPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(compareText));}
    @Step("Click compare text")
    public void clickCompareText() {driver.findElement (compareText).click();}
    @Step("Click compare button")
    public void clickCompareButton() {driver.findElement (compareButton).click();
        for (String tab: driver.getWindowHandles()){driver.switchTo().window(tab);}
    }
    @Step("Get name of Mnyams product")
    public String getMnyamsProductName() {
        return driver.findElement(mnyamsProductName).getText();}
    @Step("Add second product to comparison")
    public void addSecondProductToComparison (){
       // waitForLoadSecondProductPage();
        clickCompareText();
        clickCompareButton();
    }
    }

