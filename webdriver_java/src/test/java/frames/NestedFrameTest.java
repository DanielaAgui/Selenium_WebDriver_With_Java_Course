package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFrameTest extends BaseTests {

    @Test
    public void testNestedFrames() {
        var framePage = homePage.clickFrames();
        var nestedPage = framePage.clickNestedFrames();

        nestedPage.SwitchToFrameTop();
        nestedPage.switchToFrameLeft();
        assertEquals(nestedPage.getFrameText(), "LEFT", "Text is incorrect");

        nestedPage.switchToParentFrame();
        nestedPage.switchToFrameBottom();
        assertEquals(nestedPage.getFrameText(), "BOTTOM", "Text is incorrect");
    }
}
