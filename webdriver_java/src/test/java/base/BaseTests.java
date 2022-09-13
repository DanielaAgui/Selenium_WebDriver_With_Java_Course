package base;

import com.google.common.io.Files;
import okhttp3.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    //Clase que envuelve el driver para lanzar eventos
    private EventFiringWebDriver driver;
    //Creamos un objeto de la página a analizar
    protected HomePage homePage;

    //Se ejecuta antes de comenzar todos los tests
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Envolvemos el chromedriver
        //Llamamos al método de opciones cuando instanciamos el driver
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //Registramos el evento y la clase creada
        driver.register(new EventReporter());

        //Proporciona un tiempo de espera entre cada paso de prueba
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );

        //Volvemos a la página principal
        goHome();

        //Instanciamos la página principal
        homePage = new HomePage(driver);
    }

    //Se ejecuta antes de comenzar cada método (útil cuando se tienen varias pruebas en una misma Java Class)
    @BeforeMethod
    public void goHome() {
        //Obtiene la página de la prueba
        driver.get("https://the-internet.herokuapp.com/");
    }

    //Se ejecuta después de terminar todos los tests
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    //Se ejecuta después de terminar cada método
    @AfterMethod
    //Método para capturar imagenes de los test fallidos
    public void failureScreenshot(ITestResult result) {
        //Si el test es fallido obtiene el estado
        if (ITestResult.FAILURE == result.getStatus()) {
            //Creamos un objeto  que toma el Screenshot
            var camera = (TakesScreenshot) driver;
            //Creamos un archivo para guardar el screenshot
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                //Movemos el archivo a la carpeta resources como un nuevo archivo con su nombre
                Files.move(screenshot, new File("resources/screenshots/" + result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    //Método para capturar imagenes de los test exitosos
    public void successScreenshot(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Devuelve la nueva página
    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    //Permite personalizar y configurar la sesión de ChromeDriver
    private ChromeOptions getChromeOptions() {
        //Creamos una objeto de la clase
        ChromeOptions options = new ChromeOptions();
        //Elegimos lo que queremos realizar y lo pasamos por parámetro
        options.addArguments("disable-infobars"); //Quitamos los mensajes informativos de chrome
        options.addArguments("--incognito"); //Ejecutamos en modo incógnito
        return options;
    }
}
