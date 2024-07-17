package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utilities.CurrenciesUtils;

public class CurrencyPricePage extends Form {

    public CurrencyPricePage() {
        super(By.xpath("//div[contains(@class, 'price-chart-interaction-layer')]"), "Price chart");
        getElementFactory().getLabel(By.xpath("//div[contains(@class, 'price-chart-interaction-layer')]"), "Price chart").state().waitForDisplayed();
    }


    private final ILabel highestPrice = getElementFactory().getLabel(By.xpath("//div[@data-testid = 'stats-high']"), "Highest price label");
    private final ILabel lowestPrice = getElementFactory().getLabel(By.xpath("//div[@data-testid = 'stats-low']"), "Lowest price label");
    String timeSelectorXPath = "//span[contains(@title, '%s')]";


    public void clickTimeSelector(String time) {
        String formattedXPath;
        switch (time) {
            case "24H":
                formattedXPath = String.format(timeSelectorXPath, "24H");
                break;
            case "1W":
                formattedXPath = String.format(timeSelectorXPath, "1W");
                break;
            case "1M":
                formattedXPath = String.format(timeSelectorXPath, "1M");
                break;
            case "1Y":
                formattedXPath = String.format(timeSelectorXPath, "1Y");
                break;
            case "5Y":
                formattedXPath = String.format(timeSelectorXPath, "5Y");
                break;
            default:
                throw new IllegalArgumentException("Invalid time option: " + time);
        }
        getElementFactory().getLabel(By.xpath(formattedXPath), "Time selector button").click();
    }

    public Double getHighestPriceValue() {
        return CurrenciesUtils.extractAmount(highestPrice.getText());
    }

    public Double getLowestPriceValue() {
        return CurrenciesUtils.extractAmount(lowestPrice.getText());
    }
}
