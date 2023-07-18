package scooterpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownArea {
    private final WebDriver driver;

    // Локаторы
    private final By accordionHeadings = By.className("accordion__heading");

    public DropdownArea(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами на странице с выпадающими панелями
    public WebElement getAccordionHeading(int index) {
        return driver.findElements(accordionHeadings).get(index);
    }

    public WebElement getPanelElementById(int index) {
        String panelId = "accordion__panel-" + index;
        return driver.findElement(By.id(panelId));
    }
}
