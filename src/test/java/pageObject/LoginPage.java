package pageObject;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupBtn;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginbtn;

    public void setName(String name) {
        signupName.sendKeys(name);
    }

    public void setEmail(String email) {
        signupEmail.sendKeys(email);
    }

    public void clickSignUpButton() {
        signupBtn.click();
    }

    public void enterEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void enterPwd(String pwd){
        loginPassword.sendKeys(pwd);
    }

    public void clickLoginButton() {
        loginbtn.click();
    }
}
