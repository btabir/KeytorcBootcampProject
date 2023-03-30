import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage{
    private final By productListLocator = By.className("product-list__product-code");
    private final By sortButtonLocator = By.id("sortOptionsDesktop");
    private final By increasingByPriceLocator = By.xpath("//option[@value='UP']");
    private final By productsLoadListLocator = By.className("product-list__product-name");
    private final By getFirstProductsPriceLocator = By.xpath("//span[@class='product-list__price'][1]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return isDisplayed(productListLocator);
    }

    public void sortProducts(){
        waitForClick(sortButtonLocator);
        waitForClick(increasingByPriceLocator);
    }

    private List<WebElement> getAllProducts(){
        waitForPresence(productsLoadListLocator);
        return findAll(productsLoadListLocator);
    }

    public void selectProduct(int productNumber){
        getAllProducts().get(productNumber).click();
    }

    public String cheapestProduct(){
        waitForPresence(getFirstProductsPriceLocator);
        return find(getFirstProductsPriceLocator).getText();
    }
}
