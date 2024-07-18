package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import enums.PeriodOfTime;
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


    public void clickTimeSelector(PeriodOfTime time) {
        PeriodOfTime selectedOption = null;
        for (PeriodOfTime option : PeriodOfTime.values()) {
            if (option.getValue().equals(time.getValue())) {
                selectedOption = option;
                break;
            }
        }

        if (selectedOption == null) {
            throw new IllegalArgumentException("Invalid time option: " + time);
        }

        String formattedXPath = String.format(timeSelectorXPath, selectedOption.getValue());
        getElementFactory().getLabel(By.xpath(formattedXPath), "Time selector button").click();
    }

    public Double getHighestPriceValue() {
        return CurrenciesUtils.extractAmount(highestPrice.getText());
    }

    public Double getLowestPriceValue() {
        return CurrenciesUtils.extractAmount(lowestPrice.getText());
    }
}
