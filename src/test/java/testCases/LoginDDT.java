package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.FeaturedItemsPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "SanityDDT")
    public void verify_LoginDDT(String email, String pwd, String exp) {

        logger.info("************* LoginDDT Test Starting ***************");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickLoginlink();

            logger.info("Clicked on Login link button");

            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(email);
            lp.enterPwd(pwd);
            lp.clickLoginButton();
            logger.info("Clicked on Login button");

            FeaturedItemsPage fip = new FeaturedItemsPage(driver);
            boolean expHeading = fip.isHeadingDisplayed();
            Assert.assertTrue(expHeading);

            if (exp.equalsIgnoreCase("Valid")) {
                if (expHeading == true) {
                    fip.logoutBtn();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (expHeading == true) {
                    fip.logoutBtn();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }

            }
        } catch (Exception e) {
            Assert.fail();
        }


        logger.info("************* LoginDDT Test Passed ***************");
    }

}

