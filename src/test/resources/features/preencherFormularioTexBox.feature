# language: pt

  Funcionalidade: preencher o formulario Tex Box
    Ao acessar a pagina, quero preencher o formulario e visualizar o retorno

    Cenario: Deve mostrar oito elementos de escolha na pagina inicial
      Dado que estou na pagina inicial
      Entao visualizo 6 elementos de escolha


    Cenario: Acessar a pagia de elementos e validar o nome da pagina e quantidade de lista de links
      Dado que acesso a pagina elementos
      Entao e visualizo 6 listas de links
      E visualizo o nome da pagina

     Cenario: Acessar a pagina TexBox e validar o nome da pagina e o total de input
       Dado que acesso a pagina TexBox
       Entao visualizo o nome da pagina do TexBox
       E visualiso 4 entradas de formulario de preenchimento

     Cenario: Acessar a pagina TexBox, preencher os input e validar o retorno
       Dado que acesso a pagina TexBox
       Quando preencho as entradas do formulario
       E clico para enviar
       Entao visualizo o retorno comos dados inseridos