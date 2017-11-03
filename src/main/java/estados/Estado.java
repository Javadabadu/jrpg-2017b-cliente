package estados;

import java.awt.Graphics;

import juego.Juego;
/**
 * @author Javadabadu
 */
public abstract class Estado {

	private static Estado estadoActual = null;

	// Tipo de estados
	private static int estadoOffline = 0;
	private static int estadoJuego = 1;
	private static int estadoBatalla = 2;

	protected Juego juego;
	/**
	 * Constructor
	 */
	public Estado(final Juego juego) {
		this.juego = juego;
	}
	/**
	 * actualiza
	 */
	public abstract void actualizar();
	/**
	 * grafica
	 */
	public abstract void graficar(Graphics g);
	/**
	 * setea el estado
	 */
	public static void setEstado(final Estado estado) {
		estadoActual = estado;
	}
	/**
	 * obtiene el estado
	 */
	public static Estado getEstado() {
		return estadoActual;
	}
	/**
	 * Verifica si es un estado de juego
	 */
	public abstract boolean esEstadoDeJuego();
	/**
	 * obtiene estadoOffline
	 */
	public static int getEstadoOffline() {
		return estadoOffline;
	}
	/**
	 * setea estadoOffline
	 */
	public static void setEstadoOffline(final int estadoOffline) {
		Estado.estadoOffline = estadoOffline;
	}
	/**
	 * obtiene estadoJuego
	 */
	public static int getEstadoJuego() {
		return estadoJuego;
	}
	/**
	 * setea estadoJuego
	 */
	public static void setEstadoJuego(final int estadoJuego) {
		Estado.estadoJuego = estadoJuego;
	}
	/**
	 * obtiene estadoBatalla
	 */
	public static int getEstadoBatalla() {
		return estadoBatalla;
	}
	/**
	 * setea estadoBatalla
	 */
	public static void setEstadoBatalla(final int estadoBatalla) {
		Estado.estadoBatalla = estadoBatalla;
	}
}
