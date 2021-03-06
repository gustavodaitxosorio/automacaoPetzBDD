package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ResultPage extends BasePage {

	public void selecionaResultado(int resultNum) {
		esperarElemento(By.xpath("(//a[@id=\"produto-href\"])["+resultNum+"]"));
		clicarBotao(By.xpath("(//a[@id=\"produto-href\"])["+resultNum+"]"));
	}	
	
	public String getNomeProduto() {
		String nomeProduto = obterTextoVisivel(By.xpath("//h1[@itemprop=\"name\"]"));
		return nomeProduto;
	}

	//considerando que o fornecedor eh a marca em si, pois nao tem fornecedor na pagina
	public String getNomeFornecedor() {
		String nomeFornecedor = obterTextoVisivel(By.xpath("//a[@itemprop=\"brand\"]"));
		return nomeFornecedor;
	}

	public String getPrecoNormal() {
		String precoNormal = obterTextoVisivel(By.xpath("//div[@class=\"price-current\"]"));
		return precoNormal;
	}

	public String getPrecoAssinante() {
		String precoAssinante = obterTextoVisivel(By.xpath("//span[@class=\"price-subscriber\"]"));
		return precoAssinante;
	}
	
	public void adicionarCarrinho() {
		clicarBotao(By.id("adicionarAoCarrinho"));
	}

}













































