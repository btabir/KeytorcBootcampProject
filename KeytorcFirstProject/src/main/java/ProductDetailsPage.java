import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    private final By addToCartButton = By.xpath("//button[@data-value='Sepete Ekle']");
    private final By closeButton = By.xpath("//button[@class='fancybox-button fancybox-close-small']");
    private final By cartCountLocator = By.className("btn-basket--count");
    private final By myCartButtonLocator = By.id("btnMyBasket");
    private final By getSelectedProductPriceLocator = By.xpath("//span[@class='product-list__price'][1]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailsPage(){
        waitForPresence(addToCartButton);
        return isDisplayed(addToCartButton);
    }

    public void addToCart(){
        waitForClick(addToCartButton);
        waitForClick(closeButton);
    }

    private int getCartCount(){
        waitForPresence(cartCountLocator);
        String counter = find(cartCountLocator).getText();
        return Integer.parseInt(counter);
    }

    public boolean isCartCountUp() {
        return getCartCount()>0;
    }

    public void goToCart(){
        waitForClick(myCartButtonLocator);
    }

    public String selectedProductPrice(){
        waitForPresence(getSelectedProductPriceLocator);
        return find(getSelectedProductPriceLocator).getText();
    }
}
