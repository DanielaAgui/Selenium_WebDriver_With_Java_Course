package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By text = By.className("jscroll-added");

    //El elemento aparece a medida que hacemos scroll
    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index) {
        //Función para hacer scroll de la ventana hasta [o (horizontal) - bejar hasta la altura del elemento (vertical)]
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        //Objeto del JsExecuter
        var jsExecuter = ((JavascriptExecutor)driver);

        //Mientras el número de párrafos en el documento sea menor al índice dado
        while (getNumberOfParagraphsPresent() < index) {
            //Se ejecuta la función
            jsExecuter.executeScript(script);
        }
    }

    //Método para devolver la cantidad de párrafos presentes en la página
    private int getNumberOfParagraphsPresent() {
        return driver.findElements(text).size();
    }
}
