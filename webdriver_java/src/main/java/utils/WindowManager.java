package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    //Creamos un objeto Navigation
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    //Retrocede la página web
    public void goBack() {
        navigate.back();
    }

    //Avanza la página web
    public void goForward() {
        navigate.forward();
    }

    //Refresca la página web
    public void refreshPage() {
        navigate.refresh();
    }

    //Va a una url dada
    public void goTo(String url) {
        navigate.to(url);
    }

    public void switchToTab(String tabTitle) {
        //Variable que devuelve identificadores de todas las ventanas abiertas
        var windows = driver.getWindowHandles();
        //Imprime cuantas ventanas abiertas hay
        System.out.println("Number of tabs: " + windows.size());
        windows.forEach(System.out::println);

        //Itera sobre las ventanas abiertas
        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            //Cambia a la nueva ventana
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            //Si el título del tab es igual al título de la ventana actual
            if (tabTitle.equals(driver.getTitle())) {
                //Rompe el ciclo
                break;
            }
        }
    }
}
