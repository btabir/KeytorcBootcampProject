import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{
    private final By loginLocator = By.id("btnMyAccount");
    private final By loginLinkLocator = By.cssSelector("a[href='/login?returnUrl=%2F&logtab=signin']");
    private final By smallBannerLocator = By.id("smallBannerHide");
    private final By searchBoxLocator = By.id("navbar-search-input");
    private final By searchButtonLocator = By.className("search__button");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageOpened(){
        waitForPresence(smallBannerLocator);
        return isDisplayed(smallBannerLocator);
    }

    public void clickForLogin(){
        waitForClick(loginLocator);
        waitForClick(loginLinkLocator);
    }

    public void searchProduct(String text){
        waitForClick(searchBoxLocator);
        searchOperation(searchBoxLocator,text,searchButtonLocator);
    }

}
