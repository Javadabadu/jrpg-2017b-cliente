package mensajeria;

import java.io.Serializable;
import java.util.Map;
/**
 * 
 * @author Javadabadu
 *
 */
public class PaqueteDePersonajes extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaquetePersonaje> personajes;
	/**
	 * Constructor por defecto
	 */
	public PaqueteDePersonajes() {

	}
	/**
	 * Constructor parametrizado
	 */
	public PaqueteDePersonajes(final Map<Integer, PaquetePersonaje> personajes) {
		this.personajes = personajes;
	}
	/**
	 * obtener personajes
	 */
	public Map<Integer, PaquetePersonaje> getPersonajes() {
		return personajes;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

}