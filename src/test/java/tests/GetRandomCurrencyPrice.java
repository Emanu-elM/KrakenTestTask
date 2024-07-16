package tests;

import forms.pages.CurrencyPricePage;
import forms.pages.MainKrakenPage;
import forms.pages.PricesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import requests.Requests;

public class GetRandomCurrencyPrice extends BaseTest{

    String cryptoName;

    @BeforeTest
    public void getValues(){
        cryptoName = Requests.getRandomCrypto();
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

        pricesPage.goToGivenCurrency(cryptoName);
        currencyPricePage.state().waitForDisplayed();
        Assert.assertTrue(currencyPricePage.state().isDisplayed(), "The currency price page is not displayed");

        currencyPricePage.click24Hours();
        double lowestPrice = currencyPricePage.getLowestPriceValue();
        double highestPrice = currencyPricePage.getHighestPriceValue();

        boolean isPriceCorrect = false;
        double expectedPrice = 0.5755000;

        if (expectedPrice <= highestPrice && expectedPrice >= lowestPrice){
            isPriceCorrect = true;
        }

        Assert.assertTrue(isPriceCorrect, "The price is not between the minimum and maximum price values for today");

    }
}
