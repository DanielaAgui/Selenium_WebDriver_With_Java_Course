package fileUploadTest;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        //Al objeto de la nueva página le cargamos la imagen con el método
        uploadPage.uploadFile("C:\\Users\\daaguilar\\Downloads\\Nueva carpeta\\colores.jpg");
        //Verificamos que el título sea igual al esperado o envía mensaje de error
        assertEquals(uploadPage.getUploadedFiles(), "colores.jpg", "Uploaded is incorrect");
    }
}
