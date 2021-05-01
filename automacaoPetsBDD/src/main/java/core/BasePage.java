package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
// AguardarElemento ====================/
	
	public void esperarElemento(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

// Texto ====================/
	
	public void escrever(By by, String texto){
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

// Botao  ====================/
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}

	public boolean botaoMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}

// Seleciona Menu E SubMenu  ====================/
	public void clicarMenuSubMenu(By by1, By by2) {
	Actions action = new Actions(getDriver());
	WebElement menu = getDriver().findElement(by1);
	WebElement subMenu = getDriver().findElement(by2);
	action.moveToElement(menu).moveToElement(subMenu).click().build().perform();

}

// Obter Textos  ====================/
	public String obterTexto(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));		
		return getDriver().findElement(by).getText();
	}

// Conversor String para Float ====================/
		
		public Float conversorPrecoStringFloat(String texto){
			
			return Float.parseFloat(texto.substring(3));
			
		}

	
	
// Alerts ====================/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

// AlteraFocusSelenium
	public void alterarFocus() {
	
	for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle);
		}
	}
	
}
