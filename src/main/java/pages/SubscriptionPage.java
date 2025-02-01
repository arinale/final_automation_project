package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    // דף המנוי
    public class SubscriptionPage extends BasePage {
        private By subscriptionSection = subscriptionSection = By.xpath("//*[@id='footer']/div[1]/div/div[1]/div[2]/div/h2");
        private By emailInput = By.id("susbscribe_email"); // בדוק אם ה-ID נכון
        private By subscribeButton = By.id("subscribe"); // בדוק אם ה-ID נכון
        private By successMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");

        public SubscriptionPage(WebDriver driver) {
            super(driver);
        }

        public void scrollToSubscriptionSection() {
            WebElement element = findElement(subscriptionSection);
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }

        public boolean verifySubscriptionSection() {
            return findElement(subscriptionSection).isDisplayed();
        }

        public void enterEmailAndSubscribe(String email) {
            enterText(emailInput, email);
            clickElement(subscribeButton);
        }

        public boolean verifySuccessMessage() {
            return findElement(successMessage).isDisplayed();
        }
    }