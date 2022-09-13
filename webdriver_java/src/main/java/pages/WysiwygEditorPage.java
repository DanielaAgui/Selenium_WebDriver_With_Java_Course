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

    //Cambiamos al frame necesario
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
        //Acción con el mousse de doble click
        actions.moveToElement(element).doubleClick().perform();
        //Buscamos el área de texto y la limpiamos
        driver.findElement(textArea).clear();
        //Volvemos al área principal fuera del frame
        switchToMainArea();
    }

    public void setTextArea(String text) {
        //Cambiamos al área del texto
        switchToEditArea();
        //Escribimos el texto
        driver.findElement(textArea).sendKeys(text);
        //Cambiamos al área principal
        switchToMainArea();
    }

    public String getTextFromEditor() {
        //Cambiamos al área de texto
        switchToEditArea();
        //Devolvemos el texto escrito en una variable
        String text = driver.findElement(textArea).getText();
        //Cambiamos al área principal
        switchToMainArea();
        //Retornamos el texto
        return text;
    }

    //Click en el botón para indentación
    public void increaseIndent() {
        driver.findElement(indentButton).click();
    }
}
