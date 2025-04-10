package edu.kotlin.homework.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class DragAndDropPageFactoryPage {

    private final WebDriver driver;

    @FindBy(xpath = "//header[text()='A']")
    public WebElement fieldA;

    @FindBy(xpath = "//header[text()='B']")
    public WebElement fieldB;

    public DragAndDropPageFactoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPageFactoryPage goTo() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public DragAndDropPageFactoryPage moveAtoB(WebElement a, WebElement b) {
        Actions actions = new Actions(driver);

        actions
                .moveToElement(a)
                .clickAndHold()
                .moveToElement(b)
                .release()
                .perform();

        a.click();

        return this;
    }

    public DragAndDropPageFactoryPage assertElem2UnderElem1(String elem1, String elem2) {
        String xpath = "//header[text()='" + elem1 + "']/parent::div/following-sibling::div/header[text()='" + elem2 + "']";
        WebElement forAssert2 = driver.findElement(By.xpath(xpath));
        assertTrue(forAssert2.isDisplayed());

        return this;
    }
}
