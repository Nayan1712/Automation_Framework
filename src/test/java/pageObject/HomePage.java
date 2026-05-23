package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    WebElement linkSignup;

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    WebElement linkLogin;

    @FindBy(xpath = "//div[@class='clearfix']/child::div/label[@for='id_gender1']")
    WebElement title;

    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    WebElement dayDOB;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthDOB;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearDOB;

    Actions action = new Actions(driver);

    public void clickSignUp() {
        linkSignup.click();
    }

    public void clickLoginlink(){
        linkLogin.click();
    }

    public void settitle() {
        title.click();
    }

    public void setPassword(String passwords) {
        password.sendKeys(passwords);
    }

    public void setDOB(String day, String month, String year) {
        new Select(dayDOB).selectByVisibleText(day);
        new Select(monthDOB).selectByVisibleText(month);
        new Select(yearDOB).selectByVisibleText(year);
    }






}

