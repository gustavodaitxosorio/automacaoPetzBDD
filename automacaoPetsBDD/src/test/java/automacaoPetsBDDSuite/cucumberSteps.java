package automacaoPetsBDDSuite;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CarrinhoPage;
import pages.InicialPage;
import pages.ResultPage;
import suporte.screenshot;
import tests.ExerciciosPropostos;

public class cucumberSteps {
	
	public InicialPage inicialPage = new InicialPage();
	public ResultPage resultPage = new ResultPage();
	public CarrinhoPage carrinhoPage = new CarrinhoPage();
	private screenshot screenshot = new screenshot();

	Logger log;
	int num = 1;
	String nomeProduto = null;
	Integer tamNomeProduto = null;
	String nomeFornecedor = null;
	String precoNormal = null;
	String precoAssinante = null;

	@Dado("pesquiso pelo produto {string}")
	public void pesquisoPeloProduto(String string) {
		inicialPage.pesquisar("ração");

		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto ração pesquisado");

	}

	@Quando("clico no produto de numero {int} da pagina")
	public void clicoNoProdutoDeNumeroDaPagina(Integer int1) {
		resultPage.selecionaResultado(3);
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto racao selecionado");

	}

	@Quando("comparo as informacoes do nome do produto")
	public void comparoAsInformacoesDoNomeDoProduto() {
		nomeProduto = resultPage.getNomeProduto();
		tamNomeProduto = nomeProduto.length();
		nomeFornecedor = resultPage.getNomeFornecedor();
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Coletadas as informações do Produto");

	}

	@Quando("comparo as informacoes do preco do produto")
	public void comparoAsInformacoesDoPrecoDoProduto() {
		precoNormal = resultPage.getPrecoNormal();
		precoAssinante = resultPage.getPrecoAssinante();
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Coletadas as informações do Produto");
		
	}

	@Quando("clico no botao do carrinho")
	public void clicoNoBotaoDoCarrinho() {
		resultPage.adicionarCarrinho();
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto adicionado no carrinho com sucesso");

	}

	@Entao("comparo a informacao do nome do produto com a pagina anterior")
	public void comparoAInformacaoDoNomeDoProdutoComAPaginaAnterior() {
		String nomeProdutoCarrinho = carrinhoPage.getNomeProdutoCarrinho(num);
		assertEquals(nomeProdutoCarrinho.substring(0, tamNomeProduto), nomeProduto);
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
	}

	@Entao("comparo a informacao do preco do produto com a pagina anterior")
	public void comparoAInformacaoDoPrecoDoProdutoComAPaginaAnterior() throws IOException {
		String precoCarrinho = carrinhoPage.getPrecoCarrinho(num);
		assertEquals(precoCarrinho, precoNormal);
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
		screenshot.tirarScreenshot();
		carrinhoPage.clicarExcluir();
		System.out.println("TERMINEI METODO");
	}
}
