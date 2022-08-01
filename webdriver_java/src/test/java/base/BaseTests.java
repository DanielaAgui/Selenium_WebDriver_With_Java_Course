package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    //Creamos un objeto de la página a analizar
    protected HomePage homePage;

    //Se ejecuta antes de comenzar todos los tests
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //Proporciona un tiempo de espera entre cada paso de prueba
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Volvemos a la página principal
        goHome();

        //Instanciamos la página principal
        homePage =  new HomePage(driver);
    }
    //Se ejecuta antes de comenzar cada método (útil cuando se tienen varias pruebas en una misma Java Class)
    @BeforeMethod
    public void goHome() {
        //Obtiene la página de la prueba
        driver.get("https://the-internet.herokuapp.com/");
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
