package comandos;

import mensajeria.PaquetePersonaje;

public class ActualizarCheats extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaquetePersonaje paquetePersonaje =
				(PaquetePersonaje) getGson().fromJson(getCadenaLeida(), PaquetePersonaje.class);
		juego.getPersonajesConectados().remove(paquetePersonaje.getId());
		juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);
		if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(paquetePersonaje);
			juego.getCliente().actualizarPersonaje(
					juego.getPersonajesConectados().get(paquetePersonaje.getId()));
		}
	
	}

}
