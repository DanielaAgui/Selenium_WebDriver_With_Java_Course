package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.tagName("input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider() {
        //Buscamos el elemento
        WebElement element = driver.findElement(slider);
        Actions actions = new Actions(driver);
        //Damos click en el slider según coordenadas específicas
        actions.dragAndDropBy(element, 30, 30).perform();
    }

    //Obtenemos el texto del rango
    public String getRange() {
        return driver.findElement(range).getText();
    }
}
