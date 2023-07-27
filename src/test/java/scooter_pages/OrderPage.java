package scooter_pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderPage {
    private final WebDriver driver;

    // Локаторы
    private final By orderButton = By.xpath("//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']");
    private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroSelect = By.className("select-search");
    private final By metroOption = By.xpath("//div[contains(text(), 'Черкизовская')]");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']");
    private final By deliveryDateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By deliveryDateOption = By.className("react-datepicker__day--024");
    private final By deliveryTimeSelect = By.className("Dropdown-control");
    private final By deliveryTimeOption = By.xpath("//div[contains(text(), 'пятеро суток')]");
    private final By colorCheckbox = By.id("black");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By placeOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By orderModalWindow = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами на модальном окне заказа
    public WebElement getOrderButton() {
        return driver.findElement(orderButton);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInput);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInput);
    }

    public WebElement getAddressInput() {
        return driver.findElement(addressInput);
    }

    public WebElement getMetroSelect() {
        return driver.findElement(metroSelect);
    }

    public WebElement getMetroOption() {
        return driver.findElement(metroOption);
    }

    public WebElement getPhoneInput() {
        return driver.findElement(phoneInput);
    }
    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }

    public WebElement getDeliveryDateInput() {
        return driver.findElement(deliveryDateInput);
    }

    public WebElement getDeliveryDateOption() {
        return driver.findElement(deliveryDateOption);
    }

    public WebElement getDeliveryTimeSelect() {
        return driver.findElement(deliveryTimeSelect);
    }

    public WebElement getDeliveryTimeOption() {
        return driver.findElement(deliveryTimeOption);
    }

    public WebElement getColorCheckbox() {
        return driver.findElement(colorCheckbox);
    }

    public WebElement getCommentInput() {
        return driver.findElement(commentInput);
    }

    public WebElement getPlaceOrderButton() {
        return driver.findElement(placeOrderButton);
    }

    public WebElement getOrderModalWindow() {
        return driver.findElement(orderModalWindow);
    }
}