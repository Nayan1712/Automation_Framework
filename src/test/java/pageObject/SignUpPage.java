package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(xpath = "//b[text()='Address Information']")
    WebElement addressText;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    WebElement addrFirstName;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    WebElement addrLastName;

    @FindBy(xpath = "//input[@data-qa='address']")
    WebElement address;

    @FindBy(xpath = "//select[@data-qa='country']")
    WebElement country;

    @FindBy(xpath = "//input[@data-qa='state']")
    WebElement state;

    @FindBy(xpath = "//input[@data-qa='city']")
    WebElement city;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedConfirm;

    public void settitle() {
        click(title);
    }

    public void setPassword(String passwords) {
        type(password, passwords);
    }

    public void setDOB(String day, String month, String year) {
        selectbyValue(dayDOB, day);
        selectbyValue(monthDOB, month);
        selectbyValue(yearDOB, year);
    }

    public void scrollToElement() {
        scrollTowardsElement(addressText);
    }

    public void setAddrFirstName(String firstName) {
        type(addrFirstName, firstName);
    }

    public void setAddrLastName(String lastName) {
        type(addrLastName, lastName);
    }

    public void setAddrress(String addressName) {
        type(address, addressName);
    }

    public void setCountry(String countryName) {
        selectbyValue(country, countryName);
    }

    public void setState(String stateName) {
        type(state, stateName);
    }

    public void setZipcode(String addrZipCOde) {
        type(zipcode, addrZipCOde);
    }

    public void setCity(String cityName){
        type(city,cityName);
    }

    public void setMobileNumber(String userMobileNumber) {
        type(mobileNumber, userMobileNumber);
    }

    public void clickOnCreateAccountButton() {
        click(createAccountButton);
    }

   public String confirmationMsg(){
        try{
            return accountCreatedConfirm.getText();
        }catch (Exception e){
            return e.getMessage();
        }
   }
}


