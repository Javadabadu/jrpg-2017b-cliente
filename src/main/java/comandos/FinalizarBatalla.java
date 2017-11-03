package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;
/**
 * Finaliza la batalla
 * @author Javadavadu
 * 
 */
public class FinalizarBatalla extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteFinalizarBatalla paqueteFinalizarBatalla =
				(PaqueteFinalizarBatalla) gson.fromJson(cadenaLeida, PaqueteFinalizarBatalla.class);
		juego.getPersonaje().setEstado(Estado.getEstadoJuego());
		Estado.setEstado(juego.getEstadoJuego());
	}
}
