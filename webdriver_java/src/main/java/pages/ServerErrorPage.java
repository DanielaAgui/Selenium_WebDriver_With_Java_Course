package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServerErrorPage {

    private WebDriver driver;
    private By errorAlert = By.tagName("h1");

    public ServerErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String errorAlert() {
        return driver.findElement(errorAlert).getText();
    }
}
