//package edu.kotlin.homework.yandex_elem;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
//
//import static com.codeborne.selenide.Selenide.open;
//
//public class WithYandexElemPage {
//    private WebDriver driver;
//
//    @FindBy(css = "form")
//    private SearchBar searchBar;
//
//    public WithYandexElemPage openPage() {
//        open("https://www.google.com");
//        return this;
//    }
//
//    public WithYandexElemPage(WebDriver driver) {
//        this.driver = driver;
//        HtmlElementLoader.populatePageObject(this, driver);
//    }
//
//    public void search(String query) {
//        searchBar.search(query);
//    }
//}
