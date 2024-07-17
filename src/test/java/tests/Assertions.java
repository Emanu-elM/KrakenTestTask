package tests;

import org.testng.Assert;

public class Assertions {
    public static void verifyPrice(double lowestPrice, double highestPrice, double priceValue){
        boolean isPriceCorrect = priceValue <= highestPrice && priceValue >= lowestPrice;
        Assert.assertTrue(isPriceCorrect, "The price is not between the minimum and maximum price values for today ("+ priceValue + " Is not between lowest " + lowestPrice + " and highest " + highestPrice+ " )");
    }
}
