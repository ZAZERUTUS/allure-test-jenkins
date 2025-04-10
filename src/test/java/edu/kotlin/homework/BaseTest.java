package edu.kotlin.homework;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Listeners({ReportPortalTestNGListener.class})
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
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                File screenshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                ReportPortal.emitLog("Screenshot", "ERROR",  Calendar.getInstance().getTime(), screenshot);
            } catch (Exception e) {
                System.out.println("ererererererere" + e.getMessage());
            }

            try {
                File pageHtml = new File("page_source.html");
                String pageSource = driver.getPageSource();
                FileWriter writer = new FileWriter(pageHtml);
                writer.write(pageSource);
                ReportPortal.emitLog("Page HTML", "ERROR", Calendar.getInstance().getTime(),  pageHtml);
            } catch (IOException e) {
                System.out.println("wewewewewewewe" + e.getMessage());
            }

        }
        if (driver != null) {
            driver.quit();
        }
    }
}
