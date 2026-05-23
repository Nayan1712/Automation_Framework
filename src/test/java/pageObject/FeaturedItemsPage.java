package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeaturedItemsPage extends BasePage {

    public FeaturedItemsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]")
    WebElement pageHeading;

    @FindBy(xpath="//a[text()=' Logout']")
    WebElement logoutBtnLink;

    public void logoutBtn(){
        logoutBtnLink.click();
    }

    public boolean isHeadingDisplayed(){
        try{
            return pageHeading.isDisplayed();
        }catch(Exception e){
            return false;
        }

    }
}
