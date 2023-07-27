public class TestOrderButton {
    private final WebDriver driver;

    public TestOrderButton(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void testOrderButton() {
        // Открытие страницы
        driver.get(Main.SCOOTER_URL);

        OrderPage orderPage = new OrderPage(driver);

        // Взаимодействие с элементами на модальном окне заказа
        orderPage.getOrderButton().click();
        orderPage.getFirstNameInput().sendKeys("Иван");
        orderPage.getLastNameInput().sendKeys("Иванов");
        orderPage.getAddressInput().sendKeys("Иваново. Ивановский переулок, дом 6");
        orderPage.getMetroSelect().click();
        orderPage.getMetroOption().click();
        orderPage.getPhoneInput().sendKeys("12345678900");
        orderPage.getNextButton().click();
        orderPage.getDeliveryDateInput().click();
        orderPage.getDeliveryDateOption().click();
        orderPage.getDeliveryTimeSelect().click();
        orderPage.getDeliveryTimeOption().click();
        orderPage.getColorCheckbox().click();
        orderPage.getCommentInput().sendKeys("Иванов");
        orderPage.getPlaceOrderButton().click();

        // Проверка, что модальное окно появилось с использованием assert
        Assert.assertTrue("Модальное окно не появилось.", orderPage.getOrderModalWindow().isDisplayed());
    }
}