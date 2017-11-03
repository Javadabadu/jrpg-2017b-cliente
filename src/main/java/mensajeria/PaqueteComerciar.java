package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;

import dominio.Item;
/**
 * @author Javadabadu
 */
public class PaqueteComerciar extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	private int listo = 0;
	private ArrayList<Item> itemsADar = new ArrayList<Item>();
	private ArrayList<Item> itemsAObtener = new ArrayList<Item>();
	private boolean solicitudDeComercio;
	/**
	 * Constructor por defecto
	 */
	public PaqueteComerciar() {
		setComando(Comando.COMERCIO);
		solicitudDeComercio = true;
	}
	/**
	 * obtiene la solicitud de comercio
	 */
	public boolean isSolicitudDeComercio() {
		return solicitudDeComercio;
	}
	/**
	 * setea la solicitud de comercio
	 */
	public void setSolicitudDeComercio(final boolean solicitudDeComercio) {
		this.solicitudDeComercio = solicitudDeComercio;
	}
	/**
	 * obtiene la lista de items a dar
	 */
	public ArrayList<Item> getItemsADar() {
		return itemsADar;
	}
	/**
	 * setea la lista de items a dar
	 */
	public void setItemsADar(final ArrayList<Item> itemsADar) {
		this.itemsADar = itemsADar;
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
	 * obtiene listo
	 */
	public int getListo() {
		return listo;
	}
	/**
	 * incrementa listo
	 */
	public void aumentarListo() {
		this.listo++;
	}
	/**
	 * disminuye listo
	 */
	public void disminuirListo() {
		this.listo--;
	}
	/**
	 * obtiene la lista de items a obtener
	 */
	public ArrayList<Item> getItemsAObtener() {
		return itemsAObtener;
	}
	/**
	 * setea la lista de items a obtener
	 */
	public void setItemsAObtener(final ArrayList<Item> itemsAObtener) {
		this.itemsAObtener = itemsAObtener;
	}
}
