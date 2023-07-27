package scooter_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderPage2 {
    private final WebDriver driver;

    // Локаторы
    private final By order2Button = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    private final By first2NameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By last2NameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By address2Input = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro2Select = By.className("select-search");
    private final By metro2Option = By.xpath("//div[contains(text(), 'Черкизовская')]");
    private final By phone2Input = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By next2Button = By.xpath("//div[@class='Order_NextButton__1_rCA']//button[text()='Далее']");
    private final By delivery2DateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By delivery2DateOption = By.className("react-datepicker__day--024");
    private final By delivery2TimeSelect = By.className("Dropdown-control");
    private final By delivery2TimeOption = By.xpath("//div[contains(text(), 'пятеро суток')]");
    private final By color2Checkbox = By.id("black");
    private final By comment2Input = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By place2OrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By order2ModalWindow = By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Посмотреть статус']");

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами на модальном окне заказа
    public WebElement get2OrderButton() {
        return driver.findElement(order2Button);
    }

    public WebElement get2FirstNameInput() {
        return driver.findElement(first2NameInput);
    }

    public WebElement get2LastNameInput() {
        return driver.findElement(last2NameInput);
    }

    public WebElement get2AddressInput() {
        return driver.findElement(address2Input);
    }

    public WebElement get2MetroSelect() {
        return driver.findElement(metro2Select);
    }

    public WebElement get2MetroOption() {
        return driver.findElement(metro2Option);
    }

    public WebElement get2PhoneInput() {
        return driver.findElement(phone2Input);
    }
    public WebElement get2NextButton() {
        return driver.findElement(next2Button);
    }

    public WebElement get2DeliveryDateInput() {
        return driver.findElement(delivery2DateInput);
    }

    public WebElement get2DeliveryDateOption() {
        return driver.findElement(delivery2DateOption);
    }

    public WebElement get2DeliveryTimeSelect() {
        return driver.findElement(delivery2TimeSelect);
    }

    public WebElement get2DeliveryTimeOption() {
        return driver.findElement(delivery2TimeOption);
    }

    public WebElement get2ColorCheckbox() {
        return driver.findElement(color2Checkbox);
    }

    public WebElement get2CommentInput() {
        return driver.findElement(comment2Input);
    }

    public WebElement get2PlaceOrderButton() {
        return driver.findElement(place2OrderButton);
    }

    public WebElement get2OrderModalWindow() {
        return driver.findElement(order2ModalWindow);
    }
}