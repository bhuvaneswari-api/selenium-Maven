import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgTests {

    WebDriver driver;
    LaunchGoogle lg;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test(priority = 1)
    public void testing(){
        lg = new LaunchGoogle(driver);
        String pageTitle = lg.googleSearch("Paleo Friendly vegetables");
        Assert.assertTrue(pageTitle.equalsIgnoreCase("Paleo Friendly vegetables - Google Search"), "The page title does not match");
    }

    @Test(priority = 2)
    public void testing1(){
        driver.navigate().refresh();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
