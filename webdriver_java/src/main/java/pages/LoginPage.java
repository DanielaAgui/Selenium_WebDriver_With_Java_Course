package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Creamos una clase nueva por cada página abierta del test
public class LoginPage {

    //Agregamos el webdriver a usar
    private final WebDriver driver;

    //Agregamos los campos que vamos a testear
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Creamos métodos para interactuar con cada campo
    public void setUsername(String username) {
        //Localizamos el campo y escribimos en él (sendkeys)
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
