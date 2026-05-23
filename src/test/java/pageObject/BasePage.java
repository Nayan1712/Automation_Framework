package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void selectbyValue(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    public void selectbyIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    public void scrollTowardsElement(WebElement element) {
        Actions ac = new Actions(driver);
        ac.scrollToElement(element).build().perform();
    }

    public void click(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].click();", element);
        }
    }

    public void type(WebElement element, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

}
