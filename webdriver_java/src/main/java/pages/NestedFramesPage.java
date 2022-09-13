package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;

public class NestedFramesPage {

    private WebDriver driver;
    //Iframes en variables para utilizar el método switchTo()
    private String frameTop = "frame-top";
    private String frameLeft = "frame-left";
    private String frameBottom = "frame-bottom";
    private By frameBodyText = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToParentFrame () {
        //Para cambiar entre iframes y la página web principal
        driver.switchTo().defaultContent();
    }

    //Métodos para cambiar entre iframes según su ubicación
    public void SwitchToFrameTop() {
        driver.switchTo().frame(frameTop);
    }

    public void switchToFrameLeft() {
        driver.switchTo().frame(frameLeft);
    }

    public void switchToFrameBottom() {
        driver.switchTo().frame(frameBottom);
    }

    public String getFrameText() {
        return driver.findElement(frameBodyText).getText();
    }
}
