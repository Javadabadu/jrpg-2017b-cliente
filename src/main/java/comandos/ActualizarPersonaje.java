package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Clase para actualizar los comandos de los personasjes.
 * 
 * @author PrograAvanzadaUnlam
 *
 */
public class ActualizarPersonaje extends ComandosEscucha {
	@Override
	public void ejecutar(){
		PaquetePersonaje paquetePersonaje =
				(PaquetePersonaje) getGson().fromJson(getCadenaLeida(), PaquetePersonaje.class);

		juego.getPersonajesConectados().remove(paquetePersonaje.getId());
		juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);

		if (juego.getPersonaje().getId() == paquetePersonaje.getId()){
		    juego.actualizarPersonaje();
		    juego.getEstadoJuego().actualizarPersonaje();
            juego.getCliente().actualizarItems(paquetePersonaje);
            juego.getCliente().actualizarPersonaje(
            		juego.getPersonajesConectados().get(paquetePersonaje.getId()));
		}
	}
}
