package comandos;

import mensajeria.PaqueteDeMovimientos;
/**
 * @author Javadabadu
 * 
 */
public class Movimiento extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteDeMovimientos pdm = (PaqueteDeMovimientos) getGson().fromJson(getCadenaLeida(), PaqueteDeMovimientos.class);
		juego.setUbicacionPersonajes(pdm.getPersonajes());
	}

}
