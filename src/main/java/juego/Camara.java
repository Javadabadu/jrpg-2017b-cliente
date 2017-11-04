package juego;

import entidades.Entidad;
/**
 * @author Javadabadu
 */
public class Camara {

	private Juego juego;
	private float yOffset;
	private float xOffset;
	/**
	 * Constructor parametrizado
	 */
	public Camara(final Juego juego, final float xOffset, final float yOffset) {
		this.juego = juego;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	/**
	 * Centra la camara
	 */
	public void centrar(final Entidad e) {
		xOffset = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
		yOffset = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
	}
	/**
	 * mueve la camara
	 */
	public void mover(final float dx, final float dy) {
		xOffset += dx;
		yOffset += dy;
	}
	/**
	 * obtiene el yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}
	/**
	 * setea el yOffset
	 */
	public void setyOffset(final float yOffset) {
		this.yOffset = yOffset;
	}
	/**
	 * obtiene el xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}
	/**
	 * setea el xOffset
	 */
	public void setxOffset(final float xOffset) {
		this.xOffset = xOffset;
	}
}
