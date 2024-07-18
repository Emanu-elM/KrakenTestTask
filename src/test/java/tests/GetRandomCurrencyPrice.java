package tests;

import enums.PeriodOfTime;
import forms.pages.CurrencyPricePage;
import forms.pages.MainKrakenPage;
import forms.pages.PricesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requests.Requests;
import utilities.TestData;

public class GetRandomCurrencyPrice extends BaseTest {

    String currencyName;
    String currencyToCompare;
    Double priceValue;

    @BeforeTest
    public void getValues() {
        currencyName = Requests.getRandomCrypto();
        currencyToCompare = TestData.getStringValue("currencyToCompare");
        priceValue = Requests.getPriceValue(currencyName, currencyToCompare);
    }

    @Test
    public void verifyCurrencyPrice() {
        MainKrakenPage mainKrakenPage = new MainKrakenPage();
        mainKrakenPage.acceptCookies();

        mainKrakenPage.clickPricesHeaderButton();
        PricesPage pricesPage = new PricesPage();
        Assert.assertTrue(pricesPage.state().isDisplayed(), "The prices page is not displayed");

        pricesPage.goToGivenCurrency(currencyName);
        CurrencyPricePage currencyPricePage = new CurrencyPricePage();
        Assert.assertTrue(currencyPricePage.state().isDisplayed(), "The currency price page is not displayed");

        currencyPricePage.clickTimeSelector(PeriodOfTime.valueOf(TestData.getStringValue("timeToAnalyze")));
        double lowestPrice = currencyPricePage.getLowestPriceValue();
        double highestPrice = currencyPricePage.getHighestPriceValue();

        currencyPricePage.verifyPrice(lowestPrice, highestPrice, priceValue);
    }
}
