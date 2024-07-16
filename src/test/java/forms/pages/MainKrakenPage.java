package forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainKrakenPage extends Form {

    public MainKrakenPage() {
        super(By.xpath("//div[@data-testid = 'paragraph--hero_growth']"), "Invest in your future Div");
    }

    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//div[contains(@aria-label, 'Privacy')]//button[contains(text(), 'Accept')]"), "Accept cookies button");
    private final IButton pricesHeaderButton = getElementFactory().getButton(By.xpath("//li[@data-testid = 'top-nav-Prices']"), "Prices header button");

    public void clickPricesHeaderButton() {
        pricesHeaderButton.click();
    }

    public void acceptCookies(){
        acceptCookiesButton.state().waitForClickable();
        acceptCookiesButton.click();
    }

}
