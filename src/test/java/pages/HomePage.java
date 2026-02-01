package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

@Getter
public class HomePage {
    private final WebDriver driver;
    private String questionText;
    // Кнопка куки "Да все привыкли"
    private final By cookieAcceptButton = By.xpath("//*[text()='да все привыкли']");
    // Кнопка "Заказать" верхняя
    private final By orderButtonHeader =
            By.xpath("//*[@class='Header_Header__214zg']//button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" нижняя
    private final By orderButtonMiddle = By.xpath("//*[@class='Home_FinishButton__1_cWm']/button");
    // Поле "Имя" на форме "Для кого самокат"
    private final By firstNameField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder, 'Имя')]");
    // Поле "Фамилия" на форме "Для кого самокат"
    private final By familyNameField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder, 'Фамилия')]");
    // Поле "Адрес" на форме "Для кого самокат"
    private final By addressField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder, 'Адрес')]");
    // Поле "Станция метро" на форме "Для кого самокат"
    private final By metroStationField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder, 'метро')]");
    // Первый пункт выпадающего меню "Станция метро"
    private final By metroStation =
            By.xpath("//*[@class='select-search__select']//button[@value='1']");
    // Поле "Телефон" на форме "Для кого самокат"
    private final By phoneNumberField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder, 'Телефон')]");
    // Кнопка "Далее" на форме "Для кого самокат"
    private final By nextButton =
            By.xpath("//button[contains(@class, 'Button_Middle__1CSJM')]");
    // Поле "Когда привезти самокат" на форме "Про аренду"
    private final By orderDateField =
            By.xpath("//*[@class='Order_Form__17u6u']//input[contains(@placeholder," +
                    " 'Когда привезти самокат')]");
    // Сегодняшняя дата в выпадающем календаре на форме "Про аренду"
    private final By orderDate =
            By.xpath("//*[contains(@class,'react-datepicker__day--today')]");
    // Поле "Срок аренды" на форме "Про аренду"
    private final By rentTimeField = By.className("Dropdown-placeholder");
    // Первый пункт выпадающего меню "Срок аренды" на форме "Про аренду"
    private final By rentTime =
            By.xpath("//*[@class='Dropdown-option' and contains(text(),'сутки')]");
    // Кнопка "Заказать" на форме "Про аренду"
    private final By orderButton =
            By.xpath("//*[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");
    // Кнопка "Да" на всплывающем окне "Хотите оформить заказ?"
    private final By confirmButton =
            By.xpath("//*[@class='Order_Modal__YZ-d3']//button[contains(text(),'Да')]");
    // Заголовок "Заказ оформлен"
    private final By completeOrderFormTitle = By.className("Order_ModalHeader__3FDaJ");

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


    public void clickAcceptCookieButton() {
        driver.findElement(cookieAcceptButton).click();
    }

    public void clickQuestion() {
        WebElement element = driver.findElement(getQuestionPath());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(getQuestionPath()).click();
    }

    public String getAnswerText() {
        By answerText = with(By.xpath("//*[contains(@id, 'accordion__panel')]")).near(getQuestionPath());
        WebElement element = driver.findElement(answerText);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return driver.findElement(answerText).getText();
    }

    private void checkAndClearField(By fieldName){
        driver.findElement(fieldName).isEnabled();
        driver.findElement(fieldName).clear();
    }

    public void setFirstName(String newFirstName) {
        checkAndClearField(firstNameField);
        driver.findElement(firstNameField).sendKeys(newFirstName);
    }

    public void setFamilyName(String newFamilyName) {
        checkAndClearField(familyNameField);
        driver.findElement(familyNameField).sendKeys(newFamilyName);
    }

    public void setAddress(String newAddress) {
        checkAndClearField(addressField);
        driver.findElement(addressField).sendKeys(newAddress);
    }

    public void setMetroStation() {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStation).click();
    }

    public void setPhoneNumber(String newPhoneNumber) {
        checkAndClearField(phoneNumberField);
        driver.findElement(phoneNumberField).sendKeys(newPhoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setOrderDateField() {
        driver.findElement(orderDateField).click();
        driver.findElement(orderDate).click();
    }

    public void setRentTimeFieldField() {
        driver.findElement(rentTimeField).click();
        driver.findElement(rentTime).click();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public String getCompleteOrderTitleText() {
        return driver.findElement(completeOrderFormTitle).getText();
    }

    public void fillFirstOrderFormFields(
            String newFirstName, String newFamilyName,
            String newAddress, String newPhoneNumber
    ) {
        setFirstName(newFirstName);
        setFamilyName(newFamilyName);
        setAddress(newAddress);
        setMetroStation();
        setPhoneNumber(newPhoneNumber);
    }

    public void createOrder(String newFirstName, String newFamilyName, String newAddress, String newPhoneNumber) {
        fillFirstOrderFormFields(
                newFirstName,
                newFamilyName,
                newAddress,
                newPhoneNumber
        );
        clickNextButton();
        setOrderDateField();
        setRentTimeFieldField();
        clickOrderButton();
        clickConfirmButton();
    }
}
