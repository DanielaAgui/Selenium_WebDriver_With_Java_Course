package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFrameTest extends BaseTests {

    @Test
    public void testNestedFrames() {
        var framePage = homePage.clickFrames();
        var nestedPage = framePage.clickNestedFrames();

        //Cambiamos al frame superior que contiene al frame de la izquierda
        nestedPage.SwitchToFrameTop();
        //Cambiamos al frame de la izquierda
        nestedPage.switchToFrameLeft();
        //Verificamos el texto del frame
        assertEquals(nestedPage.getFrameText(), "LEFT", "Text is incorrect");

        //Cambiamos al frame padre
        nestedPage.switchToParentFrame();
        //Cambiamos al framem de abajo
        nestedPage.switchToFrameBottom();
        //Verificamos el texto del frame
        assertEquals(nestedPage.getFrameText(), "BOTTOM", "Text is incorrect");
    }
}
