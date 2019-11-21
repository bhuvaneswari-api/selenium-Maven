import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LaunchGoogle {
    WebDriver driver;
    By googleInput = By.xpath(".//input[@role='combobox']");

    public LaunchGoogle(WebDriver driver){
         this.driver = driver;
    }

    public void searchStringType(String text){
        driver.findElement(googleInput).sendKeys(text);
        driver.findElement(googleInput).sendKeys(Keys.ENTER);
    }

    public String checkNewPage(){
         return driver.getTitle();
    }

    public String googleSearch(String text){

        this.searchStringType(text);
        return this.checkNewPage();
    }
}
