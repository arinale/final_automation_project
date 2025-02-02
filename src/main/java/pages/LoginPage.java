package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

// דף התחברות
public class LoginPage extends BasePage{
    private By loginToAccountText = By.xpath("//h2[contains(text(),'Login to your account')]");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By loggedInAsText = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a");
    private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
    private By accountDeletedMessage = By.xpath("//*[@id='form']/div/div/div/h2/b");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageVisible() {
        return findElement(loginToAccountText).isDisplayed();
    }

    public void enterLoginCredentials(String email, String password) {
        System.out.println("Trying to login with email: " + email + " and password: " + password);

        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            enterText(emailInput, email);
            enterText(passwordInput, password);
        } else {
            throw new IllegalArgumentException("Email or password is empty!");
        }
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public boolean isUserLoggedIn() {
        return findElement(loggedInAsText).isDisplayed();
    }

    public void clickDeleteAccount() {
        clickElement(deleteAccountButton);
    }

    public boolean verifyAccountDeleted() {
        return findElement(accountDeletedMessage).isDisplayed();
    }

          //  try {
    //  return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage)).isDisplayed();
            //} catch (TimeoutException e) {
              //  System.out.println("TimeoutException: Account deletion confirmation not found.");
                ///return false;


                        }
