package homepage;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ElementsPage;
import pages.TexBoxPage;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomePageTests extends BaseTests {


//    String name = "Everton";
//    String inputEmail = "teste@teste.com";
//    String inputCurrentAddress = "Carapicuiba";
//    String inputPermanentAddress = "Osasco";

    @Test
    public void testContarElementos_seisElementos(){
        carregarPaginaInicial();
        assertThat(homePage.contarElementos(), is(6));
        assertThat(homePage.obterNameHead(), is ("ToolsQA"));
    }


    @Test
    public void testAcessarPaginaElements_validarPagina(){

        ElementsPage elementsPage = homePage.clicarBtnElements();
        //Validando
        assertThat(elementsPage.obterTituloDaPagina(), is("Elements"));
        assertThat(elementsPage.contarItens(), is(6));


    }

    @Test
    public void testAcessarPaginaTexBox_validarPagina(){
        ElementsPage elementsPage = homePage.clicarBtnElements();
        TexBoxPage texBoxPage = elementsPage.clicarBtnTexBox();

        assertThat(texBoxPage.obtertituloPaginaTexBox(), is("Text Box"));
        assertThat(texBoxPage.contarTotalInput(), is(4));
    }

    @ParameterizedTest
    @CsvSource({"Tone, tone@tone.com, osasco, jandira", "Gra, gra@teste.com, carapicuiba, osasco"})
    public void testPreencherInput_ValidarRetornoFormulario(String name, String inputEmail, String inputCurrentAddress,
                                                            String inputPermanentAddress) throws IOException {
        ElementsPage elementsPage = homePage.clicarBtnElements();
        TexBoxPage texBoxPage = elementsPage.clicarBtnTexBox();
        texBoxPage.preencherFormularioCompleto(name, inputEmail, inputCurrentAddress, inputPermanentAddress);
//        texBoxPage.preencherFullName(name);
//        texBoxPage.preencherEmail(inputEmail);
//        texBoxPage.preencherCurrentAddress(inputCurrentAddress);
//        texBoxPage.preencherPermanentAddress(inputPermanentAddress);
        texBoxPage.clicarBtnSubmit();

        capturarTela(name);
        // validação
        assertThat(texBoxPage.outputName(), is (name));
        assertThat(texBoxPage.outputEmail(),is(inputEmail));
        assertThat(texBoxPage.outputCurrentAddress(),is(inputCurrentAddress));
        assertThat(texBoxPage.outputPermanentAddress(), is(inputPermanentAddress));





    }

}
