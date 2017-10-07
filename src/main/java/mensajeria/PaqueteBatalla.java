package mensajeria;

import java.io.Serializable;

public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {
	
	public static final int BATALLAPERSONAJE = 0;
	public static final int BATALLANPC = 1;
	
	private int id;
	private int idEnemigo;
	private boolean miTurno;
	private int tipoBatalla;

	public PaqueteBatalla(){
		setComando(Comando.BATALLA);
		tipoBatalla = BATALLAPERSONAJE;
	}
	
	public PaqueteBatalla(int tipoBatalla){
		setComando(Comando.BATALLA);
		this.tipoBatalla = tipoBatalla;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo){
		this.idEnemigo = idEnemigo;
	}

	public boolean isMiTurno() {
		return miTurno;
	}

	public void setMiTurno(boolean miTurno) {
		this.miTurno = miTurno;
	}
	
	public int getTipoBatalla() {
		return tipoBatalla;
	}

	public void setTipoBatalla(int tipoBatalla){
		this.tipoBatalla = tipoBatalla;
	}
}
