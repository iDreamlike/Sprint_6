package tests;

import config.Config;
import utils.DriverFactory;
import pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexScooterTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    @ParameterizedTest
    @MethodSource("data.YandexScooterTestData#questionsAnswersProvider")
    void questionAnswerTest(String questionText, String expected) {
        driver.get(Config.BASE_URL);
        HomePage objHomePage = new HomePage(driver, questionText);
        objHomePage.clickAcceptCookieButton();
        objHomePage.clickQuestion();
        assertEquals(expected, objHomePage.getAnswerText(), "Текст вопроса и ответа не совпадает");
    }

    @ParameterizedTest
    @MethodSource("data.YandexScooterTestData#userProvider")
    void scooterOrderByHeaderButtonPositiveTest(String firstName, String familyName, String address, String phoneNumber) {
        driver.get(Config.BASE_URL);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookieButton();
        objHomePage.clickHeaderOrderButton();
        objHomePage.createOrder(firstName, familyName,address, phoneNumber);
        assertTrue(objHomePage.getCompleteOrderTitleText().contains("Заказ оформлен"),
                "Заголовок экрана успеха заказа не найден");
    }

    @ParameterizedTest
    @MethodSource("data.YandexScooterTestData#userProvider")
    void scooterOrderByMiddleButtonPositiveTest(String firstName, String familyName, String address, String phoneNumber) {
        driver.get(Config.BASE_URL);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookieButton();
        objHomePage.clickMiddleOrderButton();
        objHomePage.createOrder(firstName, familyName,address, phoneNumber);
        assertTrue(objHomePage.getCompleteOrderTitleText().contains("Заказ оформлен"),
                "Заголовок экрана успеха заказа не найден");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
