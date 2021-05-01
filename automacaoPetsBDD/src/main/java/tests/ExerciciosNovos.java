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


public class ExerciciosNovos  extends BaseTest{
	

	public InicialPage inicialPage = new InicialPage();
	public ResultPage resultPage = new ResultPage();
	public CarrinhoPage carrinhoPage = new CarrinhoPage();
	private screenshot screenshot = new screenshot();
	


	
		@Test
		public void Exercicio3() throws IOException {
			
			String path = "src\\main\\resources\\Exercicio3.csv";
			String line = "";
			Logger log;
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			float valorTotal = 0;
			int num = 1;
			while((line = br.readLine()) != null) {
				
				while((line = br.readLine()) != null) {
					
					String[] value = line.split(",");
					System.out.println("Estou testando o Exercicio 3, cenario: " + value[0]);
					inicialPage.pesquisar(value[1]);
					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Produto "+ value[0]+" pesquisado");
					
					resultPage.selecionaResultado(3);
					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Produto "+ value[0]+" selecionado");
					
					String nomeProduto = resultPage.getNomeProduto();
					Integer tamNomeProduto = nomeProduto.length();
					String precoNormal = resultPage.getPrecoNormal();
					String precoNormalFloat = precoNormal.replace(',', '.');
					
					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Coletadas as informações do Produto");
					
					Float precoFloat = Float.parseFloat(precoNormalFloat.substring(3));
					valorTotal = precoFloat + valorTotal;
					
					resultPage.adicionarCarrinho();
					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Produto adicionado no carrinho com sucesso");

					String nomeProdutoCarrinho = carrinhoPage.getNomeProdutoCarrinho(num);
					String precoCarrinho = carrinhoPage.getPrecoCarrinho(num);
					
					assertEquals(nomeProdutoCarrinho.substring(0, tamNomeProduto), nomeProduto);
					assertEquals(precoCarrinho, precoNormal);
					assertEquals(valorTotal, carrinhoPage.obterValorTotalCarrinho());

					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Comparacoes do produto na pagina de detalhes com o carrinho feito com sucesso");
					
					num++;
					screenshot.tirarScreenshot();

					log = Logger.getLogger(ExerciciosNovos.class);
					log.info("Screenshot tirada com sucesso");
				}

			}
			for(int cont = 1; cont <num; cont ++)
				carrinhoPage.clicarExcluir();
	}
	
}
