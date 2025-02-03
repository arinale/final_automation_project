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
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
        try {
            // **1. פתיחת דף הבית**
            homePage.openHomePage();
            Assert.assertTrue(homePage.verifyHomePage(), "❌ Home page is not visible!");
            homePage.takeScreenshot("HomePage_Visible");
            Reporter.log("✅ Home page is visible", true);

            // **2. כניסה לדף התחברות**
            homePage.clickSignupLogin();
            Assert.assertTrue(loginPage.isLoginPageVisible(), "❌ Login page is not visible!");
            takeScreenshot("LoginPage_Visible");
            Reporter.log("✅ 'Login to your account' is visible", true);

            // **3. התחברות למערכת עם המשתמש שנרשם קודם**
            System.out.println("Trying to login with email: " + RegisterUserTest.registeredEmail + " and password: " + RegisterUserTest.registeredPassword);
            loginPage.enterLoginCredentials(RegisterUserTest.registeredEmail, RegisterUserTest.registeredPassword);
            loginPage.clickLogin();
            takeScreenshot("Login_Attempt");

            // **4. בדיקה שהמשתמש מחובר**
            Assert.assertTrue(loginPage.isUserLoggedIn(), "❌ User is not logged in!");
            takeScreenshot("User_Logged_In");
            Reporter.log("✅ User is logged in", true);

            // **5. מחיקת חשבון**
            loginPage.clickDeleteAccount();
            Reporter.log("✅ Clicked on 'Delete Account' button", true);
            takeScreenshot("DeleteAccount_Clicked");

            // **6. בדיקה שהחשבון נמחק**
            Assert.assertTrue(loginPage.verifyAccountDeleted(), "❌ Account deletion failed!");
            Reporter.log("✅ 'ACCOUNT DELETED!' is visible", true);
            takeScreenshot("Account_Deleted");

        } catch (Exception e) {
            Reporter.log("❌ Error encountered: " + e.getMessage(), true);
            takeScreenshot("Test_Failure");
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
    public void takeScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + fileName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            Reporter.log("📸 Screenshot taken: " + fileName, true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to take screenshot: " + e.getMessage(), true);
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}