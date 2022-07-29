package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @param index starts at 1
     */
    public FigureCaption hoverOverFigure(int index) {
        //Creamos un objeto del elemento a buscar y lo buscamos según índice (varios del mismo)
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        //Objeto Actions para simular acciones del usuario, inicializamos con el driver
        Actions actions = new Actions(driver);
        //Movemos el mouse para pasarlo sobre el elemento
        actions.moveToElement(figure).perform();
        //Devolvemos el pie de foto, localizándolo
        return new FigureCaption(figure.findElement(boxCaption));
    }

    //Clase interna del pie de foto
    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        //Método que verifica si el pie de foto sale al pararnos sobre la foto
        public boolean isCaptionDisplayed() {
            //Devuelve un booleano
            return caption.isDisplayed();
        }

        //Método para devolver el título del encabezado del pie de página
        public String getTitle() {
            return caption.findElement(header).getText();
        }

        //Método que devuelve el link del pie de página, por medio de su atributo
        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        //Método que devuelve el texto del link del pie de página
        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
