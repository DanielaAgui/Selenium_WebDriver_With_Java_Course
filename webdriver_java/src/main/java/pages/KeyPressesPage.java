package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Encuentra el elemento input y escribe en él
    public void enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPi() {
        //Con chord podemos simular presionar varias teclas simultáneamente
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    //Devuelve el resultado de lo escrito en el input
    public String getResult() {
        return driver.findElement(resultText).getText();
    }
}
