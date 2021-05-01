package suporte;

import java.text.SimpleDateFormat;

public class gerador {
	
	public String dataHoraArquivo() {
		
		java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMddHHss").format(ts);
		
	}

}
