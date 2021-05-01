package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class CarrinhoPage extends BasePage {
	
	public String getNomeProdutoCarrinho(int num) {
		esperarElemento(By.xpath("(//td[@class=\"td-resumo\"]/a)["+num+"]"));
		String nomeProduto = obterTexto(By.xpath("(//td[@class=\"td-resumo\"]/a)["+num+"]"));
		return nomeProduto;
	}

	public String getPrecoCarrinho(int num) {
		esperarElemento(By.xpath("(//td[@class=\"preco\"])["+num+"]"));
		String precoNormal = obterTexto(By.xpath("(//td[@class=\"preco\"])["+num+"]"));
		return precoNormal;
	}

	public float obterValorTotalCarrinho() {
		esperarElemento(By.xpath("//div[@class=\"right subtotalCartToDropdown\"]"));
		String valorTotal = obterTexto(By.xpath("//div[@class=\"right subtotalCartToDropdown\"]")).replace(',', '.');
		Float valorTotalFloat  = Float.parseFloat(valorTotal.substring(2));
		return valorTotalFloat;
	}

	public void clicarExcluir() {
		esperarElemento(By.xpath("//td/i[@class=\"delete-item-pedido fa fa-times\"]"));
		clicarBotao(By.xpath("//td/i[@class=\"delete-item-pedido fa fa-times\"]"));
	}

}













































