import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("pass");
    private final By loginButtonLocator = By.id("login-button");
    private final By myAccountLocator = By.id("type");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginOperation(String email,String password){
        waitForClick(emailLocator); //Tiklanabilirligi kontrol ediyoruz
        type(emailLocator,email);
        waitForClick(passwordLocator);
        type(passwordLocator,password);
        waitForClick(loginButtonLocator);
    }

    public String isLoginOperationSuccess(){
        waitForPresence(myAccountLocator);
        return driver.findElement(myAccountLocator).getText();
    }
}
