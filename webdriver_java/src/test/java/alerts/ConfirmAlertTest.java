package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConfirmAlertTest extends BaseTests {

    @Test
    public void testConfirmAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        //Creamos una variable donde guardamos el texto obtenido de la alerta
        String text = alertsPage.getAlertText();
        alertsPage.dismissButton();
        //Verificamos que el texto sea igual al esperado o envia mensaje de error
        assertEquals(text, "I am a JS Confirm", "Alert texts is incorrect");
    }
}
