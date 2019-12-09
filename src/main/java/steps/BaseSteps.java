package steps;//import com.sun.tools.javac.code.Attribute;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import utils.TestProperties;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;

    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public static void setUp() throws Exception {
        BrowserType arg;
        arg = BrowserType.valueOf(properties.getProperty("browser"));
        switch (arg) {
            case firefox:
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws Exception{
        driver.quit();

    }

    protected boolean isElementPresent (By by) {
        try{

            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void click(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }

    public enum BrowserType {
        firefox,
        chrome;
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
