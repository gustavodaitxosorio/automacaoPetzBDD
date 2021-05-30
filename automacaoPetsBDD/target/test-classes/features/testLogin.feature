#language: pt
Funcionalidade: Testar os produtos no carrinho
  Como usuario do site da Petz
  Eu quero validar as informacoes dos produtos na pagina do carrinho
  Para garantir que as informacoes estao corretas

  Esquema do Cenario: Validar usuarios de login
    Dado entro na pagina de login
    Quando insiro usuario <user> e senha <senha> e confirmo
    Entao recebo uma mensagem <mensagem>

    Exemplos: 
      | user   | senha | mensagem            |
      | ""     | "123" | ""                  |
      | "test" | ""    | ""                  |
      | "test" | "123" | "Dados incorretos!" |
