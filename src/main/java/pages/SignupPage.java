package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {
    private By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameInput = By.xpath("//input[@name='name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[contains(text(),'Signup')]");
    private By emailExistsError = By.xpath("//*[contains(text(),'Email Address already exist!')]");

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyNewUserSignupText() {
        return findElement(newUserSignupText).isDisplayed();
    }

    public void enterSignupDetails(String name, String email) {
        enterText(nameInput, name);
        enterText(emailInput, email);
    }

    public void clickSignupButton() {
        clickElement(signupButton);
    }

    public boolean verifyEmailExistsError() {
        return findElement(emailExistsError).isDisplayed();
    }
}
