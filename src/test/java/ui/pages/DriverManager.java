package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {

    private static final String CHROMEDRIVER_EXE_PATH = ".\\src\\test\\resources\\webdrivers\\chromedriver\\chromedriver.exe";
    private static DriverManager instance;
    private WebDriver driver;

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null)
                    instance = new DriverManager();
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }

    private void createDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, CHROMEDRIVER_EXE_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }


    public void open(String URL) {
        getDriver().get(URL);
    }

    public void quit() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public void waitUntilVisible(WebElement element) {
        FluentWait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
