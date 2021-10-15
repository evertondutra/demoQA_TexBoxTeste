package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TexBoxPage {
    private WebDriver driver;

    public TexBoxPage (WebDriver driver){
        this.driver =driver;
    }

    private By tituloPaginaTexBox = By.className("main-header");
    private By totalInput = By.className("form-label");
    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By btnSubmit = By.id("submit");

    private By outputName = By.id("name");
    private By outputEmail = By.id("email");
    private By outputCurrent = By.cssSelector("p#currentAddress");
    private By outputPermanent = By.cssSelector("p#permanentAddress");


    List<WebElement> listaInput = new ArrayList();


    public String obtertituloPaginaTexBox(){
        return driver.findElement(tituloPaginaTexBox).getText();
    }

    public void carregarListaInput(){
        listaInput = driver.findElements(totalInput);
    }

    public int contarTotalInput(){
        carregarListaInput();
        return  listaInput.size();
    }

    public void preencherFullName(String name){

        driver.findElement(fullName).sendKeys(name);
    }

    public void preencherEmail(String inputEmail){
        driver.findElement(email).sendKeys(inputEmail);
    }

    public void preencherCurrentAddress(String InputCurrentAddress){
        driver.findElement(currentAddress).sendKeys(InputCurrentAddress);
    }

    public void preencherPermanentAddress(String inputPermanentAddress){
        driver.findElement(permanentAddress).sendKeys(inputPermanentAddress);
    }

    public void preencherFormularioCompleto(
            String name, String inputEmail,
            String InputCurrentAddress, String inputPermanentAddress ){
        driver.findElement(fullName).sendKeys(name);
        driver.findElement(email).sendKeys(inputEmail);
        driver.findElement(currentAddress).sendKeys(InputCurrentAddress);
        driver.findElement(permanentAddress).sendKeys(inputPermanentAddress);
    }

    public void clicarBtnSubmit(){
        driver.findElement(btnSubmit).click();
    }

    public String outputName() {
        String saidaNome = driver.findElement(outputName).getText();
        return saidaNome.replace("Name:", "");
    }

    public String outputEmail(){
        String saidaEmail = driver.findElement(outputEmail).getText();
        return saidaEmail.replace("Email:", "");
    }

    public String outputCurrentAddress(){
        String saidaCurrentAddress = driver.findElement(outputCurrent).getText();
        return saidaCurrentAddress.replace("Current Address :", "");
    }

    public String outputPermanentAddress (){
        String saidaPermanenteAddress = driver.findElement(outputPermanent).getText();
        return saidaPermanenteAddress.replace("Permananet Address :", "");
    }

}
