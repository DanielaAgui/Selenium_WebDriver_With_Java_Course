package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExampleLink();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com/");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindow().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
