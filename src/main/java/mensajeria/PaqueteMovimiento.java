package mensajeria;

import java.io.Serializable;
/**
 * @author Javadabadu
 */
public class PaqueteMovimiento extends Paquete implements Serializable, Cloneable {

	private int id;
	private float posX;
	private float posY;
	private int direccion;
	private int frame;
	/**
	 * Constructor por defecto
	 */
	public PaqueteMovimiento() {
		setComando(Comando.MOVIMIENTO);
	}
	/**
	 * Constructor con id
	 */
	public PaqueteMovimiento(final int idPersonaje) {
		id = idPersonaje;
		setComando(Comando.MOVIMIENTO);
	}
	/**
	 * Constructor parametrizado
	 */
	public PaqueteMovimiento(final int idPersonaje, final float posX, final float posY) {
		this.id = idPersonaje;
		this.posX = posX;
		this.posY = posY;
		setComando(Comando.MOVIMIENTO);
	}
	/**
	 * obtiene el id del personaje
	 */
	public int getIdPersonaje() {
		return id;
	}
	/**
	 * setea el id del personaje
	 */
	public void setIdPersonaje(final int idPersonaje) {
		this.id = idPersonaje;
	}
	/**
	 * obtiene la posicion en X
	 */
	public float getPosX() {
		return posX;
	}
	/**
	 * setea la posicion en X
	 */
	public void setPosX(final float posX) {
		this.posX = posX;
	}
	/**
	 * obtiene la posicion en Y
	 */
	public float getPosY() {
		return posY;
	}
	/**
	 * setea la posicion en Y
	 */
	public void setPosY(final float posY) {
		this.posY = posY;
	}
	/**
	 * obtiene la direccion
	 */
	public int getDireccion() {
		return direccion;
	}
	/**
	 * setea la direccion
	 */
	public void setDireccion(final int direccion) {
		this.direccion = direccion;
	}
	/**
	 * obtiene el frame
	 */
	public int getFrame() {
		return frame;
	}
	/**
	 * setea el frame
	 */
	public void setFrame(final int frame) {
		this.frame = frame;
	}
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}

