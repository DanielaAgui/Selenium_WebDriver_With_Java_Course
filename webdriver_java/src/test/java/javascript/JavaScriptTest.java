package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTest extends BaseTests {

    @Test
    public void testScrollToTable() {
        var largeAndDeep = homePage.clickLargeAndDeepDom();
        largeAndDeep.scrollToTable();
    }

    @Test
    public void testScrollToParagraph() {
        var infiniteScroll = homePage.clickInfiniteScroll();
        infiniteScroll.scrollToParagraph(10);
    }
}
