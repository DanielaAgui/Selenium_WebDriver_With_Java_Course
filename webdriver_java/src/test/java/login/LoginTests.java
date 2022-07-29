package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.AssertJUnit.assertTrue;

//Creamos un package y clase para cada test a realizar
//Hereda de la clase base para tomar el webdriver y la página
public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        //Creamos un nuevo objeto con la página siguiente y los métodos correspondientes
        LoginPage loginPage = homePage.clickFormAuthentication();

        //Ejecutamos los métodos de la loginpage
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        //Creamos un nuevo objeto con la página siguiente
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        //Ejecutamos los métodos de la secureareapage y verificamos que sea correcto
        assertTrue("Alert text is incorrect", secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }
}
