import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends BasePage{

    private final By myAccountLocator = By.id("btnMyAccount");
    private final By logOutButtonLocator = By.xpath("//ul[@class='dropdown-menu dropdown-menu-home account']/li[6]");
    private final By loginLocator = By.id("type");
    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public void logOut(){
        waitForClick(myAccountLocator);
        waitForClick(logOutButtonLocator);
    }

    public String isLogoutOperationSuccess(){
        waitForPresence(loginLocator);
        return driver.findElement(loginLocator).getText();
    }
}
