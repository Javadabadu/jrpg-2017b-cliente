package mensajeria;

import java.io.Serializable;
/**
 * @author Javadabadu
 */
public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {
	
	public static final int BATALLAPERSONAJE = 0;
	public static final int BATALLANPC = 1;
	
	private int id;
	private int idEnemigo;
	private boolean miTurno;
	private int tipoBatalla;
	/**
	 * Constructor por defecto
	 */
	public PaqueteBatalla() {
		setComando(Comando.BATALLA);
		tipoBatalla = BATALLAPERSONAJE;
	}
	/**
	 * Constructor parametrizado
	 */
	public PaqueteBatalla(final int tipoBatalla) {
		setComando(Comando.BATALLA);
		this.tipoBatalla = tipoBatalla;
	}
	/**
	 * obtiene el id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setea el id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * obtiene el idEnemigo
	 */
	public int getIdEnemigo() {
		return idEnemigo;
	}
	/**
	 * setea el idEnemigo
	 */
	public void setIdEnemigo(final int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
	/**
	 * obtiene miTurno
	 */
	public boolean isMiTurno() {
		return miTurno;
	}
	/**
	 * setea miTurno
	 */
	public void setMiTurno(final boolean miTurno) {
		this.miTurno = miTurno;
	}
	/**
	 * obtiene el tipo de batalla
	 */
	public int getTipoBatalla() {
		return tipoBatalla;
	}
	/**
	 * setea el tipo de batalla
	 */
	public void setTipoBatalla(final int tipoBatalla){
		this.tipoBatalla = tipoBatalla;
	}
}
