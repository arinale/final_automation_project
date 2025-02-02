package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickElement(By locator) {
        findElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // ✅ הוספת פונקציה לבחירת ערך בתיבת בחירה (Dropdown)
    protected void selectDropdownByValue(By locator, String value) {
        WebElement dropdownElement = findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}
