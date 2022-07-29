package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By menuBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clikMenuBox() {
        WebElement box = driver.findElement(menuBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void clickAcceptButton() {
        driver.switchTo().alert().accept();
    }
}
