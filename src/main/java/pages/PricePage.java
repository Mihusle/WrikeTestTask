package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Страница с тарифными планами https://www.wrike.com/ru/price/
 */
public class PricePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='table_main_container']//div[@class='tariffs-wrap-btn']")
    private WebElement startFreeTrialProfessionalButton; //Кнопка "Попробовать бесплатно" для профессионального плана.

    @FindBy(id = "email")
    private WebElement emailField; //Поле для ввода email в появляющейся форме.

    @FindBy(id = "start-project")
    private WebElement startProjectButton; //Кнопка "Создать аккаунт в Wrike" в появляющейся форме.

    public PricePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Клик по кнопке "Попробовать бесплатно" для профессионального плана.
     */
    public void clickStartFreeTrialProfessionalButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table_main_container']//div[@class='tariffs-wrap-btn']")));
        startFreeTrialProfessionalButton.click();
    }

    /**
     * Записать случайно сгенерированного email в поле ввода в появляющейся форме.
     */
    public void writeRandomEmailInEmailField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajaxIframeFeatures")));
        webDriver.switchTo().frame("ajaxIframeFeatures");
        emailField.clear();
        emailField.sendKeys(generateRandomEmail());
    }

    /**
     * Клик по кнопке "Создать аккаунт в Wrike".
     */
    public void clickStartProjectButton() {
        startProjectButton.click();
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
