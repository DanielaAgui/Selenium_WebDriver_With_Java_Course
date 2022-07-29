package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.ServerErrorPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTest extends BaseTests {

    @Test
    public void testForgotPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();

        forgotPasswordPage.setEmail("ejemplo@hotmail.com");

        ServerErrorPage serverErrorPage = forgotPasswordPage.clickRetrievePasswordButton();

        assertEquals("Texto incorrecto", serverErrorPage.errorAlert().contains("Internal Server Error"));
    }
}
