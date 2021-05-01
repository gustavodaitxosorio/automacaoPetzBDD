#language: pt
Funcionalidade: Testar os produtos no carrinho 
 Como usuario do site da Petz
 Eu quero validar as informacoes dos produtos na pagina do carrinho
 Para garantir que as informacoes estao corretas


 Cenario: Validar informacoes no carrinho do 3º produto da pagina
    Quando pesquiso pelo produto ""
    Quando clico no produto de numero 3 da pagina 
    Quando comparo as informacoes do nome do produto
    Quando comparo as informacoes do preco do produto
    Quando clico no botao do carrinho
    Entao comparo a informacao do nome do produto com a pagina anterior
    Entao comparo a informacao do preco do produto com a pagina anterior