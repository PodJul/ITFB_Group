package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageMarketYandex {
    WebDriver driver;
    // кнопка "Каталог"
    private final By catalogButton = By.xpath ("//div[@data-apiary-widget-name='@light/NavigationMenu']");
    // текст "Зоотовары"
    private final By zooButton = By.cssSelector("._1010X[href='/catalog--tovary-dlia-zhivotnykh/54496']");
    // текст "Лакомства"
    private final By delicacyButton = By.cssSelector("[href='/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668']");
    public HomePageMarketYandex(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Wait for load home page")
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(catalogButton));
    }
    @Step("Click Catalog button on home page")
    public void clickCatalogButton() {
        driver.findElement (catalogButton).click();
    }

    public void scrollZooButton() {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(zooButton));}

    @Step ("Move to Zoo button on home page")
    public void moveToZooButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(zooButton));
        WebElement webElement = driver.findElement (zooButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();}
    public void scrollDelicacyButton() {
        ((JavascriptExecutor) driver).executeScript("scroll(0, -250);",
                driver.findElement(delicacyButton));}
    @Step("Click Delicacy button")
    public void clickDelicacyButton() {
        driver.findElement (delicacyButton).click();}
    @Step("Get Delicacy page")
    public void getDelicacyPage() {
        waitForLoadHomePage();
        clickCatalogButton();
        scrollZooButton();
        moveToZooButton();
        scrollDelicacyButton();
        clickDelicacyButton();}
        }


