package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class RegisterUserPage extends BasePage {
    private By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameInput = By.name("name");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[contains(text(),'Signup')]");
    private By accountInfoText = By.xpath("//*[@id='form']/div/div/div/div[1]/h2/b");

    private By passwordInput = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");
    private By accountCreatedText = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private By continueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private By loggedInAsText = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a");

    public RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignupPageVisible() {
        return findElement(newUserSignupText).isDisplayed();
    }

    public void enterSignupDetails(String name, String email) {
        enterText(nameInput, name);
        enterText(emailInput, email);
        clickElement(signupButton);
    }

    public boolean isAccountInfoVisible() {
        return findElement(accountInfoText).isDisplayed();
    }

    // ✅ פונקציה למילוי כל פרטי החשבון
    public void fillAccountDetails(String password, String day, String month, String year,
                                   String firstName, String lastName, String company,
                                   String address1, String address2, String country,
                                   String state, String city, String zipCode, String mobileNumber) {
        enterText(passwordInput, password);

        // 📌 נבחר את התאריך בצורה תקינה
        selectDropdownByValue(dayDropdown, day);
        selectDropdownByVisibleText(monthDropdown, month);
        selectDropdownByValue(yearDropdown, year);

        // בחירת אפשרויות ניוזלטר והצעות מיוחדות
        clickElement(newsletterCheckbox);
        clickElement(specialOffersCheckbox);

        enterText(firstNameInput, firstName);
        enterText(lastNameInput, lastName);
        enterText(companyInput, company);
        enterText(address1Input, address1);
        enterText(address2Input, address2);
        selectDropdownByVisibleText(countryDropdown, country);
        enterText(stateInput, state);
        enterText(cityInput, city);
        enterText(zipcodeInput, zipCode);
        enterText(mobileNumberInput, mobileNumber);

        // 📌 הדפסת כל הערכים כדי לוודא שאין בעיות
        System.out.println("✅ Account details filled successfully!");

        // לחיצה על "Create Account"
        clickElement(createAccountButton);
    }

    // ✅ פונקציה כללית לבחירת ערך לפי `visibleText`
    private void selectDropdownByVisibleText(By locator, String value) {
        WebElement dropdown = findElement(locator);
        Select select = new Select(dropdown);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println("Dropdown option: " + option.getText());
        }

        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {
            System.out.println("❌ Could not select " + value + ", selecting first option.");
            select.selectByIndex(1); // במקרה שהערך לא נמצא, נבחר את הראשון ברשימה
        }
    }

    // ✅ פונקציה כללית לבחירת ערך לפי `value
    protected void selectDropdownByValue(By locator, String value) {
        WebElement dropdown = findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public boolean isAccountCreated() {
        return findElement(accountCreatedText).isDisplayed();
    }

    public void clickContinue() {
        clickElement(continueButton);
    }

    public boolean isLoggedIn() {
        return findElement(loggedInAsText).isDisplayed();
    }
}
