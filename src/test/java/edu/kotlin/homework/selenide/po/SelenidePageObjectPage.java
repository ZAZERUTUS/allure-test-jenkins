package edu.kotlin.homework.selenide.po;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePageObjectPage {
    private final SelenideElement searchInput = $("[name='q']");  // Поле поиска
    private final SelenideElement searchResults = $("#search");    // Блок результатов
    private final SelenideElement xpathElem = $x("");    // Блок результатов


    public SelenidePageObjectPage openPage() {
        open("https://www.google.com");
        return this;
    }

    public SelenidePageObjectPage searchFor(String query) {
        searchInput.setValue(query).pressEnter();
        return this;
    }

    public void verifySearchResult(String expectedText) {
        searchResults.shouldHave(text(expectedText));
    }
}
