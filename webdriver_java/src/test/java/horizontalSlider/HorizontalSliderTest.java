package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTest extends BaseTests {

    @Test
    public void TestHorizontalSlider() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();

        //Movemos el slider
        horizontalSliderPage.moveSlider();
        //Verificamos que el rango generado sea igual al esperado
        assertEquals(horizontalSliderPage.getRange(), "4");
    }
}
