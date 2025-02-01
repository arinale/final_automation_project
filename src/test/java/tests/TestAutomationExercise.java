//package tests;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//
//public class TestAutomationExercise {
//    public WebDriver driver;
//    public HomePage homePage;
//    public LoginPage loginPage;
//
//    @BeforeClass
//    public void setUp() {
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        homePage = new HomePage(driver);
//        loginPage = new LoginPage(driver);
//    }
//
//    @Test
//    public void testLoginValidUser() {
//        homePage.openHomePage();
//        Assert.assertTrue(homePage.verifyHomePage(), "Home page not visible");
//        Reporter.log("Home page is visible", true);
//        homePage.clickSignupLogin();
//        loginPage.enterLoginCredentials("valid_user@example.com", "password123");
//        loginPage.clickLogin();
//        Reporter.log("Login successful", true);
//    }
//
//    @Test
//    public void testVerifySubscription() {
//        homePage.openHomePage();
//        homePage.scrollToFooter();
//        Assert.assertTrue(homePage.verifySubscriptionSection(), "Subscription section not visible");
//        Reporter.log("Subscription section is visible", true);
//    }
//
//    @Test
//    public void testViewCategoryProducts() {
//        homePage.openHomePage();
//        homePage.clickWomenCategory();
//        homePage.clickDressCategory();
//        Reporter.log("Navigated to Women - Dress category", true);
//        homePage.clickMenCategory();
//        Reporter.log("Navigated to Men category", true);
//    }
//
//    @Test
//    public void testRegisterExistingUser() {
//        homePage.openHomePage();
//        homePage.clickSignupLogin();
//        loginPage.enterLoginCredentials("existing_user@example.com", "password123");
//        loginPage.clickLogin();
//        Reporter.log("Verified error for existing user", true);
//    }
//
//    @Test
//    public void testScrollFunctionality() {
//        homePage.openHomePage();
//        homePage.scrollToFooter();
//        Reporter.log("Scrolled to bottom", true);
//        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
//        Reporter.log("Scrolled to top", true);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
//
