package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleDynamicPage {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("start");
    private By loadedText = By.id("finish");

    public ExampleDynamicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        //Creamos una espera en segundos para que se realice el siguiente paso hasta cumplir una condición
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //Establecemos la condición a esperar
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator))); //Esperar la invisibilidad de un elemento

        //Definimos una FluentWait
        /*FluentWait wait = new FluentWait(driver)
                //Tiempo de espera máximo para esperar una condición
                .withTimeout(Duration.ofSeconds(5))
                //Frecuencia con la que vamos a verificar que se cumpla la condición
                .pollingEvery(Duration.ofSeconds(1))
                //Especificar que excepciones ignorar
                .ignoring(NoSuchElementException.class);
        //Establecemos la condición que vamos a esperar
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));*/
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
