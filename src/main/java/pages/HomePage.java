package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private String url = "http://automationexercise.com";
    private By signupLoginLink = By.linkText("Signup / Login");
    private By subscriptionSection = By.xpath("//*[@id='footer']/div[1]/div/div");
    private By topText = By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(url);
    }

    public boolean verifyHomePage() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public void clickSignupLogin() {
        clickElement(signupLoginLink);
    }
    public boolean isSubscriptionVisible() {
        return findElement(subscriptionSection).isDisplayed();
    }

    public boolean isTopTextVisible() {
        return findElement(topText).isDisplayed();
    }
}




