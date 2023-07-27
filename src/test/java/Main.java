import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class Main {

    private final String expectedText;
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    public Main(String expectedText) {
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static List<Object[]> getExpectedTexts() {
        // Ожидаемые тексты для каждой панели
        return Arrays.asList(new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    @Before
    public void setUp() {
        // Установка пути к драйверу Firefox (GeckoDriver)
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\alkor\\MyProjectAAA\\WebDriver\\Firefox\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alkor\\MyProjectAAA\\WebDriver\\bin\\chromedriver.exe");
        // Создание экземпляра WebDriver для Firefox
        //driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

    }

    @Test
    public void testAccordionPanels() {
        // Открытие страницы
        driver.get(SCOOTER_URL);

        MainPage mainPage = new MainPage(driver);

        // Ожидание появления элементов панелей с accordion__panel-0 до accordion__panel-7
        for (int i = 0; i < 2; i++) {
            mainPage.getAccordionHeading(i).click();
            String actualText = mainPage.getPanelElementById(i).getText();

            // Сравнение текста элемента с ожидаемым значением с использованием assert
            Assert.assertEquals("Текст панели " + i + " не соответствует ожидаемому значению.", expectedText, actualText);
        }
    }
    @Test
    public void testOrderButton() {
        TestOrderButton orderButtonTest = new TestOrderButton(driver);
        orderButtonTest.testOrderButton();
    }
    @Test
    public void testOrderButton2() {
        TestOrderButton2 orderButton2Test = new TestOrderButton2(driver);
        orderButton2Test.testOrderButton2();
    }
    @After
    public void tearDown() {
        // Закрытие браузера after each test
        if (driver != null) {
            driver.quit();
        }
    }
}