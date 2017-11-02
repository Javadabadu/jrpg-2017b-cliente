package comandos;

import juego.Juego;
import mensajeria.Comando;
/**
 * @author prograAvanzada
 * 
 */
public abstract class ComandosEscucha extends Comando {
	protected Juego juego;
	public void setJuego(final Juego juego) {
		this.juego = juego;
	}
	public Juego getJuego() {
		return juego;
	}

}
