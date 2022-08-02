package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By linkPage = By.xpath("//*[@id=\"content\"]/div/a[1]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public ExampleDynamicPage clickExampleLink() {
        driver.findElement(linkPage).click();
        return new ExampleDynamicPage(driver);
    }
}
