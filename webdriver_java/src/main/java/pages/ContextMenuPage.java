package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By menuBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clikMenuBox() {
        //Buscamos el elemento
        WebElement box = driver.findElement(menuBox);
        Actions actions = new Actions(driver);
        //Damos click derecho sobre el elemento
        actions.contextClick(box).perform();
    }

    //Obtenemos el texto de la alerta
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    //Click en el botón aceptar
    public void clickAcceptButton() {
        driver.switchTo().alert().accept();
    }
}
