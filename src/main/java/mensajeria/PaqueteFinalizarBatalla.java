package mensajeria;

import java.io.Serializable;
/**
 * @author Javadabadu
 */
public class PaqueteFinalizarBatalla extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int ganadorBatalla;
	private int tipoBatalla; 
	/**
	 * Constructor por defecto
	 */
	public PaqueteFinalizarBatalla() {
		setComando(Comando.FINALIZARBATALLA);
	}
	/**
	 * obtiene el id
	 */
	public int getId() {
		return id;
	}
	/**
	 * setea el id
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
	 * obtiene el ganador de la batalla
	 */
	public int getGanadorBatalla() {
		return ganadorBatalla;
	}
	/**
	 * setea el ganador de la batalla
	 */
	public void setGanadorBatalla(final int ganadorBatalla) {
		this.ganadorBatalla = ganadorBatalla;
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
