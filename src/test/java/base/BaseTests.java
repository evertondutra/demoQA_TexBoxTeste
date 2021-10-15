package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

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

    @AfterAll
    public static void finalizar(){
        driver.quit();
    }

}
