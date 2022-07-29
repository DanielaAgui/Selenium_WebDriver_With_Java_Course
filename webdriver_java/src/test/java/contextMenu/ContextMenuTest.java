package contextMenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTests {

    @Test
    public void testContextMenu() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.clikMenuBox();
        String text = contextMenuPage.getAlertText();
        assertEquals(text, "You selected a context menu", "Alert text is incorrect");
        contextMenuPage.clickAcceptButton();
    }
}
