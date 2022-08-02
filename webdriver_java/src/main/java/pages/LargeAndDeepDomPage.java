package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    //El elemento ya se encuentra dentro del DOM cuando hacemos el scroll
    public void scrollToTable() {
        //Creamos un WebElement para encontrar la tabla
        WebElement element = driver.findElement(table);
        //String para llamar la función que vamos a ejecutar
        String script = "arguments[0].scrollIntoView();";
        //Creamos un objeto JavaScriptExecutor en el driver para ejecutar la acción
        ((JavascriptExecutor)driver).executeScript(script, element);
    }
}
