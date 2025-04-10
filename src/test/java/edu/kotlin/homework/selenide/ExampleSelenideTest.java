package edu.kotlin.homework.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import edu.kotlin.homework.selenide.po.SelenidePageObjectPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class ExampleSelenideTest {

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.browser = "firefox";  // Используем Chrome
//        Configuration.headless = true; // Запускаем на полный экран
        Configuration.timeout = 5000; // Устанавливаем время ожидания (5 сек.)
    }

    @Test
    public void googleSearchTest() {
        open("https://www.google.com");

        $("[name=q]").setValue("Selenide").pressEnter();

//        $$("#search .g").first().shouldHave(text("selenide.org"));
    }

    @Test
    public void test() {
        SelenidePageObjectPage page = new SelenidePageObjectPage();

    }

    @Test
    public void testSelenid() {
        open("https://belhard.academy/vacancy");

        SelenideElement elem = $x("//span[contains(text(), 'Карьера')]");
        elem.shouldHave(text("Карьера в\n" +
                "Академии BELHARD"));

        elem.shouldBe(visible);
    }
}
