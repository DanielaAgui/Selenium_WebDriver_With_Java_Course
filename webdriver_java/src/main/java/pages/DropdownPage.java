package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

//Creamos una clase para la página nueva
public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    //Creamos un método para seleccionar opciones
    public void selectFromDropdown(String option) {
        //Al elemento dropdown encontrado, le damos la opción pasada por parámetro
        findDropdownElement().selectByVisibleText(option);
    }

    //Método que devuelve una lista con los elementos disponibles para seleccionar
    public List<String> getSelectedOptions() {
        //Encontramos los elementos y obtenemos una lista de ellos
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        //Devolvemos una lista con el texto de los elementos
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    //Método que devuelve el dropdown
    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }
}
