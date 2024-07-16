package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utilities.CurrenciesUtils;

public class CurrencyPricePage extends Form {
    public CurrencyPricePage() { super(By.xpath("//div[contains(@class, 'price-chart-interaction-layer')]"), "Price chart"); }

    private final IButton twentyFourHoursButton = getElementFactory().getButton(By.xpath("//span[contains(@title, '24H')]"), "24 hours button");
    private final ILabel highestPrice = getElementFactory().getLabel(By.xpath("//div[@data-testid = 'stats-high']"), "Highest price label");
    private final ILabel lowestPrice = getElementFactory().getLabel(By.xpath("//div[@data-testid = 'stats-low']"), "Lowest price label");

    public void click24Hours(){
        twentyFourHoursButton.click();
    }

    public Double getHighestPriceValue(){
        String value = CurrenciesUtils.cleanDollarSignPrefix(highestPrice.getText());
        return Double.parseDouble(value);
    }

    public Double getLowestPriceValue(){
        String value = CurrenciesUtils.cleanDollarSignPrefix(lowestPrice.getText());
        return Double.parseDouble(value);
    }
}
