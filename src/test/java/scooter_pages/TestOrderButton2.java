package scooter_pages;

public class TestOrderButton2 {
    private final WebDriver driver;

    public TestOrderButton2(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void testOrderButton() {
        // Открытие страницы
        driver.get(Main.SCOOTER_URL);

        OrderPage2 orderPage2 = new OrderPage2(driver);

        // Взаимодействие с элементами на модальном окне заказа
        orderPage2.get2OrderButton().click();
        orderPage2.get2FirstNameInput().sendKeys("Иван");
        orderPage2.get2LastNameInput().sendKeys("Иванов");
        orderPage2.get2AddressInput().sendKeys("Иваново. Ивановский переулок, дом 6");
        orderPage2.get2MetroSelect().click();
        orderPage2.get2MetroOption().click();
        orderPage2.get2PhoneInput().sendKeys("12345678900");
        orderPage2.get2NextButton().click();
        orderPage2.get2DeliveryDateInput().click();
        orderPage2.get2DeliveryDateOption().click();
        orderPage2.get2DeliveryTimeSelect().click();
        orderPage2.get2DeliveryTimeOption().click();
        orderPage2.get2ColorCheckbox().click();
        orderPage2.get2CommentInput().sendKeys("Иванов");
        orderPage2.get2PlaceOrderButton().click();

        // Проверка, что модальное окно появилось с использованием assert
        Assert.assertTrue("Модальное окно не появилось.", orderPage.getOrderModalWindow().isDisplayed());
    }
}