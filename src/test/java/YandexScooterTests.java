import YandexScooterSite.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexScooterTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void questionAnswerTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickElement(objHomePage.getCookie());
        objHomePage.clickElement(objHomePage.getQuestion_1());
        String actual = objHomePage.getElementText(objHomePage.getQuestion_1());
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(expected, actual, "Текст вопроса и ответа не совпадает");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
