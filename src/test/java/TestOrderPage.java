import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import scooter_pages.OrderPage;
import scooter_pages.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class TestOrderPage {
    private WebDriver driver;
    OrderPage newOrder;
    boolean isUp; // если верхняя кнопка true, если нижняя false
    String firstName;
    String lastName;
    String addressName;
    String metro;
    String number;
    int rentTime;
    String yourComment;
    String color; //black or grey


    public TestOrderPage(boolean isUp, String firstName, String lastName, String addressName, String metro, String number, int rentTime, String yourComment, String color) {
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
        driver.get(MainPage.SCOOTER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newOrder = new OrderPage(driver);
        newOrder.clickCookie();
    }

    @Test
    //первый набор тест данных
    public void checkOrder() {
        newOrder.clickOrderButton(isUp);
        newOrder.login(firstName, lastName, addressName, number);
        newOrder.clickMetroField(metro);
        newOrder.clickNextButton();
        newOrder.setDeliveryDateField();
        newOrder.setRentalPeriodField(rentTime);
        newOrder.setColorField(color);
        newOrder.setCommentField(yourComment);
        newOrder.clickOrderButtonInOrder();
        newOrder.clickYesButton();
        newOrder.confirmOrderInfo();
    }
    @Test
    //второй набор тест данных
    public void checkOrder2nd() {
        newOrder.clickOrderButtonDown();
        newOrder.login(firstName, lastName, addressName, number);
        newOrder.clickMetroField(metro);
        newOrder.clickNextButton();
        newOrder.setDeliveryDateField();
        newOrder.setRentalPeriodField(rentTime);
        newOrder.setColorField(color);
        newOrder.setCommentField(yourComment);
        newOrder.clickOrderButtonInOrder();
        newOrder.clickYesButton();
        newOrder.confirmOrderInfo();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}