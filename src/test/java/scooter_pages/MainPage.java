package scooter_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //локатор для списка вопросов
    private By questionList = By.className("accordion");
    //локатор для кнопки куки
    private By cookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    //метод для принятия куки
    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
    //метод прокрутки до списка вопросов
    public void scrollToQuestionList() {
        WebElement element = driver.findElement(questionList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //методы нажатия на кнопки с вопросами
    public void clickQuestions(int index) {
        driver.findElement(By.id("accordion__heading-" + index)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //методы возвращаюшие текст ответа на вопрос
    public String getAnswer(int index) {
        return driver.findElement(By.id("accordion__panel-"+index)).getText();
    }

}
