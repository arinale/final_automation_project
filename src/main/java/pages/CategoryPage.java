
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CategoryPage extends BasePage {

    private By categoryWomen = By.xpath("//a[@href='#Women']");
    private By categoryMen = By.xpath("//a[@href='#Men']");
    private By categoryKids = By.xpath("//a[@href='#Kids']");

    private By dressCategory = By.xpath("//a[contains(text(),'Dress') and contains(@href,'/category_products/1')]");
    private By topsCategory = By.xpath("//a[contains(text(),'Tops') and contains(@href,'/category_products/2')]");
    private By sareeCategory = By.xpath("//a[contains(text(),'Saree') and contains(@href,'/category_products/3')]");

    private By tshirtCategory = By.xpath("//*[@id=\'Men\']/div/ul/li[1]/a");
    private By jeansCategory = By.xpath("//*[@id=\'Men\']/div/ul/li[2]/a");

    private By categoryPageText = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean areCategoriesVisible() {
        return findElement(categoryWomen).isDisplayed() && findElement(categoryMen).isDisplayed() && findElement(categoryKids).isDisplayed();
    }

    public void selectWomenCategory() {
        clickElement(categoryWomen);
        Reporter.log("✅ Clicked on 'Women' category", true);
    }

    public void selectSubCategoryDress() {
        clickElement(dressCategory);
        Reporter.log("✅ Clicked on 'Dress' sub-category", true);
    }

    public boolean verifyCategoryPageDisplayed() {
        return findElement(categoryPageText).isDisplayed();
    }

    public void selectMenSubCategory() {
        clickElement(categoryMen);
        clickElement(tshirtCategory); // שינוי ל-Tshirts
        Reporter.log("✅ Clicked on 'Men' sub-category Tshirts", true);
    }

    public boolean verifyMenCategoryPageDisplayed() {
        return findElement(categoryPageText).isDisplayed();
    }
}