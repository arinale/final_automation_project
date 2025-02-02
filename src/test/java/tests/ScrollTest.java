package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class ScrollTest {
    private WebDriver driver;
    private HomePage homePage;
    private JavascriptExecutor jsExecutor;

    @BeforeClass
    public void setUp() {
       driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void testScrollUpDown() {
        // 1. פתיחת דף הבית
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
        Reporter.log("✅ Home page is visible", true);

        // 2. גלילה למטה לבדוק אם 'SUBSCRIPTION' מופיע
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Reporter.log("🔽 Scrolled down to the bottom of the page", true);

        boolean isSubscriptionVisible = homePage.isSubscriptionVisible();
        Assert.assertTrue(isSubscriptionVisible, "❌ SUBSCRIPTION section not visible");
        Reporter.log("✅ 'SUBSCRIPTION' section is visible", true);

        // 3. גלילה חזרה למעלה לבדוק אם הטקסט מופיע
        jsExecutor.executeScript("window.scrollTo(0, 0)");
        Reporter.log("🔼 Scrolled up to the top of the page", true);

        boolean isTopTextVisible = homePage.isTopTextVisible();
        Assert.assertTrue(isTopTextVisible, "❌ 'Full-Fledged practice website for Automation Engineers' text not visible");
        Reporter.log("✅ 'Full-Fledged practice website for Automation Engineers' is visible", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
