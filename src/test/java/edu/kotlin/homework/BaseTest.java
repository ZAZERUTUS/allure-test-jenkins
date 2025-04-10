package edu.kotlin.homework;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//@Listeners({ReportPortalTestNGListener.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=646");

//         Указываем путь к ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "\\chrome-win64");

        WebDriverManager.chromedriver().setup();

        Duration duration = Duration.of(25, TimeUnit.SECONDS.toChronoUnit());

        // Запуск Chrome
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(duration);
        driver.manage().timeouts().scriptTimeout(duration);
        driver.manage().timeouts().implicitlyWait(duration);
//        driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS); //Этот методж депрекейтед
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
