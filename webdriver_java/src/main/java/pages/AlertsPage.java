package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AlertsPage {

    //Variables
    private WebDriver driver;
    private By triggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By results = By.id("result");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");


    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Busca el elemento alerta y damos click
    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt() {
        driver.findElement(triggerPromptButton).click();
    }

    //Cambia a la ventana de la alerta y damos click en el botón "aceptar"
    public void acceptButton() {
        driver.switchTo().alert().accept();
    }

    //Cambia a la ventana de la alerta y damos click en el botón "cancelar"
    public void dismissButton() {
        driver.switchTo().alert().dismiss();
    }

    //Cambia a la ventana de la alerta y obtenemos el texto de la alerta
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    //Cambia a la ventana de la alerta y enviamos un texto en el input

    public void setInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //Busca el elemento que manda el mensaje de resultado y devuelve el texto
    public String getResult() {
        return driver.findElement(results).getText();
    }
}
