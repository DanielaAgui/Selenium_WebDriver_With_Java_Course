package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Buscamos el elemento y escribe el email pasado por parámetro
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public ServerErrorPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new ServerErrorPage(driver);
    }
}
