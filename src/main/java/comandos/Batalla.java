package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoBatallaNPC;
import mensajeria.PaqueteBatalla;
/**
 * 
 * @author UnlamPrograAvanzada
 *
 */
public class Batalla extends ComandosEscucha{

	@Override
	public void ejecutar(){
		
		PaqueteBatalla paqueteBatalla = (PaqueteBatalla) gson.fromJson(cadenaLeida, PaqueteBatalla.class);
		juego.getPersonaje().setEstado(Estado.estadoBatalla);
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
