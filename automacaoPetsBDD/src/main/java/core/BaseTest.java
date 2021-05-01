package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import suporte.screenshot;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.InicialPage;

// Comentado pois estou rodando os testes a partir da minha suite de Testes
public class BaseTest {
	
//	private static InicialPage inicialPage = new InicialPage();
//	
//	//descomentar caso queira alterar o momento do screenshot
////	private screenshot screenshot = new screenshot();
//	
//	
//	@BeforeClass
//	public static void inicializa(){
//		
//		if(Propriedades.LIMPAR_EVIDENCIAS) {
//			Arrays.stream(new File("target").listFiles()).forEach(File::delete);		
//		}
//		
//		inicialPage.inicialPage();
//	}
//	
//	//Alterei o local para ao final de cada teste para manter um padrao devido ao looping de leitura do aqruivo .cvs
//	@After
//	public void tiraScreenshot() throws IOException {
//		//screenshot.tirarScreenshot();
//
//	}
//	
//	@AfterClass
//	public static void finaliza() throws IOException{
//		
//		if(Propriedades.FECHAR_BROWSER) {
//			killDriver();
//		}
//	} 

}
