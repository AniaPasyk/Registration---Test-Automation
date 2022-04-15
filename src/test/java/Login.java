import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Login {
    @Test
    public void demoTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        //find and click on the "Sign In" button
        By linkText = By.xpath("//a[@text()='Sign in']");
        WebElement link = driver.findElement(linkText);
        link.click();

        // search the email field and enter the email
        WebElement email = driver.findElement(By.xpath("//input[@id='email_create']"));
        email.sendKeys("cygankaankaa@interia.pl");

        // click on the "Create an account" button
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
        clickButton.click();

        //search the First name field and enter the value
        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstName.sendKeys("Ania");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastName.sendKeys("Atest");

        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("haslo123!");

        WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("2040 W Wisconsin Ave, Milwaukee");

        //City
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
       city.sendKeys("Milwaukee");

        //state
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select sel = new Select(selectElement);
        sel.selectByIndex(49);

        //zip
        WebElement postalCode = driver.findElement(By.xpath("//input[@id='postcode']"));
        postalCode.sendKeys("53105");

        //mobile phone
        WebElement mobilePhone = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
        mobilePhone.sendKeys("485959595");

        //click on the button
        WebElement register = driver.findElement(By.xpath("//button[@type='submit']"));
        register.click();

        //validate that user is created
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);


    }

}
