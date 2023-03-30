import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void type(By locator,String text){
        find(locator).sendKeys(text);
    }

    public void  searchOperation(By textLocator,String text,By searchButtonLocator) {
        type(textLocator,text);
        waitForClick(searchButtonLocator);
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void waitForPresence(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForClick(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
