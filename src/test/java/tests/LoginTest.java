package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginValidUser() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
        Reporter.log("Home page is visible", true);

        homePage.clickSignupLogin();
        loginPage.enterLoginCredentials("alnb2001@gmail.com", "1234567");
        loginPage.clickLogin();
        Reporter.log("Login successful", true);

        loginPage.clickDeleteAccount();

        // מחכה שהדף יתעדכן לאחר מחיקת החשבון


        Assert.assertTrue(loginPage.verifyAccountDeleted(), "Your account has been permanently deleted!");
        Reporter.log("Account deleted successfully", true);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
