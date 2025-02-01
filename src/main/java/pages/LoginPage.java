package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

// דף התחברות
public class LoginPage extends BasePage{
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private By accountDeletedMessage = By.xpath("//*[@id='form']/div/div/div/h2");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginCredentials(String email, String password) {
        enterText(emailInput, email);
        enterText(passwordInput, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

        public void clickDeleteAccount() {
            try {
                clickElement(deleteAccountButton);
            } catch (Exception e) {
                System.out.println("Failed to click 'Delete Account': " + e.getMessage());
            }
        }

        public boolean verifyAccountDeleted() {
          //  try {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage)).isDisplayed();
            //} catch (TimeoutException e) {
              //  System.out.println("TimeoutException: Account deletion confirmation not found.");
                ///return false;
            }
        }



