package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementsPage {

    private WebDriver driver;
    List<WebElement> listaItens= new ArrayList();

    private By itens = By.className("header-wrapper");

    private By btnTexBox = By.cssSelector(".menu-list :nth-child(1)");

    private By tituloDaPaginaElements = By.cssSelector("div.main-header");



    public ElementsPage(WebDriver driver){
        this.driver = driver;
    }

    public void carregarListaItens(){
        listaItens = driver.findElements(itens);
    }
    public int contarItens(){
        carregarListaItens();
        return listaItens.size();
    }


    //Botao
    public TexBoxPage clicarBtnTexBox(){
        driver.findElement(btnTexBox).click();
        return new TexBoxPage(driver);
    }

    //Text
    public String obterTituloDaPagina(){
        return driver.findElement(tituloDaPaginaElements).getText();

    }


}
