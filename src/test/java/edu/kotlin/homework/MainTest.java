package edu.kotlin.homework;

import edu.kotlin.homework.page_object.DragAndDropPage;
import edu.kotlin.homework.page_object.DragAndDropPageFactoryPage;
import edu.kotlin.homework.page_object.with_base_class.ABTestingWithBasePage;
import edu.kotlin.homework.page_object.with_base_class.DragAndDropWithBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.its.ITSValidityPeriod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MainTest extends BaseTest {

    @Test
    void testDragAndDrop() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.goTo();

        page.assertElem2UnderElem1("A", "B");

        page.moveAtoB(page.fieldA, page.fieldB);
        Thread.sleep(1500);
        page.moveAtoB(page.fieldB, page.fieldA);
        Thread.sleep(1500);

        page.assertElem2UnderElem1("A", "B");
    }

    @Test
    void belHardVacTest() throws InterruptedException {
        driver.get("https://belhard.academy/vacancy");

//        Thread.sleep(5000);
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(), 'Карьера')]"));

        System.out.println("text from elem - " + elem.getText());

        assertEquals(elem.getText(), "Карьера в\n" +
                "Академии BELHARD");
    }

    @Test
    void testDragAndDropPAgeFactory() throws InterruptedException {
        DragAndDropPageFactoryPage page = new DragAndDropPageFactoryPage(driver);

        page
                .goTo()
                .assertElem2UnderElem1("A", "B")
                .moveAtoB(page.fieldA, page.fieldB)
                .assertElem2UnderElem1("B", "A");

        Thread.sleep(3000);
    }

    @Test
    void testDragAndDropWithBasePAgeClass() throws InterruptedException {
        DragAndDropWithBasePage page = new DragAndDropWithBasePage(driver);
        page.goTo();

        page.assertElem2UnderElem1("A", "B");

        page.moveAtoB(page.fieldA, page.fieldB);
        Thread.sleep(1500);
        page.moveAtoB(page.fieldB, page.fieldA);
        Thread.sleep(1500);

        page.assertElem2UnderElem1("A", "B");
    }

    @Test
    void tesABTestWithBasePAgeClass() throws InterruptedException {
        ABTestingWithBasePage page = new ABTestingWithBasePage(driver);
        page.goTo();

        Thread.sleep(1500);
        Thread.sleep(1500);
    }

    @Test
    void alertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("wswswsws");
        alert.accept();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

    }

    @Test
    void testFluent() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        Duration duration = Duration.of(2, TimeUnit.SECONDS.toChronoUnit());
        driver.manage().timeouts().implicitlyWait(duration);

        driver.findElement(By.xpath("//*[text()='Start']")).click();

        WebElement elm = (new WebDriverWait(driver, Duration.ofSeconds(6))).until(
                new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver webDriver) {
                        return webDriver.findElement(By.xpath("//*[text()='Hello World!']"));
                    }
                }
        );

        assertTrue(driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed());

    }

    @Test
    public void testGoogleSearch() throws InterruptedException {

        driver.get("https://belhard.academy/autotestjava");

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class='tn-atom']"));
        buttons.get(8).click();


//        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Поиск']"));
        WebElement searchField = (new WebDriverWait(driver, Duration.of(25, TimeUnit.SECONDS.toChronoUnit()))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Поиск']")));

        searchField.sendKeys("Pupupuuu");
        boolean isDisp = searchField.isDisplayed();
        assertTrue(isDisp);



    }

    @Test
    void testWithMenu() throws InterruptedException {

        driver.get("https://belhard.academy/");

        WebElement elem = driver.findElement(By.xpath("//*[text()='Курсы IT']"));
         //*[contains(text(), 'Head of')]
        Actions actions = new Actions(driver);

        actions.moveToElement(elem).perform();
        Thread.sleep(4000);
        WebElement elem2 = driver.findElement(By.xpath("//*[contains(text(),'Менеджмент в IT')]"));

        actions.moveToElement(elem2).perform();

        driver.findElement(By.xpath("//*[contains(text(), 'Head of')]")).click();

        Thread.sleep(4000);
    }

    @Test
    public void testGoogleSearch1() throws InterruptedException {
        // Открытие страницы Google
        driver.get("https://belhard.academy/autotestjava");

        WebElement element = driver.findElement(By.xpath("//a[.//td[contains(text(), 'ЗАП')]]"));
        // Проверка, что заголовок страницы изменился
        assertEquals("ЗАПИСАТЬСЯ НА КУРС", element.getText());
        element.click();

    }
}