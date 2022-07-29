package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTest extends BaseTests {

    @Test
    public void TestHorizontalSlider() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();

        horizontalSliderPage.moveSlider();
        assertEquals(horizontalSliderPage.getRange(), "4");
    }
}
