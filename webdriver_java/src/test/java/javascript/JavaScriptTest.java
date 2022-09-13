package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTest extends BaseTests {

    @Test
    public void testScrollToTable() {
        var largeAndDeep = homePage.clickLargeAndDeepDom();
        //Scroll hasta encontrar el elemento necesario
        largeAndDeep.scrollToTable();
    }

    @Test
    public void testScrollToParagraph() {
        var infiniteScroll = homePage.clickInfiniteScroll();
        //Scroll hasta el parráfo según parámetro
        infiniteScroll.scrollToParagraph(10);
    }
}
