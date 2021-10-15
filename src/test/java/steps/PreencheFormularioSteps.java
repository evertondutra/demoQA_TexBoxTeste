package steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElementsPage;
import pages.HomePage;
import pages.TexBoxPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PreencheFormularioSteps {

    private static WebDriver driver;
    private HomePage homepage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private TexBoxPage texBox = new TexBoxPage(driver);

    String name = "Everton";
    String inputEmail = "teste@teste.com";
    String inputCurrentAddress = "Carapicuiba";
    String inputPermanentAddress = "Osasco";


    @BeforeAll
    public static void inicializar(){
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver\\94\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void finalizar(){
        driver.quit();
    }



    @Dado("que estou na pagina inicial")
    public void que_estou_na_pagina_inicial() {
        homepage.carregarPaginaInicial();
        assertThat(homepage.obterNameHead(),is("ToolsQA"));
    }

    @Entao("visualizo {int} elementos de escolha")
    public void visualizo_elementos_de_escolha(Integer int1) {
        assertThat(homepage.contarElementos(),is (int1));
    }

    // Cenario 2

    @Dado("que acesso a pagina elementos")
    public void que_acesso_a_pagina_elementos() {
        que_estou_na_pagina_inicial();
        homepage.clicarBtnElements();
    }

    @Entao("e visualizo {int} listas de links")
    public void e_visualizo_listas_de_links(Integer int1) {
        assertThat(elementsPage.contarItens(), is(int1));
    }

    @Entao("visualizo o nome da pagina")
    public void visualizo_o_nome_da_pagina() {
        assertThat(elementsPage.obterTituloDaPagina(), is("Elements"));
    }

    //Cenario 3

    @Dado("que acesso a pagina TexBox")
    public void que_acesso_a_pagina_tex_box() {
        que_acesso_a_pagina_elementos();
        elementsPage.clicarBtnTexBox();
    }

    @Entao("visualizo o nome da pagina do TexBox")
    public void visualizo_o_nome_da_pagina_do_tex_box() {
        assertThat(texBox.obtertituloPaginaTexBox(), is("Text Box"));
    }

    @Entao("visualiso {int} entradas de formulario de preenchimento")
    public void visualiso_entradas_de_formulario_de_preenchimento(Integer int1) {
        assertThat(texBox.contarTotalInput(), is(int1));
    }

    //Cenario 4

    @Quando("preencho as entradas do formulario")
    public void preencho_as_entradas_do_formulario() {
        texBox.preencherFullName(name);
        texBox.preencherEmail(inputEmail);
        texBox.preencherCurrentAddress(inputCurrentAddress);
        texBox.preencherPermanentAddress(inputPermanentAddress);
    }

    @Quando("clico para enviar")
    public void clico_para_enviar() {
        texBox.clicarBtnSubmit();
    }

    @Entao("visualizo o retorno comos dados inseridos")
    public void visualizo_o_retorno_comos_dados_inseridos() {
        assertThat(texBox.contarTotalInput(), is(4));
        assertThat(texBox.outputName(), is(name));
        assertThat(texBox.outputEmail(), is(inputEmail));
        assertThat(texBox.outputCurrentAddress(), is(inputCurrentAddress));
        assertThat(texBox.outputPermanentAddress(), is(inputPermanentAddress));
    }


}
