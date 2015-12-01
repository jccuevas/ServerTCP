package ujaen.git.ppt;

public class RFC5621 {

	public static final int COMANDO_HELO = 0;
	public static final int COMANDO_QUIT = 1;
	public static final int COMANDO_DATA = 10;

	public static SMTPMensaje analizaComando(String datos) {
		SMTPMensaje result = null;

	
		String campos[] = datos.split(" ");
		String comando = campos[0];
		String parametro = campos[1];

		if (campos.length == 2) {
			
			if (comando.startsWith("HELO")) {
				result = new SMTPMensaje(RFC5621.COMANDO_HELO,comando,parametro);
				return result;
			}

			
		}
		else
			if(campos.length==1)
			{
				if (comando.equalsIgnoreCase("QUIT"))
					return new SMTPMensaje(RFC5621.COMANDO_QUIT,comando,null);;

			}
		
		return null;

	}
}