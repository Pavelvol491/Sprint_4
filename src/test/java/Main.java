import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scooterpages.DropdownArea;
import scooterpages.OrderModal;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class Main {

    private final String expectedText;

    public Main(String expectedText) {
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static List<Object[]> getExpectedTexts() {
        // Ожидаемые тексты для каждой панели
        return Arrays.asList(new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}
        });
    }

    @Test
    public void testAccordionPanels() {
        // Установка пути к драйверу Firefox (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\alkor\\MyProjectAAA\\WebDriver\\Firefox\\geckodriver.exe");

        // Создание экземпляра WebDriver для Firefox
        WebDriver driver = new FirefoxDriver();

        // Открытие страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");

        DropdownArea dropdownArea = new DropdownArea(driver);

        // Ожидание появления элементов панелей с accordion__panel-0 до accordion__panel-7
        for (int i = 0; i < 2; i++) {
            dropdownArea.getAccordionHeading(i).click();
            String actualText = dropdownArea.getPanelElementById(i).getText();

            if (actualText.equals(expectedText)) {
                System.out.println("Текст панели " + i + " соответствует ожидаемому значению.");
            } else {
                System.out.println("Текст панели " + i + " не соответствует ожидаемому значению.");
            }
        }

        // Закрытие браузера
        driver.quit();
    }

    @Test
    public void testOrderButton() {
        // Установка пути к драйверу Firefox (GeckoDriver)
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\alkor\\MyProjectAAA\\WebDriver\\Firefox\\geckodriver.exe");

        // Создание экземпляра WebDriver для Firefox
        WebDriver driver = new FirefoxDriver();

        // Открытие страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderModal orderModal = new OrderModal(driver);

        // Взаимодействие с элементами на модальном окне заказа
        orderModal.getOrderButton().click();
        orderModal.getFirstNameInput().sendKeys("Иван");
        orderModal.getLastNameInput().sendKeys("Иванов");
        orderModal.getAddressInput().sendKeys("Иваново. Ивановский переулок, дом 6");
        orderModal.getMetroSelect().click();
        orderModal.getMetroOption().click();
        orderModal.getPhoneInput().sendKeys("12345678900");
        orderModal.getDeliveryDateInput().click();
        orderModal.getDeliveryDateOption().click();
        orderModal.getDeliveryTimeSelect().click();
        orderModal.getDeliveryTimeOption().click();
        orderModal.getColorCheckbox().click();
        orderModal.getCommentInput().sendKeys("Иванов");
        orderModal.getPlaceOrderButton().click();

        // Проверка, что модальное окно появилось
        if (orderModal.getOrderModalWindow().isDisplayed()) {
            System.out.println("Модальное окно появилось!");
            // Дополнительные действия с модальным окном
        } else {
            System.out.println("Модальное окно не появилось.");
        }

        // Закрытие браузера
        driver.quit();
    }
}
