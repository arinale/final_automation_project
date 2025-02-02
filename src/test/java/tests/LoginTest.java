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
import pages.LoginPage;
import tests.RegisterUserTest;  // שימוש במחלקת ההרשמה

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private String registeredEmail = RegisterUserTest.registeredEmail; // שימוש במייל הרשום
    private String registeredPassword = RegisterUserTest.registeredPassword;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginAndDeleteUser() {
        // **1. פתיחת דף הבית**
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "❌ Home page is not visible!");
        Reporter.log("✅ Home page is visible", true);

        // **2. כניסה לדף התחברות**
        homePage.clickSignupLogin();
        Assert.assertTrue(loginPage.isLoginPageVisible(), "❌ Login page is not visible!");
        Reporter.log("✅ 'Login to your account' is visible", true);

        // **3. התחברות למערכת עם המשתמש שנרשם קודם**
        System.out.println("Trying to login with email: " + RegisterUserTest.registeredEmail + " and password: " + RegisterUserTest.registeredPassword);
        loginPage.enterLoginCredentials(RegisterUserTest.registeredEmail, RegisterUserTest.registeredPassword);
        loginPage.clickLogin();

        // **4. בדיקה שהמשתמש מחובר**
        Assert.assertTrue(loginPage.isUserLoggedIn(), "❌ User is not logged in!");
        Reporter.log("✅ User is logged in", true);

        // **5. מחיקת חשבון**
        loginPage.clickDeleteAccount();
        Reporter.log("✅ Clicked on 'Delete Account' button", true);

        // **6. בדיקה שהחשבון נמחק**
        Assert.assertTrue(loginPage.verifyAccountDeleted(), "❌ Account deletion failed!");
        Reporter.log("✅ 'ACCOUNT DELETED!' is visible", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}