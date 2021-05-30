package automacaoPetsBDDSuite;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import core.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;
import pages.CarrinhoPage;
import pages.InicialPage;
import pages.LoginPage;
import pages.ResultPage;
import suporte.screenshot;



public class cucumberSteps extends BaseTest{
	
	public InicialPage inicialPage = new InicialPage();
	public ResultPage resultPage = new ResultPage();
	public CarrinhoPage carrinhoPage = new CarrinhoPage();
	public LoginPage loginPage = new LoginPage();
	private screenshot screenshot = new screenshot();

	Logger log;
	
	int num = 1;
	String nomeProduto = null;
	Integer tamNomeProduto = null;
	String nomeFornecedor = null;
	String precoNormal = null;
	String precoAssinante = null;

	@Dado("pesquiso pelo produto {string}")
	public void pesquisoPeloProduto(String string){

		System.out.println("TESTE:  " + string);
		inicialPage.pesquisar(string);

		log = Logger.getLogger(cucumberSteps.class);
		log.info("Produto ração pesquisado");
		
	}
	
	@Dado("pesquisar pelo produto: {string}")
	public void pesquisarPeloProduto(String string) {
		System.out.println("TESTE:  " + string);
	}


	
	@Quando("clico no produto de numero {int} da pagina")
	public void clicoNoProdutoDeNumeroDaPagina(Integer int1) {
		resultPage.selecionaResultado(int1);
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Produto racao selecionado");

	}

	@Quando("comparo as informacoes do nome do produto")
	public void comparoAsInformacoesDoNomeDoProduto() {
		nomeProduto = resultPage.getNomeProduto();
		tamNomeProduto = nomeProduto.length();
		nomeFornecedor = resultPage.getNomeFornecedor();
		
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Coletadas as informações do Produto");

	}

	@Quando("comparo as informacoes do preco do produto")
	public void comparoAsInformacoesDoPrecoDoProduto() {
		precoNormal = resultPage.getPrecoNormal();
		precoAssinante = resultPage.getPrecoAssinante();
		
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Coletadas as informações do Produto");
		
	}

	@Quando("clico no botao do carrinho")
	public void clicoNoBotaoDoCarrinho() {
		resultPage.adicionarCarrinho();
		
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Produto adicionado no carrinho com sucesso");

	}

	@Entao("comparo a informacao do nome do produto com a pagina anterior")
	public void comparoAInformacaoDoNomeDoProdutoComAPaginaAnterior() {
		String nomeProdutoCarrinho = carrinhoPage.getNomeProdutoCarrinho(num);
		assertEquals(nomeProdutoCarrinho.substring(0, tamNomeProduto), nomeProduto);
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
	}

	@Entao("comparo a informacao do preco do produto com a pagina anterior")
	public void comparoAInformacaoDoPrecoDoProdutoComAPaginaAnterior() throws IOException {
		String precoCarrinho = carrinhoPage.getPrecoCarrinho(num);
		assertEquals(precoCarrinho, precoNormal);
		
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
		screenshot.tirarScreenshot();
		carrinhoPage.clicarExcluir();
		System.out.println("TERMINEI METODO");
	}
	
	@Dado("entro na pagina de login")
	public void entroNaPaginaDeLogin() {
	    inicialPage.loginPage();
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Estou na pagina de login");
	}

	@Quando("insiro usuario {string} e senha {string} e confirmo")
	public void insiroUuarioESenhaEConfirmo(String user, String senha) {
	    loginPage.usuario(user);
	    loginPage.senha(senha);
	    loginPage.btnEntrar();
		log = Logger.getLogger(cucumberSteps.class);
		log.info("Forneci usuario " + user + " e senha "+senha+" ao sistema");
	}

	@Entao("recebo uma mensagem {string}")
	public void receboUmaMensagem(String string) {
	    String mensagemRecebida = loginPage.mensagemErro();
	    assertEquals(string, mensagemRecebida);    

	    log = Logger.getLogger(cucumberSteps.class);
	    log.info("Recebi a mensagem: " + string);

			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
