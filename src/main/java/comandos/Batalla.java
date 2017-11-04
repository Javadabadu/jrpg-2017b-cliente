package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatalla;
/**
 * 
 * @author Javadabadu
 *
 */
public class Batalla extends ComandosEscucha{

	@Override
	public void ejecutar(){
		
		PaqueteBatalla paqueteBatalla = (PaqueteBatalla) getGson().fromJson(getCadenaLeida(), PaqueteBatalla.class);
		juego.getPersonaje().setEstado(Estado.getEstadoBatalla());
		Estado.setEstado(null);
		if (paqueteBatalla.getTipoBatalla() == paqueteBatalla.BATALLAPERSONAJE) {
			juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
			Estado.setEstado(juego.getEstadoBatalla());
		} else {
			juego.setEstadoBatalla(new EstadoBatallaNPC(juego, paqueteBatalla));
			Estado.setEstado(juego.getEstadoBatallaNPC());
		}
	}
}
