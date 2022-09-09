import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSteps   {

    WebDriver driver;
    LoginPage lg;
    SecurePage sc;
    CheckBoxesPage cbp;
    ContextMenuPage cmp;


    @BeforeMethod
    public void setup()
    {
        System.out.println();
        this.driver = Driver.getDriver();
        lg = new LoginPage();
        sc = new SecurePage();
        cbp = new CheckBoxesPage();
        cmp = new ContextMenuPage();

    }
    @AfterMethod
    public void tearDown()
    {
        Driver.closeDriver();
    }

    @Test(priority = 0)
    public void taskOne()
    {
        driver.get("http://localhost:7080/login");
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        lg.inputUsername(username);
        lg.inputPassword(password);
        lg.clickLogin();
        Assert.assertTrue(sc.verifyBannerMessage());
    }
    @Test(priority = 1)
    public void taskTwo()
    {
        driver.get("http://localhost:7080/login");
        String username = "BarisKiziltas";
        String password = "SuperSecretPassword!";
        lg.inputUsername(username);
        lg.inputPassword(password);
        lg.clickLogin();
        Assert.assertFalse(sc.verifyBannerMessage());

    }
    @Test(priority = 2)
    public void taskThree()
    {
        driver.get("http://localhost:7080/checkboxes");
        Assert.assertTrue(cbp.checkBoxes());
    }

    @Test(priority = 3)
    public void taskFour()
    {
        driver.get("http://localhost:7080/context_menu");
        Assert.assertTrue(cmp.verifyAlertMessage());
    }

}
