import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Тест выполнен для сайта wrike.com/ru/, т.е. для РУССКОЯЗЫЧНОЙ версии.
 */
public class WrikeTest {
    private WebDriver webDriver;
    private WrikeSite wrikeSite;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaTest\\chromedriver.exe"); //Установка пути к chromedriver.exe.
        webDriver = new ChromeDriver();
        wrikeSite = new WrikeSite(webDriver);
        wait = new WebDriverWait(webDriver, 10, 500);
        webDriver.get("http://wrike.com/ru/");
    }

    @Test
    public void testWrike() {
        wrikeSite.mainPage().clickSingInButton();
        wrikeSite.loginPage().clickSingUpLink();
        wrikeSite.registrationPage().writeRandomEmailInEmailField();
        wrikeSite.registrationPage().clickStartButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text"))); //Ожидание, пока загрузится страница с подтверждением успешности регистрации.
        Assert.assertTrue(webDriver.findElement(By.className("text")).getText().equals("Регистрация успешно завершена")); //Проверка, что регистрация успешно завершена.

        wrikeSite.resendPage().clickResendButton();
        wrikeSite.resendPage().clickPricingLink();
        wrikeSite.pricePage().clickStartFreeTrialProfessionalButton();
        wrikeSite.pricePage().writeRandomEmailInEmailField();
        wrikeSite.pricePage().clickStartProjectButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text"))); //Ожидание, пока загрузится страница с подтверждением успешности регистрации.
        Assert.assertTrue(webDriver.findElement(By.className("text")).getText().equals("Регистрация успешно завершена"));//Проверка, что регистрация успешно завершена.

        wrikeSite.resendPage().clickResendButton();
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
