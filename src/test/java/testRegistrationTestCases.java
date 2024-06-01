import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testRegistrationTestCases {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
@Test
@Description("Register with new email")
    public void testRegisterWithNewEmail() throws InterruptedException {
    // Arrange
    driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
    driver.findElement(By.id("gender-male")).click();
    driver.findElement(By.id("FirstName")).sendKeys("Bassel");
    driver.findElement(By.id("LastName")).sendKeys("Taha");
    driver.findElement(By.id("Email")).sendKeys("basseltaha" + System.currentTimeMillis() + "@gmail.com");
    driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
    driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
    // Act
    driver.findElement(By.id("register-button")).click();
    Thread.sleep(2000);
    //Assert
    Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));

    }
    @Test
    @Description("Register with existing email")
    public void registrationWithExistingEmail() throws InterruptedException {
        String email = "basseltaha" + System.currentTimeMillis() + "@gmail.com";
        //Create new user
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));



        //Arrange
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Mohamed");
        driver.findElement(By.id("LastName")).sendKeys("Belal");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        //Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("The specified email already exists"));

    }
    @Test
    @Description("Register with invalid email")
    public void registrationWithAnInvalidEmail() throws InterruptedException {
            // Arrange

            driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
            driver.findElement(By.id("gender-male")).click();
            driver.findElement(By.id("FirstName")).sendKeys("Bassel");
            driver.findElement(By.id("LastName")).sendKeys("Taha");
            driver.findElement(By.id("Email")).sendKeys("-@-gmail.com");
            driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
            driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
            // Act
            driver.findElement(By.id("register-button")).click();
            Thread.sleep(2000);
            // Assert
            Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address"));

    }
    @Test
    @Description("Register with mismatched passwords")
    public void registrationWithMismatchedPasswords() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!bbbccc");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("The password and confirmation password do not match."));

    }
    @Test
    @Description("Register with empty fields")
    public void registrationWithEmptyFields() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("");
        driver.findElement(By.id("LastName")).sendKeys("");
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("Password is required"));
    }
    @Test
    @Description("Register with weak password")
    public void registrationWithWeakPassword() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("khaled");
        driver.findElement(By.id("LastName")).sendKeys("ziad");
        driver.findElement(By.id("Email")).sendKeys("khaledziad@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("12345");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("12345");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("Password must meet the following rules: "));
        Assert.assertTrue(driver.getPageSource().contains("must have at least 6 characters and not greater than 64 characters"));

    }
    @Test
    @Description("Register with long name")
    public void registrationWithLongName() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("LastName")).sendKeys("oipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqef");
        driver.findElement(By.id("Email")).sendKeys("long.name@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("first name and last name no longer than 220 characters"));
    }
    @Test
    @Description("Register with special characters in names")
    public void registrationWithSpecialCharactersInNames() throws InterruptedException {
        // Arrange
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Ahmed@#");
        driver.findElement(By.id("LastName")).sendKeys("Mohamed$%");
        driver.findElement(By.id("Email")).sendKeys("ahmed.mohamed@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("First name and last name contains invalid characters"));
    }

    @Test
    @Description("Register with new email")
    public void testRegisterWithNewEmailFemale() throws InterruptedException {
        // Arrange
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys("basseltaha" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));

    }
    @Test
    @Description("Register with existing email")
    public void registrationWithExistingEmailFemale() throws InterruptedException {
        String email = "basseltaha" + System.currentTimeMillis() + "@gmail.com";
        //Create new user
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));



        //Arrange
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Mohamed");
        driver.findElement(By.id("LastName")).sendKeys("Belal");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        //Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(driver.getPageSource().contains("The specified email already exists"));

    }
    @Test
    @Description("Register with invalid email")
    public void registrationWithAnInvalidEmailFemale() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys("-@-gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address"));

    }
    @Test
    @Description("Register with mismatched passwords")
    public void registrationWithMismatchedPasswordsFemale() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Bassel");
        driver.findElement(By.id("LastName")).sendKeys("Taha");
        driver.findElement(By.id("Email")).sendKeys("basseltaha9@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!bbbccc");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("The password and confirmation password do not match."));

    }
    @Test
    @Description("Register with empty fields")
    public void registrationWithEmptyFieldsFemale() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("");
        driver.findElement(By.id("LastName")).sendKeys("");
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("Password is required"));
    }
    @Test
    @Description("Register with weak password")
    public void registrationWithWeakPasswordFemale() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("khaled");
        driver.findElement(By.id("LastName")).sendKeys("ziad");
        driver.findElement(By.id("Email")).sendKeys("khaledziad@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("12345");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("12345");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("Password must meet the following rules: "));
        Assert.assertTrue(driver.getPageSource().contains("must have at least 6 characters and not greater than 64 characters"));

    }
    @Test
    @Description("Register with long name")
    public void registrationWithLongNameFemale() throws InterruptedException {
        // Arrange

        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        driver.findElement(By.id("LastName")).sendKeys("oipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqefoipuhwefoipndopidiuibuqsfoiupubnqef");
        driver.findElement(By.id("Email")).sendKeys("long.name@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("first name and last name no longer than 220 characters"));
    }
    @Test
    @Description("Register with special characters in names")
    public void registrationWithSpecialCharactersInNamesFemale() throws InterruptedException {
        // Arrange
        driver.get("http://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Ahmed@#");
        driver.findElement(By.id("LastName")).sendKeys("Mohamed$%");
        driver.findElement(By.id("Email")).sendKeys("ahmed.mohamed@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123!!!BBBbbb");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123!!!BBBbbb");
        // Act
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        // Assert
        Assert.assertTrue(driver.getPageSource().contains("First name and last name contains invalid characters"));
    }

    }
