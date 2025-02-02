package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterUserPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterUserTest {

    private HomePage homePage;
    private RegisterUserPage registerUserPage;
    public static String registeredEmail;
    public static String registeredPassword = "Test1234";

    @BeforeClass
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registerUserPage = new RegisterUserPage(driver);
    }

    @Test
    public void testRegisterNewUser() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
        Reporter.log("✅ Home page is visible", true);

        homePage.clickSignupLogin();
        Assert.assertTrue(registerUserPage.isSignupPageVisible(), "Signup page not visible");
        Reporter.log("✅ Signup page is visible", true);

        registeredEmail = "testuser" + System.currentTimeMillis() + "@mail.com"; // ✅ יצירת אימייל רנדומלי
        System.out.println("Generated registeredEmail: " + registeredEmail); // ✅ בדיקה שהאימייל נוצר נכון

        registerUserPage.enterSignupDetails("TestUser", registeredEmail);
        Assert.assertTrue(registerUserPage.isAccountInfoVisible(), "Account Information page not visible");
        Reporter.log("✅ Account Information page is visible", true);

        registerUserPage.fillAccountDetails(registeredPassword, "1", "January", "1990",
                "John", "Doe", "TestCompany", "123 Main St", "Suite 100",
                "United States", "New York", "New York", "10001", "1234567890");

        Assert.assertTrue(registerUserPage.isAccountCreated(), "Account creation failed");
        Reporter.log("✅ Account created successfully", true);

        registerUserPage.clickContinue();
        Assert.assertTrue(registerUserPage.isLoggedIn(), "User is not logged in after registration");
        Reporter.log("✅ User logged in after registration", true);
    }
}