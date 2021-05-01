package suporte;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import core.Propriedades;

import static core.DriverFactory.getDriver;

public class screenshot {
	
	private static gerador horaData = new gerador();
	
	
	public void tirarScreenshot() throws IOException{
		
		if(Propriedades.TIRAR_SCREENSHOT) {
			
		//Pega o nome do metodo atual para a screenshot
		String nomeMetodoAtual = new Throwable()
					.getStackTrace()[1].getMethodName();
			
		//Tira a screenshot
		TakesScreenshot sc = (TakesScreenshot) getDriver();
		
		//Salva a screenshot na pasta target com
		File evidencia = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(evidencia, new File("src\\test\\resources\\evidencias" + File.separator + 
				"evidencia_"+ nomeMetodoAtual + "_" + horaData.dataHoraArquivo()+ ".jpg"));
		
			
		}
		
	}
	

}
