package core;

public class Propriedades {
	
	public static boolean LIMPAR_LOGS = true;
	public static boolean FECHAR_BROWSER = true;
	public static boolean TIRAR_SCREENSHOT = true;
	public static boolean LIMPAR_EVIDENCIAS = true;
	
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
