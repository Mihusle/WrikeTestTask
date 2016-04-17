package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница входа https://www.wrike.com/login/
 */
public class LoginPage {
    private WebDriver webDriver;

    @FindBy(css = "a[href='/ru/free-trial']")
    private WebElement signUpLink; //Ссылка "Создать аккаунт".

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Клик по ссылке "Создать аккаунт".
     */
    public void clickSingUpLink() {
        signUpLink.click();
    }
}
