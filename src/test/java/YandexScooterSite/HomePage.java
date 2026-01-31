package YandexScooterSite;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

@Getter
public class HomePage {
    private final WebDriver driver;
    private String questionText;
    // Кнопка куки "Да все привыкли"
    private final By cookieAcceptButton =
            By.xpath("//*[text()='да все привыкли']");
    // Вопрос 1. Сколько это стоит? И как оплатить?
//    private final By question_1 =
//            By.xpath("//*[text()='Сколько это стоит? И как оплатить?']");
//    // Вопрос 2. Хочу сразу несколько самокатов! Так можно?
//    private final By question_2 =
//            By.xpath("//*[text()='Хочу сразу несколько самокатов! Так можно?']");
//    // Вопрос 3. Как рассчитывается время аренды?
//    private final By question_3 =
//            By.xpath("//*[text()='Как рассчитывается время аренды?']");
//    // Вопрос 4. Можно ли заказать самокат прямо на сегодня?
//    private final By question_4 =
//            By.xpath("//*[text()='Можно ли заказать самокат прямо на сегодня?']");
//    // Вопрос 5. Можно ли продлить заказ или вернуть самокат раньше?
//    private final By question_5 =
//            By.xpath("//*[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
//    // Вопрос 6. Вы привозите зарядку вместе с самокатом?
//    private final By question_6 =
//            By.xpath("//*[text()='Вы привозите зарядку вместе с самокатом?']");
//    // Вопрос 7. Можно ли отменить заказ?
//    private final By question_7 =
//            By.xpath("//*[text()='Можно ли отменить заказ?']");
//    // Вопрос 8. Я жизу за МКАДом, привезёте?
//    private final By question_8 =
//            By.xpath("//*[text()='Я жизу за МКАДом, привезёте?']");

    // Кнопка "Заказать" верхняя
    // Кнопка "Заказать" нижняя

    // Поле "Имя" на форме "Для кого самокат"
    // Поле "Фамилия" на форме "Для кого самокат"
    // Поле "Адрес" на форме "Для кого самокат"
    // Поле "Станция метро" на форме "Для кого самокат"
    // Первый пункт выпадающего меню "Станция метро"
    // Поле "Телефон" на форме "Для кого самокат"
    // Кнопка "Далее" на форме "Для кого самокат"

    // Поле "Когда привезти самокат" на форме "Про аренду"
    // Сегодняшняя дата в выпадающем календаре на форме "Про аренду"
    // Поле "Срок аренды" на форме "Про аренду"
    // Первый пункт выпадающего меню "Срок аренды" на форме "Про аренду"
    // Кнопка "Да" на всплывающем окне "Хотите оформить заказ?"
    // Заголовок "Заказ оформлен"

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage(WebDriver driver, String questionText) {
        this.driver = driver;
        this.questionText = questionText;
    }

    private By getQuestionPath() {
        return By.xpath("//*[text()='" + questionText + "']");
    }

    public void clickElement(By pathToElement) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(pathToElement)).perform();
        driver.findElement(pathToElement).click();
    }

    public void clickQuestion() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(getQuestionPath())).perform();
        driver.findElement(getQuestionPath()).click();
    }

    public String getAnswerText() {
        Actions actions = new Actions(driver);
        By answerText = with(By.xpath("//*[contains(@id, 'accordion__panel')]")).near(getQuestionPath());
        actions.scrollToElement(driver.findElement(answerText)).perform();
        return driver.findElement(answerText).getText();
    }

    // Метод заполнения полей "Для кого самокат"
    // Метод заполнения полей "Про аренду"
    // Вспомогательные методы для заполнения полей
}
