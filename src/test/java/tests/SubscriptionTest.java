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
import pages.SubscriptionPage;

public class SubscriptionTest {
    private WebDriver driver;
    private HomePage homePage;
    private SubscriptionPage subscriptionPage;

    @BeforeClass
    public void setUp() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        subscriptionPage = new SubscriptionPage(driver);
    }

    @Test
    public void testSubscriptionWithValidEmail() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
        Reporter.log("Home page is visible", true);

        subscriptionPage.scrollToSubscriptionSection();
        Assert.assertTrue(subscriptionPage.verifySubscriptionSection(), "Subscription section not found");
        Reporter.log("Subscription section is visible", true);

        subscriptionPage.enterEmailAndSubscribe("testuser@example.com");
        Assert.assertTrue(subscriptionPage.verifySuccessMessage(), "Subscription success message not displayed");
        Reporter.log("Subscription success message displayed", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
