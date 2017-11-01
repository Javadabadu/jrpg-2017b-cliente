package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Actualiza el Inventario del personaje.
 * @author prograAvanzada
 * 
 */
public class ActualizarInventario extends ComandosEscucha {

	@Override
	public void ejecutar() {
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
