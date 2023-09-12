package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.NoSuchElementException;

public class ComparisonPageMarketYandex {
    WebDriver driver;
    // имя первого добавленного товара в списке
    private final By firstProduct = By.xpath("//div[@class='Lwwoc _2VGDF'][2]");
    // имя второго добавленного товара в списке
    private final By secondProduct = By.xpath("//div[@class='Lwwoc _2VGDF'][1]");
    // цена первого добавленного товара в списке
    private final By firstPrice = By.xpath("//div[@class='_1P4gD _13hzP']//div[@class='Lwwoc'][2]//span[@data-autotest-value]");
    // цена второго добавленного товара в списке
    private final By secondPrice = By.xpath("//div[@class='_1P4gD _13hzP']//div[@class='Lwwoc'][1]//span[@data-autotest-value]");
    // кнопка "Удалить список"
    private final By deleteListButton = By.xpath("//button[contains(text(),'Удалить список')]");
    // текст "Сравнивать пока нечего"
    private final By nothingToCompareText = By.xpath("//h2[contains(text(),'Сравнивать пока нечего')]");
    // кнопка "Удалить продукт"
    private final By deleteProductButton = By.xpath("//div[@class='Lwwoc _2VGDF'][2]//div[@class='vn_Oq']//button[@class='_1KpjX _2bqiO']");

    public ComparisonPageMarketYandex(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get name of first product")
    public String getFirstNameProduct() {
        return driver.findElement(firstProduct).getText();
    }
    @Step("Get name of second product")
    public String getSecondNameProduct() {
        return driver.findElement(secondProduct).getText();
    }

    @Step("Get price of first product")
    public String getWhiskasProductPrice() {
        return driver.findElement(firstPrice).getText();
    }

    @Step("Get price of Mnyams product")
    public String getMnyamsProductPrice() {
        return driver.findElement(secondPrice).getText();
    }

    @Step("Delete list of products")
    public void deleteList() {
        driver.findElement(deleteListButton).click();
    }

    @Step("Check that there is nothing to compare")
    public boolean isNothingToCompareTextVisible() {
        return driver.findElement(nothingToCompareText).isDisplayed();
    }

    @Step("Delete Whiskas products")
    public void deleteWhiskasProduct() {
        WebElement webElement = driver.findElement(firstProduct);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
        driver.findElement(deleteProductButton).click();
        driver.navigate().refresh();
    }

    @Step("Check that Whiskas product is displayed")
    public boolean isWhiskasProductDisplayed() {
        try {
            driver.findElement(firstProduct);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}