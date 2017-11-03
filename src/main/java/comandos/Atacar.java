package comandos;

import mensajeria.PaqueteAtacar;

public class Atacar extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteAtacar paqueteAtacar = (PaqueteAtacar) getGson().fromJson(getCadenaLeida(), PaqueteAtacar.class);
		juego.getEstadoBatalla().getEnemigo().actualizarAtributos(paqueteAtacar.getMapPersonaje());
		juego.getEstadoBatalla().getPersonaje().actualizarAtributos(paqueteAtacar.getMapEnemigo());
		juego.getEstadoBatalla().setMiTurno(true);

	}

}
