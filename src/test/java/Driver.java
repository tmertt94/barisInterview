import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

    private static  WebDriver driver;

    private Driver (){
    }
    public static WebDriver getDriver(){

        if(driver != null)
        {
            return driver;
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }




    }

    public static void closeDriver(){
        if (driver !=null){
            driver.quit();
            driver= null;

        }

    }
}