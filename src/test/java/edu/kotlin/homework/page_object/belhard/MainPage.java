package edu.kotlin.homework.page_object.belhard;

import edu.kotlin.homework.page_object.belhard.object.HeaderObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderObject header = new HeaderObject(driver);

    private final By loc1 =  By.xpath("//*[@id='rec229609419']/div/div/div[34]/div/a");
    private final By loc2 = By.xpath("//*[@id=\"rec229609419\"]/div/div/div[7]/div/a");
}
