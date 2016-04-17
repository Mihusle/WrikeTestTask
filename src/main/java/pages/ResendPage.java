package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница сообщающая об успешной регистрации https://www.wrike.com/ru/resend
 */
public class ResendPage {

    private WebDriver webDriver;

    @FindBy(id = "resendEmail")
    private WebElement resendButton; //Кнопка "Отправить еще раз".

    @FindBy(css = "a[title='Тарифные планы']")
    private WebElement pricingLink; //Кнопка "Тарифные планы" в верхнем меню.

    public ResendPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Клик по кнопке "Отправить еще раз".
     */
    public void clickResendButton() {
        resendButton.click();
    }

    /**
     * Клик по кнопке "Тарифные планы" в верхнем меню.
     */
    public void clickPricingLink() {
        pricingLink.click();
    }
}
