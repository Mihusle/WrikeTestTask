package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Главная страница сайта https://www.wrike.com/ru/
 */
public class MainPage {

    private WebDriver webDriver;

    @FindBy(className = "nav_login")
    private WebElement signInButton; //Кнопка "Войти".

    public MainPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Клик по кнопке "Войти".
     */
    public void clickSingInButton() {
        signInButton.click();
    }
}
