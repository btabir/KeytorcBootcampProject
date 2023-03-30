import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {

    private final By closePopLocator = By.id("closePop");
    private final By totalPriceLocator = By.className("basket-ordersummary__total");
    private final By realPriceLocator = By.className("product-list__price");
    private final By cartPriceLocator = By.xpath("//td[@class='text-right active']/strong");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void closePop() {
        waitForClick(closePopLocator);
    }

    public boolean isOnPaymentPage() {
        waitForPresence(totalPriceLocator);
        return isDisplayed(totalPriceLocator);
    }

    public double realPrice() {
        waitForPresence(realPriceLocator);
        return Double.parseDouble(find(realPriceLocator).getText().trim()); //trimlemezsek sondaki 0 i gostermiyor
    }

    public double paymentPagePrice() {
        waitForPresence(cartPriceLocator);
        String cartPriceText = find(cartPriceLocator).getText().trim();
        return Double.parseDouble(cartPriceText.replace(",", ""));
    }
}
