import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import scooter_pages.OrderPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class Main2 {
    private WebDriver driver;
    OrderPage NewOrder;
    boolean isUp; // если верхняя кнопка true, если нижняя false
    String firstName;
    String lastName;
    String addressName;
    String metro;
    String number;
    int rentTime;
    String yourComment;
    String color; //black or grey


    public Main2(boolean isUp, String firstName, String lastName, String addressName, String metro, String number, int rentTime, String yourComment, String color) {
        this.isUp = isUp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressName = addressName;
        this.metro = metro;
        this.number = number;
        this.rentTime = rentTime;
        this.yourComment = yourComment;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[] getInfo() {
        return new Object[][]{
                {true, "Вениамин", "Классный", "Пушкина 30", "2", "81234563535", 1, "o______o", "black"},
        };
    }


    @Before
    public void setUp() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //driver = new ChromeDriver(options);
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        NewOrder = new OrderPage(driver);
        NewOrder.clickCookie();
    }

    @Test
    //первый набор тест данных
    public void checkOrder() {
        NewOrder.clickOrderButton(isUp);
        NewOrder.login(firstName, lastName, addressName, number);
        NewOrder.clickMetroField(metro);
        NewOrder.clickNextButton();
        NewOrder.setDeliveryDateField();
        NewOrder.setRentalPeriodField(rentTime);
        NewOrder.setColorField(color);
        NewOrder.setCommentField(yourComment);
        NewOrder.clickOrderButtonInOrder();
        NewOrder.clickYesButton();
        NewOrder.confirmOrderInfo();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}