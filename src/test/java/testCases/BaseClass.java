package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties pro;

    @BeforeClass(groups = {"Master", "Sanity", "Regression"})
    @Parameters({"os", "browser"})
    public void setUp(@Optional("windows") String os, @Optional("chrome") String br) throws IOException {
        FileReader file = new FileReader("./src/test/resources/config.properties");
        pro = new Properties();
        pro.load(file);

        logger = LogManager.getLogger(this.getClass());

        if (pro.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No Matching OS");
                return;
            }
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No Matching browser");
                    return;
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        }
        if (pro.getProperty("execution_env").equalsIgnoreCase("local")) {


            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Browser name is Invalid");
                    return;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(pro.getProperty("appUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Master", "Sanity", "Regression"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String generateName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String generateNumber() {
        String numbers = RandomStringUtils.randomNumeric(10);
        return numbers;
    }

    public static String generateEmail() {
        String username = RandomStringUtils.randomAlphabetic(6).toLowerCase();
        String number = RandomStringUtils.randomNumeric(3);
        return username + number + "@gmail.com";
    }

    public static String generatePassword() {

        String upperCase = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        String lowerCase = RandomStringUtils.randomAlphabetic(4).toLowerCase();
        String numbers = RandomStringUtils.randomNumeric(3);
        String specialChars = "@#&";

        return upperCase + lowerCase + numbers + specialChars;
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }
}
