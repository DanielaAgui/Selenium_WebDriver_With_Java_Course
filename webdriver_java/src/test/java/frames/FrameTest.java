package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTest extends BaseTests {

    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickWysiwygEditor();
        //Limpiamos el área de texto
        editorPage.clearTextArea();

        //Variables del texto a escribir
        String text1 = "Hello ";
        String text2 = "world";

        //Escribimos el texto en el área de texto
        editorPage.setTextArea(text1);
        editorPage.setTextArea(text2);
        editorPage.increaseIndent();

        //Verificamos el texto del editor
        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Text is incorrect");
   }
}
