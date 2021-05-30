package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import core.BasePage;

public class LoginPage extends BasePage {
	
	public void usuario(String user) {
		esperarElemento(By.xpath("//input[@name=\"login\"][@id=\"email\"]"));
		escrever(By.xpath("//input[@name=\"login\"][@id=\"email\"]"), user);
	}
	
	public void senha(String senha) {
		escrever(By.id("Senha"), senha);
	}
	
	public void btnEntrar() {
		clicarBotao(By.xpath("//input [@type=\"submit\"][@value=\"Entrar\"]"));
	}
	
	public String mensagemErro() {

		String mensagem = obterTextoDisponivel(By.xpath("//div[@class=\"dados-incorretos escondido\"]"));
		return mensagem;
	}
	
}

