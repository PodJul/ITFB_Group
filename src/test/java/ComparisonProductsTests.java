import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ComparisonProductsTests extends BaseTest {
    HomePageMarketYandex objHomePage;
    DelicacyPageMarketYandex objDelicacyPage;
    FirstProductPageMarketYandex objFirstProductPage;
    SecondProductPageMarketYandex objSecondProductPage;
    ComparisonPageMarketYandex objComparisonPage;

    @Before

    public void createUser() {
        objHomePage = new HomePageMarketYandex(driver);
        objDelicacyPage = new DelicacyPageMarketYandex(driver);
        objFirstProductPage = new FirstProductPageMarketYandex(driver);
        objSecondProductPage = new SecondProductPageMarketYandex(driver);
        objComparisonPage = new ComparisonPageMarketYandex(driver);
    }

    @Test
    @DisplayName("Check products names")
    public void checkProductsNames() {
        objHomePage.getDelicacyPage();
        objDelicacyPage.setWhiskasFilters("50", "1000");
        objDelicacyPage.getFirstProduct();
        objFirstProductPage.addFirstProductToComparison();
        String expectedFirstProduct = objFirstProductPage.getWhiskasProductName();
        System.out.println(expectedFirstProduct);
        objDelicacyPage.setMnyamsFilters();
        objDelicacyPage.getSecondProduct();
        String expectedSecondProduct = objSecondProductPage.getMnyamsProductName();
        System.out.println(expectedSecondProduct);
        objSecondProductPage.addSecondProductToComparison();
        String actualFirstProduct = objComparisonPage.getFirstNameProduct();
        System.out.println(actualFirstProduct);
        String actualSecondProduct = objComparisonPage.getSecondNameProduct();
        System.out.println(actualSecondProduct);
        assertThat(String.valueOf(expectedFirstProduct.contains(actualFirstProduct)),true);
        assertThat(String.valueOf(expectedSecondProduct.contains(actualSecondProduct)),true);
    }
    @Test
    @DisplayName("Check sum of products prices")
    public void checkPriceSum() {
        objHomePage.getDelicacyPage();
        objDelicacyPage.setWhiskasFilters("50", "1000");
        objDelicacyPage.getFirstProduct();
        objFirstProductPage.addFirstProductToComparison();
        objDelicacyPage.setMnyamsFilters();
        objDelicacyPage.getSecondProduct();
        objSecondProductPage.addSecondProductToComparison();
        int firstProductPrice = Integer.parseInt((objComparisonPage.getWhiskasProductPrice()).substring(0,3));
        System.out.println(firstProductPrice);
        int secondProductPrice = Integer.parseInt((objComparisonPage.getMnyamsProductPrice()).substring(0,3));
        System.out.println(secondProductPrice);
        int sum=firstProductPrice+secondProductPrice;
        System.out.println(sum);
        assertTrue(sum<=2000);
    }
    @Test
    @DisplayName("Check Whiskas product was delete from comparison")
    public void checkDeleteWhiskasProduct() {
        objHomePage.getDelicacyPage();
        objDelicacyPage.setWhiskasFilters("50", "1000");
        objDelicacyPage.getFirstProduct();
        objFirstProductPage.addFirstProductToComparison();
        objDelicacyPage.setMnyamsFilters();
        objDelicacyPage.getSecondProduct();
        objSecondProductPage.addSecondProductToComparison();
        objComparisonPage.deleteWhiskasProduct();
        assertTrue(objComparisonPage.isWhiskasProductDisplayed());
    }
    @Test
    @DisplayName("Check delete list button works")
    public void checkDeleteListButton() {
        objHomePage.getDelicacyPage();
        objDelicacyPage.setWhiskasFilters("50", "1000");
        objDelicacyPage.getFirstProduct();
        objFirstProductPage.addFirstProductToComparison();
        objDelicacyPage.setMnyamsFilters();
        objDelicacyPage.getSecondProduct();
        objSecondProductPage.addSecondProductToComparison();
        objComparisonPage.deleteList();
        assertTrue(objComparisonPage.isNothingToCompareTextVisible());
    }
}



