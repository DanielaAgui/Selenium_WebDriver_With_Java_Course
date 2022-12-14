package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    //Creamos una variable con el elemento a buscar
    private final By formAuthenticationLink = By.linkText("Form Authentication");

    //Creamos un constructor para llamar al webdriver
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Creamos un método con el campo que nos dirige a la nueva página web
    public LoginPage clickFormAuthentication() {
        //Buscamos el elemento según la variable creada
        driver.findElement(formAuthenticationLink).click();
        //Retornamos una nueva página
        return new LoginPage(driver);
    }

    //Métodos para todas las páginas web nuevas, pasando por parámetro el elemento para acceder a ellas
    public DropdownPage clickDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWysiwygEditor() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFrames() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindow() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    //Creamos un método genérico para dar click en cualquier opción
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
