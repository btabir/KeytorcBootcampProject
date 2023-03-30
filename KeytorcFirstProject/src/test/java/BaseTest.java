import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Test adimlarini sirayla gerceklestirmek icin
public class BaseTest {

    static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +
                ("//chromedriver.exe"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //chrome versionu ile alakali sorunu cozmek icin
        driver = new ChromeDriver(options);
        driver.get("https://www.vatanbilgisayar.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        //driver.quit();
    }
}
