package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;


public class HomePage {

    private WebDriver driver;

    List<WebElement> listaElementos= new ArrayList();

    private By elementos = By.className("card-body");

    private By BtnElements = By.cssSelector("div.card-body :nth-child(1)");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public int contarElementos(){
        carregarListaElementos();
        return listaElementos.size();
    }

    private void carregarListaElementos()
    {
        listaElementos = driver.findElements(elementos);
    }

    //asserts
    public String obterNameHead() {
        String nameHead = driver.getTitle();
        return nameHead;
    }


    //Buton


    public ElementsPage clicarBtnElements(){
        driver.findElement(BtnElements).click();
        return new ElementsPage(driver);
    }

    public void carregarPaginaInicial() {
        driver.get("https://demoqa.com");
    }


}
