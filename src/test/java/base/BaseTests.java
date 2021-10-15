package base;

import com.google.common.io.Files;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private static WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public static void inicializar(){
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver\\94\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @BeforeEach
    public void carregarPaginaInicial(){
        driver.get("https://demoqa.com");
        homePage = new HomePage(driver);
    }

    public void capturarTela(String name) throws IOException {
        var camera = (TakesScreenshot) driver;   // tira uma print
        File capturaDeTela = camera.getScreenshotAs(OutputType.FILE); //salva temporario
        Files.move(capturaDeTela, new File(
                "resources/screenshots/" + name +".png"));  // move a print para o local fixo
    }

    @AfterAll
    public static void finalizar(){
        driver.quit();
    }

}
