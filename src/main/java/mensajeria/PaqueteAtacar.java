package mensajeria;

import java.io.Serializable;
import java.util.HashMap;
/**
 * @author Javadabadu
 */
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int nuevaSaludPersonaje;
	private int nuevaEnergiaPersonaje;
	private int nuevaSaludEnemigo;
	private int nuevaEnergiaEnemigo;
	private HashMap<String, Number> mapPersonaje = new HashMap<String, Number>();
	private HashMap<String, Number> mapEnemigo = new HashMap<String, Number>();
	/**
	 * Constructor parametrizado
	 */
	public PaqueteAtacar(final int id, final int idEnemigo, final int nuevaSalud,
			final int nuevaEnergia, final int nuevaSaludEnemigo,
			final int nuevaEnergiaEnemigo, final int nuevaDefensa,
			final int nuevaDefensaEnemigo, final double probEvitarDano,
			final double probEvitarDanoEnemgio) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		this.nuevaSaludPersonaje = nuevaSalud;
		this.nuevaEnergiaPersonaje = nuevaEnergia;
		this.nuevaSaludEnemigo = nuevaSaludEnemigo;
		this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
		mapPersonaje.put("salud", nuevaSalud);
		mapPersonaje.put("energia", nuevaEnergia);
		mapPersonaje.put("defensa", nuevaDefensa);
		mapPersonaje.put("probEvitarDanio", probEvitarDano);
		mapEnemigo.put("salud", nuevaSaludEnemigo);
		mapEnemigo.put("energia", nuevaEnergiaEnemigo);
		mapEnemigo.put("defensa", nuevaDefensaEnemigo);
		mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
	}
	/**
	 * obtiene el id
	 */
	public int getId() {
		return id;
	}
	/**
	 * setea el id
	 */
	public void setId(final int id) {
		this.id = id;
	}
	/**
	 * obtiene el id del enemigo
	 */
	public int getIdEnemigo() {
		return idEnemigo;
	}
	/**
	 * setea el id del enemigo
	 */
	public void setIdEnemigo(final int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
	/**
	 * obtiene la nueva salud del personaje
	 */
	public int getNuevaSaludPersonaje() {
		return nuevaSaludPersonaje;
	}
	/**
	 * setea la nueva salud del personaje
	 */
	public void setNuevaSaludPersonaje(
			final int nuevaSaludPersonaje) {
		this.nuevaSaludPersonaje = nuevaSaludPersonaje;
	}
	/**
	 * obtiene la nueva energia del personaje
	 */
	public int getNuevaEnergiaPersonaje() {
		return nuevaEnergiaPersonaje;
	}
	/**
	 * setea la nueva energia del personaje
	 */
	public void setNuevaEnergiaPersonaje(
			final int nuevaEnergiaPersonaje) {
		this.nuevaEnergiaPersonaje = nuevaEnergiaPersonaje;
	}
	/**
	 * obtiene la nueva salud del enemigo
	 */
	public int getNuevaSaludEnemigo() {
		return nuevaSaludEnemigo;
	}
	/**
	 * setea la nueva salud del enemigo
	 */
	public void setNuevaSaludEnemigo(
			final int nuevaSaludEnemigo) {
		this.nuevaSaludEnemigo = nuevaSaludEnemigo;
	}
	/**
	 * obtiene la nueva energia del enemigo
	 */
	public int getNuevaEnergiaEnemigo() {
		return nuevaEnergiaEnemigo;
	}
	/**
	 * setea la nueva energia del enemigo
	 */
	public void setNuevaEnergiaEnemigo(
			final int nuevaEnergiaEnemigo) {
		this.nuevaEnergiaEnemigo = nuevaEnergiaEnemigo;
	}
	/**
	 * devuelve el mapa del personaje
	 */
	public HashMap<String, Number> getMapPersonaje() {
		return mapPersonaje;
	}
	/**
	 * devuelve el mapa del enemigo
	 */
	public HashMap<String, Number> getMapEnemigo() {
		return mapEnemigo;
	}
}
