package comandos;

import mensajeria.PaquetePersonaje;

/**
 * 
 * @author UnlamPrograAvanzada
 * se actualiza el inventario
 */

public class ActualizarInventario extends ComandosEscucha {

	@Override
	public void ejecutar() {

		PaquetePersonaje paquetePersonaje =
				(PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);
		juego.getPersonajesConectados().remove(paquetePersonaje.getId());
		juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);
		if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(paquetePersonaje);
			juego.getCliente().actualizarPersonaje(
					juego.getPersonajesConectados().get(paquetePersonaje.getId()));

		PaquetePersonaje pP;
		pP= (PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);
		juego.getPersonajesConectados().remove(pP.getId());
		juego.getPersonajesConectados().put(pP.getId(), pP);
		if (juego.getPersonaje().getId() == pP.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(pP);
			juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(pP.getId()));

		}
	}
	
}
}
