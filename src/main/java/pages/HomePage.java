package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private String url = "http://automationexercise.com";
    private By signupLoginLink = By.linkText("Signup / Login");

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
}
