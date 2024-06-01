import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginTestCases {
    WebDriver driver;
    public void register(String email){
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
    }
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

        @Test
        public void validLogin () throws InterruptedException {
            //Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
            Assert.assertTrue(driver.getPageSource().contains("Log out"));
            driver.findElement(By.className("ico-logout")).click();

        }

@Test
public void inValidEmailFormat () throws InterruptedException {
    //Arrange
    driver.get("http://demo.nopcommerce.com");
    driver.findElement(By.className("ico-login")).click();
    driver.findElement(By.id("Email")).sendKeys("-email");
    driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
    driver.findElement(By.id("RememberMe")).click();
    //Act
    driver.findElement(By.className("login-button")).click();
    Thread.sleep(2000);
    //Assert
    Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address."));
}
@Test
public void unregisteredEmail () throws InterruptedException {
//Arrange
    driver.get("http://demo.nopcommerce.com");
    driver.findElement(By.className("ico-login")).click();
    driver.findElement(By.id("Email")).sendKeys("unregistered.user@example.com");
    driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
    driver.findElement(By.id("RememberMe")).click();
    //Act
    driver.findElement(By.className("login-button")).click();
    Thread.sleep(2000);
    //Assert
    Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again"));
    Assert.assertTrue(driver.getPageSource().contains("No customer account found"));
}

@Test
public void incorrectPassword () throws InterruptedException {
        //Arrange
    driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("IncorrectPassword!");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again"));
            Assert.assertTrue(driver.getPageSource().contains("The credentials provided are incorrect"));
        }
@Test
public void emptyFields () throws InterruptedException {
    //Arrange
    driver.get("http://demo.nopcommerce.com");
    driver.findElement(By.className("ico-login")).click();
    driver.findElement(By.id("Email")).sendKeys("");
    driver.findElement(By.id("Password")).sendKeys("");
    //Act
    driver.findElement(By.className("login-button")).click();
    Thread.sleep(2000);
    //Assert
    Assert.assertTrue(driver.getPageSource().contains("Please enter your email"));
}

        @Test
        public void  emptyEmailField () throws InterruptedException {
//Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("");
            driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertTrue(driver.getPageSource().contains("Please enter your email"));
        }
        @Test
        public void emptyPasswordField () throws InterruptedException {
            //Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again"));
            Assert.assertTrue(driver.getPageSource().contains("The credentials provided are incorrect"));
        }
        @Test
        public void loginWithUpperCaseInEmailField () throws InterruptedException {
            //Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("BASSELTAHA9@GMAIL.COM");
            driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
            Assert.assertTrue(driver.getPageSource().contains("Log out"));
            driver.findElement(By.className("ico-logout")).click();
        }
        @Test
        public void loginWithUpperCaseInPasswordField () throws InterruptedException {
            //Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("123!!!BBBBBB");
            driver.findElement(By.id("RememberMe")).click();
            //Act
            driver.findElement(By.className("login-button")).click();
            Thread.sleep(2000);
            //Assert
            Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again"));
            Assert.assertTrue(driver.getPageSource().contains("The credentials provided are incorrect"));
        }
        @Test
        public void forgotPassword () throws InterruptedException {
            //Arrange
            driver.get("http://demo.nopcommerce.com");
            driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
            driver.findElement(By.className("forgot-password")).click();
            //Act
            Thread.sleep(2000);
            //Assert
            Assert.assertTrue(driver.getPageSource().contains("Please enter your email address below. You will receive a link to reset your password."));
        }
    @Test
    public void recoveryMail () throws InterruptedException {
        //Arrange
        register("basseltaha9@gmail.com");
        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
        driver.findElement(By.className("forgot-password")).click();
        driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
        //Act
        driver.findElement(By.className("password-recovery-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("Email with instructions has been sent to you"));

    }
    }