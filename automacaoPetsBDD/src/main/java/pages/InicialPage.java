package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import core.BasePage;

public class InicialPage extends BasePage {
	
	public void inicialPage() {
		getDriver().get("https://www.petz.com.br");
	}
	
	public void pesquisar(String Texto) {
		esperarElemento(By.id("search"));
		escrever(By.id("search"), Texto);
		clicarBotao(By.xpath("//button[@class=\"button-search\"]"));
	}
	

}
