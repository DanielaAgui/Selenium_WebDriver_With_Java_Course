package waits;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTest extends BaseTests {

    @Test
    public void testExplicitWait() {
        var dynamicPage = homePage.clickDynamicLoading().clickExampleLink();
        dynamicPage.clickStart();

        assertEquals(dynamicPage.getLoadedText(), "Hello World!", "Text is incorrect");
    }
}
