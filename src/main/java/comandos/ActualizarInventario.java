package comandos;

import mensajeria.PaquetePersonaje;
<<<<<<< HEAD
/**
 * 
 * @author UnlamPrograAvanzada
 * se actualiza el inventario
=======

/**
 * Actualiza el Inventario del personaje.
 * @author prograAvanzada
 * 
>>>>>>> effef49f97e6a125aa58f5894f3f977cfc47255b
 */
public class ActualizarInventario extends ComandosEscucha {

	@Override
	public void ejecutar() {
<<<<<<< HEAD
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
=======
		PaquetePersonaje pP;
		pP= (PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);
		juego.getPersonajesConectados().remove(pP.getId());
		juego.getPersonajesConectados().put(pP.getId(), pP);
		if (juego.getPersonaje().getId() == pP.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(pP);
			juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(pP.getId()));
>>>>>>> effef49f97e6a125aa58f5894f3f977cfc47255b
		}
	}
	
}
