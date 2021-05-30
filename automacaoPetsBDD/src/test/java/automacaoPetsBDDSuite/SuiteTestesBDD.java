package automacaoPetsBDDSuite;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.Propriedades;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import pages.InicialPage;

import org.apache.log4j.*;
import pages.InicialPage;

import static core.DriverFactory.killDriver;
import org.apache.log4j.*;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src//test//resources//features", 
	plugin = "pretty",
	monochrome = true,
	snippets = SnippetType.CAMELCASE
//	tags = "@rodar"

)
public class SuiteTestesBDD {
	
	private static InicialPage inicialPage = new InicialPage();
	
//	//descomentar caso queira alterar o momento do screenshot
//	private screenshot screenshot = new screenshot();

	@BeforeClass
	public static void inicializa(){

		if(Propriedades.LIMPAR_EVIDENCIAS)
			Arrays.stream(new File("src\\test\\resources\\evidencias").listFiles()).forEach(File::delete);
		if(Propriedades.LIMPAR_LOGS)
			Arrays.stream(new File("src\\test\\resources\\Logs").listFiles()).forEach(File::delete);
		inicialPage.inicialPage();
	}
	
//Alterei o local para ao final de cada teste para manter um padrao devido ao looping de leitura do aqruivo .cvs
//	@After
//	public void tiraScreenshot() throws IOException {
//		//screenshot.tirarScreenshot();
//	}
	
	@AfterClass
	public static void finaliza() throws IOException{
		
		if(Propriedades.FECHAR_BROWSER)
			killDriver();		
	}
}