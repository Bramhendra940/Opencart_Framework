package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"os", "browser"})
    public void setUp(@Optional("windows") String os,
                      @Optional("chrome") String browser) throws IOException {

        // Load config.properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        // Initialize logger
        logger = LogManager.getLogger(this.getClass());

        // Launch browser based on parameter
        switch (browser.toLowerCase()) {

            case "edge":
                driver = new EdgeDriver();
                break;

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        // Browser settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Launch application URL
        driver.get(p.getProperty("url"));
    }

    // Generate random string
    public String randomString() {
        String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
        return generatedString;
    }

    // Generate random number
    public String randomNumber() {
        String generatedNumber = RandomStringUtils.secure().nextNumeric(10);
        return generatedNumber;
    }

    // Generate random alphanumeric password
    public String randomAlphaneumaric() {
        String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
        String generatedNumber = RandomStringUtils.secure().nextNumeric(10);
        return (generatedString + "#" + generatedNumber);
    }

    // Capture screenshot
    public String captureScreen(String tname) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") +
                "\\screenshots\\" + tname + "_" + timestamp + ".png";

        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

    // Close browser
    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown() {
        driver.quit();
    }
}