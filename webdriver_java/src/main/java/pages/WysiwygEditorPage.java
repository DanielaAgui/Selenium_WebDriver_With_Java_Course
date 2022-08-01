package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WysiwygEditorPage {

    private WebDriver driver;
    //Guardamos el frame en una variable para poder utilizar el método switchTo()
    private String editorIframeId = "mce_0_ifr";
    //Localizador del área de texto
    private By textArea = By.xpath("//*[@id=\"tinymce\"]");
    //Localizador del botón de sangría
    private By indentButton = By.cssSelector("[aria-label=\"Increase indent\"]");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToMainArea() {
        //Cambia al padre del frame actual
        driver.switchTo().parentFrame();
    }

    public void clearTextArea() {
        //Nos movemos al área de texto
        switchToEditArea();
        //Convertimos el área de texto en un WebElement
        WebElement element = driver.findElement(textArea);
        Actions actions = new Actions(driver);
        //Acción con el mouse de doble click
        actions.moveToElement(element).doubleClick();
        //Buscamos el área de texto y la limpiamos
        driver.findElement(textArea).clear();
        //Volvemos al área principal fuera del frame
        switchToMainArea();
    }

    //Establece el texto en el área de texto
    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    //Obtenemos el texto escrito en el área de texto
    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void increaseIndent() {
        driver.findElement(indentButton).click();
    }
}
