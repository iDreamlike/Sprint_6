import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import yandex_scooter_site.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexScooterTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @ParameterizedTest
    @MethodSource("test_data.YandexScooterTestData#questionsAnswersProvider")
    void questionAnswerTest(String questionText, String expected) {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver, questionText);
        objHomePage.clickAcceptCookieButton();
        objHomePage.clickQuestion();
        assertEquals(expected, objHomePage.getAnswerText(), "Текст вопроса и ответа не совпадает");
    }

    @Test
    void scooterOrderPositiveTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookieButton();
        objHomePage.clickHeaderOrderButton();
        objHomePage.createOrder(
                "Вася",
                "Петров",
                "Забугоркино",
                "11111111111");
        assertTrue(objHomePage.getCompleteOrderTitleText().contains("Заказ оформлен"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
