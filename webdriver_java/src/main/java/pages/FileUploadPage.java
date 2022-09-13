package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    //Método que recibe un string con el path absoluto del archivo a subir
    public void uploadFile(String absolutePathFile) {
        //Buscamos el elemento input y escribe el path de la imagen
        driver.findElement(inputField).sendKeys(absolutePathFile);
        clickUploadButton();
    }

    public String getUploadedFiles() {
        return driver.findElement(uploadedFiles).getText();
    }
}
