package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoryTest {
    private WebDriver driver;
    private HomePage homePage;
    private CategoryPage categoryPage;

    @BeforeClass
    public void setUp() {

         driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @Test
    public void testViewCategoryProducts() {
        homePage.openHomePage();
        Assert.assertTrue(homePage.verifyHomePage(), "❌ Home page not visible");
        Reporter.log("✅ Home page is visible", true);

        Assert.assertTrue(categoryPage.areCategoriesVisible(), "❌ Categories are not visible");
        Reporter.log("✅ Categories are visible on left sidebar", true);

        categoryPage.selectWomenCategory();
        categoryPage.selectSubCategoryDress();

        Assert.assertTrue(categoryPage.verifyCategoryPageDisplayed(), "❌ Category page is not displayed correctly");
        Reporter.log("✅ 'WOMEN - TOPS PRODUCTS' text is visible", true);

        categoryPage.selectMenSubCategory();
        Assert.assertTrue(categoryPage.verifyMenCategoryPageDisplayed(), "❌ Men sub-category page is not displayed");
        Reporter.log("✅ Men sub-category page is displayed successfully", true);
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
        }

}

