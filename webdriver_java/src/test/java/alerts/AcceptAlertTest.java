package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AcceptAlertTest extends BaseTests {

    @Test
    public void testAcceptAlert() {
        //Creamos una página nueva desde la homepage
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.acceptButton();
        //Verificamos que el texto obtenido sea igual al esperado
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert");
    }
}
