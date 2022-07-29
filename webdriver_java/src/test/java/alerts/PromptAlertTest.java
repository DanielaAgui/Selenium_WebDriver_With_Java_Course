package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PromptAlertTest extends BaseTests {

    @Test
    public void testPromptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        //Creamos una variable con el texto a enviar en el input
        String text = "hola";
        //Enviamos al input el texto de la variable
        alertsPage.setInput(text);
        alertsPage.acceptButton();
        //Verificamos que el texto ingresado sea igual al texto obtenido en el resultado
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text is incorrect");
    }
}
