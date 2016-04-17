package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Страница регистрации https://www.wrike.com/ru/free-trial
 */
public class RegistrationPage {

    private WebDriver webDriver;

    @FindBy(css = "input[name='email']")
    private WebElement emailField; //Поле для ввода email.

    @FindBy(css = "span[class='input-group-btn']")
    private WebElement startButton; //Кнопка "Начать бесплатно".

    public RegistrationPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Записать в поле для ввода email случайно сгенерированного email.
     */
    public void writeRandomEmailInEmailField() {
        emailField.clear();
        emailField.sendKeys(generateRandomEmail());
    }

    /**
     * Клик по кнопке "Начать бесплатно".
     */
    public void clickStartButton() {
        startButton.click();
    }

    /**
     * Генерация случайного email.
     */
    private String generateRandomEmail() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        sb.append("@yandex.ru");
        return sb.toString();
    }
}
