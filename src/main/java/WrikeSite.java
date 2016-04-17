import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Класс описывает все страницы сайта wrike.com/ru/, которые будут использованы при тестировании.
 */
public class WrikeSite {

    private WebDriver webDriver;

    public WrikeSite(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Главная страница.
     *
     * @return Объект данной страницы.
     */
    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    /**
     * Страница входа.
     *
     * @return Объект данной страницы.
     */
    public LoginPage loginPage() {
        return new LoginPage(webDriver);
    }

    /**
     * Страница регистрации аккаунта.
     *
     * @return Объект данной страницы.
     */
    public RegistrationPage registrationPage() {
        return new RegistrationPage(webDriver);
    }

    /**
     * Страница, сообщающая об успешной регистрации.
     *
     * @return Объект данной страницы.
     */
    public ResendPage resendPage() {
        return new ResendPage(webDriver);
    }

    /**
     * Страница с тарифными планами.
     *
     * @return Объект данной страницы.
     */
    public PricePage pricePage() {
        return new PricePage(webDriver);
    }
}
