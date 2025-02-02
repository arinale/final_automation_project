package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignupPage;

// מחלקת הבדיקה עבור הרשמה עם אימייל קיים
public class SignupTest {
    private WebDriver driver;
    private HomePage homePage;
    private SignupPage signupPage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
    }

    @Test
    public void testSignupWithExistingEmail() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
        Reporter.log("Home page is visible", true);

        homePage.clickSignupLogin();
        Assert.assertTrue(signupPage.verifyNewUserSignupText(), "New User Signup! text not visible");
        Reporter.log("'New User Signup!' text is visible", true);

        signupPage.enterSignupDetails("Test User", "alnb2002@gmail.com");
        signupPage.clickSignupButton();

        Assert.assertTrue(signupPage.verifyEmailExistsError(), "Email Address already exist! error not displayed");
        Reporter.log("Email already exists error message displayed", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
