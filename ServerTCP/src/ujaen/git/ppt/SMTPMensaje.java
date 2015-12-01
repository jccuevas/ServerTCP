package ujaen.git.ppt;

public class SMTPMensaje {
	
	protected int mTipo;
	protected String mComando="";
	protected String parametro="";
	
	SMTPMensaje(int tipo,String comando, String parametro)
	{
		mTipo=tipo;
		mComando=comando;
		this.parametro=parametro;
		
	}

	public int getTipo() {
		return mTipo;
	}

	public void setTipo(int mTipo) {
		this.mTipo = mTipo;
	}

	public String getmComando() {
		return mComando;
	}

	public void setmComando(String mComando) {
		this.mComando = mComando;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	
	
}
