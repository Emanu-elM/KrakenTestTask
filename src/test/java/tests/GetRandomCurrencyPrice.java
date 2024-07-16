package tests;

import forms.pages.CurrencyPricePage;
import forms.pages.MainKrakenPage;
import forms.pages.PricesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requests.Requests;

public class GetRandomCurrencyPrice extends BaseTest{

    String currencyName;
    Double priceValue;

    @BeforeTest
    public void getValues(){
        currencyName = Requests.getRandomCrypto();
        priceValue = Requests.getPriceValue(currencyName);
    }

    @Test
    public void verifyCurrencyPrice(){
        MainKrakenPage mainKrakenPage = new MainKrakenPage();
        PricesPage pricesPage = new PricesPage();
        CurrencyPricePage currencyPricePage = new CurrencyPricePage();

        mainKrakenPage.acceptCookies();

        mainKrakenPage.clickPricesHeaderButton();
        pricesPage.state().waitForDisplayed();
        Assert.assertTrue(pricesPage.state().isDisplayed(), "The prices page is not displayed");

        pricesPage.goToGivenCurrency(currencyName);
        currencyPricePage.state().waitForDisplayed();
        Assert.assertTrue(currencyPricePage.state().isDisplayed(), "The currency price page is not displayed");

        currencyPricePage.click24Hours();
        double lowestPrice = currencyPricePage.getLowestPriceValue();
        double highestPrice = currencyPricePage.getHighestPriceValue();

        boolean isPriceCorrect = priceValue <= highestPrice && priceValue >= lowestPrice;

        Assert.assertTrue(isPriceCorrect, "The price is not between the minimum and maximum price values for today");

    }
}
