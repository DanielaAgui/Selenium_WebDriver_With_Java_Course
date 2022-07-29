package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTests {

    @Test
    public void testHoverUser() {
        //Creamos un objeto de hoverspage al que entramos por medio de la homepage
        var hoversPage = homePage.clickHovers();

        //Creamos un objeto caption al que vemos parándonos sobre la figura
        var caption = hoversPage.hoverOverFigure(1);

        //Devuelve true si se cumple el método, o sino devuelve un mensaje de error
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");

        //Obtiene el título y lo compara con el esperado; si no devuelve un mensaje de error
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");

        assertEquals(caption.getLinkText(), "View profile", "Caption link incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
