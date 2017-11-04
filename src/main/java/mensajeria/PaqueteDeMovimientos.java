package mensajeria;

import java.io.Serializable;
import java.util.Map;
/**
 * @author Javadabadu
 */
public class PaqueteDeMovimientos extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaqueteMovimiento> personajes;
	/**
	 * Constructor por defecto
	 */
	public PaqueteDeMovimientos() {

	}
	/**
	 * Constructor parametrizado
	 */
	public PaqueteDeMovimientos(final Map<Integer, PaqueteMovimiento> personajes) {
		this.personajes = personajes;
	}
	/**
	 * obtiene personajes
	 */
	public Map<Integer, PaqueteMovimiento> getPersonajes() {
		return personajes;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}