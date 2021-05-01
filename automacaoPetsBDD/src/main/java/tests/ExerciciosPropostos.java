package tests;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import core.BaseTest;
import pages.CarrinhoPage;
import pages.InicialPage;
import pages.ResultPage;
import suporte.screenshot;

public class ExerciciosPropostos  extends BaseTest{
	

	public InicialPage inicialPage = new InicialPage();
	public ResultPage resultPage = new ResultPage();
	public CarrinhoPage carrinhoPage = new CarrinhoPage();
	private screenshot screenshot = new screenshot();
	
	@Test
	public void Exercicio1() throws IOException {
		Logger log;
		int num = 1;
		
		System.out.println("Estou testando o Exercicio 1, cenario: 1");
		inicialPage.pesquisar("ração");

		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto ração pesquisado");

		resultPage.selecionaResultado(3);
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto racao selecionado");
		
		String nomeProduto = resultPage.getNomeProduto();
		Integer tamNomeProduto = nomeProduto.length();
		
		String nomeFornecedor = resultPage.getNomeFornecedor();
		String precoNormal = resultPage.getPrecoNormal();
		String precoAssinante = resultPage.getPrecoAssinante();
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Coletadas as informações do Produto");
		resultPage.adicionarCarrinho();
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Produto adicionado no carrinho com sucesso");
		String nomeProdutoCarrinho = carrinhoPage.getNomeProdutoCarrinho(num);
		String precoCarrinho = carrinhoPage.getPrecoCarrinho(num);
		
		assertEquals(nomeProdutoCarrinho.substring(0, tamNomeProduto), nomeProduto);
		assertEquals(precoCarrinho, precoNormal);
		
		log = Logger.getLogger(ExerciciosPropostos.class);
		log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
		
		screenshot.tirarScreenshot();
		carrinhoPage.clicarExcluir();
	}
	
	@Test
	public void Exercicio2() throws IOException {
		
		String path = "src\\main\\resources\\Exercicio2.csv";
		String line = "";
		Logger log;
		BufferedReader br = new BufferedReader(new FileReader(path));
		int num = 1 ;
		while((line = br.readLine()) != null) {
			while((line = br.readLine()) != null) {
				
				String[] value = line.split(",");
				System.out.println("Estou testando o Exercicio 2, cenario: " + value[0]);

				inicialPage.pesquisar(value[1]);
				log = Logger.getLogger(ExerciciosPropostos.class);
				log.info("Produto "+ value[0]+" pesquisado");

				resultPage.selecionaResultado(3);
				log = Logger.getLogger(ExerciciosPropostos.class);
				log.info("Produto "+ value[0]+" selecionado");
				
				String nomeProduto = resultPage.getNomeProduto();
				Integer tamNomeProduto = nomeProduto.length();
				
				//Não eh possivel validar na pagina do carrinho
				String nomeFornecedor = resultPage.getNomeFornecedor();
				
				String precoNormal = resultPage.getPrecoNormal();
				
				//Não eh possivel validar na pagina do carrinho
				String precoAssinante = resultPage.getPrecoAssinante();
				log = Logger.getLogger(ExerciciosPropostos.class);
				log.info("Coletadas as informações do Produto");
				
				resultPage.adicionarCarrinho();
				log = Logger.getLogger(ExerciciosPropostos.class);
				log.info("Produto adicionado no carrinho com sucesso");
				
				String nomeProdutoCarrinho = carrinhoPage.getNomeProdutoCarrinho(num);
				String precoCarrinho = carrinhoPage.getPrecoCarrinho(num);
				
				assertEquals(nomeProdutoCarrinho.substring(0, tamNomeProduto), nomeProduto);
				assertEquals(precoCarrinho, precoNormal);
				log = Logger.getLogger(ExerciciosPropostos.class);
				log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
				
				num++;
				screenshot.tirarScreenshot();
				
			}
		}
		for(int cont = 1; cont <num; cont ++)
		carrinhoPage.clicarExcluir();
	}
	
}
