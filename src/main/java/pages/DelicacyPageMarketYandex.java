package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



public class DelicacyPageMarketYandex {
    WebDriver driver;
    // поле ввода "цены от"
    private final By priceFromField = By.xpath("//input[starts-with(@id,'range-filter-field-glprice_') and contains(@id,'_min')]");
    // поле ввода "цены до"
    private final By priceToField = By.xpath("//input[starts-with(@id,'range-filter-field-glprice_') and contains(@id,'_max')]");
    // чек-бокс способа доставки
    private final By deliveryCheckBox = By.cssSelector("[data-filter-value-id='offer-shipping_delivery']");
    // чек-бокс бренда "Whiskas"
    private final By whiskasCheckBox = By.xpath("//div[@class='_1WWgS _2J__K'][3]//span[contains(text(),'Whiskas')]");
    // текст "Показать всё"
    private final By showAllBrands = By.xpath("//span[contains(text(),'Показать всё')]");
    // чек-бокс бренда "Мнямс"
    private final By mnyamsCheckBox = By.xpath("//label[@data-auto='filter-list-item-10739158']");
    // изображение первого товара в списке
    private final By firstProduct = By.xpath("//div[@data-index='0']//article/a[@href]");
    // изображение второго товара в списке
    private final By secondProduct = By.xpath("//div[@data-index='1']//div[@class='_2im8- _2S9MU _2jRxX'][2]");

    public DelicacyPageMarketYandex(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Set price from value")
    public void setPriceFromValue (String priceFromValue) {
        driver.findElement(priceFromField).sendKeys(priceFromValue);
    }
    @Step("Set price to value")
    public void setPriceToValue(String priceToValue) {driver.findElement(priceToField).sendKeys(priceToValue);
    }
    public void scrollDeliveryCheckBox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(deliveryCheckBox));}
    @Step("Choose delivery method")
    public void chooseDeliveryMethod() {driver.findElement(deliveryCheckBox).click();}
    public void scrollShowAllBrands() {
        driver.manage().timeouts().implicitlyWait (15, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("scroll(0, -250);",
                driver.findElement(showAllBrands));
        }
    @Step("Show all brands")
    public void showAllBrands() {driver.findElement(showAllBrands).click();}
    @Step("Choose Whiskas brand")
    public void chooseWhiskasBrand() {driver.findElement(whiskasCheckBox).click();}
    @Step("Choose Mnyams brand")
    public void chooseMnyamsBrand() {
        driver.findElement(mnyamsCheckBox).click();}
    @Step("Get first product in the order")
    public void getFirstProduct() {
        driver.findElement(firstProduct).click();
        for (String tab: driver.getWindowHandles()){driver.switchTo().window(tab);}
        }
        @Step("Get second product in the order")
    public void getSecondProduct() {
        driver.findElement(secondProduct).click();
        for (String tab: driver.getWindowHandles()){driver.switchTo().window(tab);}}

    @Step("Return to the previous page")
    public void getPreviousPage() {
        ArrayList<String>newTab=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));}
    @Step("Set filters with Whiskas")
    public void setWhiskasFilters(String priceFromValue,String priceToValue) {
        setPriceFromValue(priceFromValue);
        setPriceToValue(priceToValue);
        scrollDeliveryCheckBox();
        chooseDeliveryMethod();
        scrollShowAllBrands();
        showAllBrands();
        chooseWhiskasBrand();}
    @Step("Set filters with Mnyams")
    public void setMnyamsFilters() {
        getPreviousPage();
        chooseMnyamsBrand();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(whiskasCheckBox));
        chooseWhiskasBrand();}
   }