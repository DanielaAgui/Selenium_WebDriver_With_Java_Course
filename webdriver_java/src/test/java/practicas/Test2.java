package practicas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    //Creamos un objeto webdriver
    private WebDriver driver;

    //Creamos un método y pasamos la ubicación del webdriver a usar
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Instanciamos el objeto
        driver = new ChromeDriver();
        //Iniciamos el objeto y pasamos la URL de la página a usar para los tests
        driver.get("https://the-internet.herokuapp.com/");

        //Creamos una variable para buscar algún elemento de la página
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        //Le damos click a la variable
        inputsLink.click();

        //Obtenemos el título de la página
        System.out.println(driver.getTitle());
        //Cerramos el navegador
        driver.quit();
    }
}
