package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.SignUpPage;

import java.time.Duration;

public class SignUpTest extends BaseClass {


    @Test(groups = {"Master","Regression"})
    public void verify_signUp() {

        logger.info("************ Account SignUp Starting **************");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickSignUp();

            logger.info("Clicked on SignUp button");

            LoginPage lp = new LoginPage(driver);
            lp.setName(generateName());
            lp.setEmail(generateEmail());
            lp.clickSignUpButton();
            logger.info("Clicked on SignUp button");

            SignUpPage sp = new SignUpPage(driver);

            logger.info("Entering all the user details....");
            sp.settitle();
            sp.setPassword(generatePassword());
            sp.setDOB("10", "1", "2010");
            sp.scrollToElement();
            sp.setAddrFirstName("Jam");
            sp.setAddrLastName("Nand");
            sp.setAddrress("Lal gang Rd");
            sp.setCountry("India");
            sp.setState("Madhya Pradesh");
            sp.setCity("Naperville");
            sp.setZipcode("480106");
            sp.setMobileNumber(generateNumber());
            sp.clickOnCreateAccountButton();
            String confirMsg = sp.confirmationMsg();
            Assert.assertEquals(confirMsg, "ACCOUNT CREATED!");
            System.out.println("Account created successfully");
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug...");
            Assert.fail();
        }
        logger.info("Test Passed.....");

    }


}
