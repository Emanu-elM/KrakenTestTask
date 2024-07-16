package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PricesPage extends Form {
    public PricesPage() { super(By.xpath("//div[@id = 'kraken-tabpanel-0']"), "Top screen panel"); }

    private final ITextBox searchCurrencyInput = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Search all')]"), "Search all cryptocurrencies input");
    String currencyRowXpath = "//a[contains(@class, '%s')]";

    public void goToGivenCurrency(String cryptoName){
        IButton currencyRow = getElementFactory().getButton(By.xpath(String.format(currencyRowXpath, cryptoName)), "Result currency row");

        searchCurrencyInput.clearAndType(cryptoName);
        currencyRow.state().waitForClickable();
        currencyRow.click();
    }



}
