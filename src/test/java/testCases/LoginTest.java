package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FeaturedItemsPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.logging.Logger;

public class LoginTest extends BaseClass{

    @Test(groups = {"Sanity","Master"})
    public void Verify_LoginFunc(){

        logger.info("************* Login Test Starting ***************");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickLoginlink();

            logger.info("Clicked on Login link button");

            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(pro.getProperty("email"));
            lp.enterPwd(pro.getProperty("password"));
            lp.clickLoginButton();
            logger.info("Clicked on Login button");

            FeaturedItemsPage fip = new FeaturedItemsPage(driver);
            boolean expHeading = fip.isHeadingDisplayed();
            Assert.assertTrue(expHeading);
        }catch(Exception e){
            Assert.fail();
        }

        logger.info("************* Login Test Passed ***************");

    }
}
