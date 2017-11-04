package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dominio.Item;
import estados.Estado;

/**
 * Clase que sirve para paquetizar un personaje
 * 
 * @author progra Avanzada
 *
 */
public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	private static final int DE_CASTA = 15;
	private static final int NO_CASTA = 10;
	//El coeficiente de asignacion contendra el valor a ser multiplicado para los puntos a asignar
	private static final int COEF_ASIGN = 3; 
	private int id;
	private int idMapa;
	private int estado;
	private String casta;
	private String nombre;
	private String raza;
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private int destreza;
	private int inteligencia;
	private int nivel = 1;
	private int experiencia;
	private ArrayList<Item> items = new ArrayList<Item>();

	/**
	 * Constructor
	 * 
	 * @throws IOException
	 */
	public PaquetePersonaje() throws IOException {
		estado = Estado.getEstadoOffline();
	}

	/**
	 * 
	 * @return estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Setea el estado
	 * 
	 * @param estado
	 */
	public void setEstado(final int estado) {
		this.estado = estado;
	}

	/**
	 * Obtener el mapa donde se encuentra el personaje
	 * 
	 * @return numero de mapa
	 */
	public int getMapa() {
		return idMapa;
	}

	/**
	 * Setear un mapa
	 * 
	 * @param mapa
	 */
	public void setMapa(final int mapa) {
		idMapa = mapa;
	}

	/**
	 * Obtener el nivel del personaje
	 * 
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Setear nivel del personaje
	 * 
	 * @param nivel
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Obtener la experiencia
	 * 
	 * @return experiencia
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Setear experiencia al personaje
	 * 
	 * @param experiencia
	 */
	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Obtener el id del personaje
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setear un id al personaje
	 * 
	 * @param id
	 */

	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Obtener la casta la cual pertenece el personaje
	 * 
	 * @return caste
	 */

	public String getCasta() {
		return casta;
	}

	/**
	 * Setear casta
	 * 
	 * @param casta
	 */

	public void setCasta(final String casta) {
		this.casta = casta;
	}

	/**
	 * Obtener el nombre del personaje
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establecer un nombre al personaje
	 * 
	 * @param nombre
	 */

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener la raza
	 * 
	 * @return raza
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * Establecer raza
	 * 
	 * @param raza
	 */

	public void setRaza(final String raza) {
		this.raza = raza;
	}

	/**
	 * Obtener la salud tope
	 * 
	 * @return salud tope
	 */

	public int getSaludTope() {
		return saludTope;
	}

	/**
	 * Establecer salud tope
	 * 
	 * @param saludTope
	 */

	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	/**
	 * Obtener Energia tope
	 * 
	 * @return energia tope
	 */

	public int getEnergiaTope() {
		return energiaTope;
	}

	/**
	 * Establecer energia tope
	 * 
	 * @param energiaTope
	 */
	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
	}

	/**
	 * Obtener fuerza
	 * 
	 * @return fuerza
	 */

	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Establecer fuerza
	 * 
	 * @param fuerza
	 */

	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * Obtener destreza
	 * 
	 * @return destreza
	 */

	public int getDestreza() {
		return destreza;
	}

	/**
	 * Establecer destreza
	 * 
	 * @param destreza
	 */

	public void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	/**
	 * Obtener inteligencia
	 * 
	 * @return inteligencia
	 */

	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Establecer inteligencia
	 * 
	 * @param inteligencia
	 */

	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}

	/**
	 * Metodo para clonar un paquete.
	 */
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

	/**
	 * metodo para añadir un item de la lista
	 * 
	 * @param i
	 */
	public final void anadirItem(final Item i) {
		items.add(i);
	}

	/**
	 * metodo para remover un item del la lista
	 * 
	 * @param i
	 */
	public final void removerItem(final Item i) {
		items.remove(i);
	}

	/**
	 * metodo para obtener los items.
	 * 
	 * @return
	 */
	public ArrayList<Item> getItems() {
		return new ArrayList<Item>(items);
	}

	/**
	 * metodo para establecer un listado de items
	 * 
	 * @param items
	 */
	public final void setItems(final ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * metodo para obtener un item a partir de su id
	 * 
	 * @param index
	 * @return item
	 */
	public final int getItemID(final int index) {
		return items.get(index).getIdItem();
	}

	/**
	 * metodo para añadir un item en particular
	 * 
	 * @param idItem
	 * @param nombre
	 * @param wearLocation
	 * @param bonusSalud
	 * @param bonusEnergia
	 * @param bonusAtaque
	 * @param bonusDefensa
	 * @param bonusMagia
	 * @param foto
	 * @param fotoEquipado
	 */
	public final void anadirItem(final int idItem, final String nombre, final int wearLocation, final int bonusSalud,
			final int bonusEnergia, final int bonusAtaque, final int bonusDefensa, final int bonusMagia,
			final String foto, final String fotoEquipado) {
		try {
			items.add(new Item(idItem, nombre, wearLocation, bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
					bonusMagia, foto, fotoEquipado));

			useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló al añadir item");

		}
	}

	/**
	 * metodo para remover Bonus
	 */
	public final void removerBonus() {
		// Intente usar un iterator y por alguna razón no andaba..
		int i = 0;
		while (i < items.size()) {
			sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
			i++;
		}
	}

	/**
	 * metodo para sacar bonus
	 * @param bonusSalud
	 * @param bonusEnergia
	 * @param bonusAtaque
	 * @param bonusDefensa
	 * @param bonusMagia
	 */
	
	public final void sacarBonus(final int bonusSalud, final int bonusEnergia, final int bonusAtaque,
								 final int bonusDefensa, final int bonusMagia) {
		saludTope -= bonusSalud;
		energiaTope -= bonusEnergia;
		fuerza -= bonusAtaque;
		destreza -= bonusDefensa;
		inteligencia -= bonusMagia;
	}

	/**
	 * metodo para poner bonus
	 */
	public final void ponerBonus() {
		// Intente usar un iterator y por alguna razón no andaba..
		int i = 0;
		while (i < items.size()) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
			i++;
		}
	}

	/**
	 * 
	 * @param bonusSalud
	 * @param bonusEnergia
	 * @param bonusAtaque
	 * @param bonusDefensa
	 * @param bonusMagia
	 */
	public void useBonus(final int bonusSalud, final int bonusEnergia,
						 final int bonusAtaque, final int bonusDefensa,
						 final int bonusMagia) {
		saludTope += bonusSalud;
		energiaTope += bonusEnergia;
		fuerza += bonusAtaque;
		destreza += bonusDefensa;
		inteligencia += bonusMagia;
	}

	/**
	 * 
	 * @return
	 */
	public int getCantItems() {
		return items.size();
	}

	/**
	 * 
	 * @param idItem
	 */
	public void anadirItem(final int idItem) {
		try {
			items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló al añadir item");
		}

	}

	/**
	 * 
	 * @return
	 */
	public Iterator<Item> getIterator() {
		// TODO Auto-generated method stub
		return items.iterator();
	}

	/**
	 * metodo para remover el ultimo item
	 */
	public void removerUltimoItem() {
		items.remove(items.size() - 1);

	}

	/**
	 * metodo para saber si hay un nuevo item
	 * @return V o F
	 */
	public boolean nuevoItem() {
		return items.get(items.size() - 1).getNombre() == null;
	}

	/**
	 * 
	 * @param cantItems
	 */
	public void ponerBonus(final int cantItems) {
		int i = 0;
		while (i < cantItems) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
			i++;
		}
	}

	/**
	 * 
	 */
	public void sacarUltimoItem() {
		int i = items.size() - 1;
		if (i >= 0) {
			sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
		}
	}

	/**
	 * 
	 */
	public void ponerUltimoItem() {
		int i = items.size() - 1;
		if (i >= 0) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
		}
	}

	/**
	 * elimina todos los items
	 */
	public void eliminarItems() {
		items.removeAll(items);
	}

	/**
	 * Actualiza los items luego de un trueque
	 * @param items
	 */
	public void actualizarTrueque(final ArrayList<Item> items) {
		this.items.removeAll(this.items);
		for (Item item : items) {
			this.items.add(item);
		}
	}

	/**
	 * Metodos que me devuelven 
	 * los atributos iniciales segun la casta.
	 * @return
	 */
	public final int getFuerzaInicial() {
		int fuerza;
		if (this.getCasta().equals("Guerrero")) {
			fuerza = DE_CASTA;
		} else {
			fuerza = NO_CASTA;
		}
		// Obtiene los puntos de fuerza segun el nivel del personaje
		for (Item item : items) {
			fuerza += item.getBonusFuerza();
		}
		return fuerza;

	}

	public final int getDestrezaInicial() {
		int destreza;
		if (this.getCasta().equals("Asesino")) {
			destreza = DE_CASTA;
		} else {
			destreza = NO_CASTA;
		}
		// Obtiene los puntos de destreza segun el nivel del personaje
		for (Item item : items) {
			destreza += item.getBonusDestreza();
		}
		return destreza;
	}

	public final int getInteligenciaInicial() {
		int inteligencia;
		if (this.getCasta().equals("Hechicero")) {
			inteligencia = DE_CASTA;
		} else {
			inteligencia = NO_CASTA;
		}
		// Obtiene los puntos de inteligencia segun el nivel del personaje
		for (Item item : items) {
			inteligencia += item.getBonusInteligencia();
		}
		return inteligencia;
	}

	/**
	 * puntos a asignar
	 * @return
	 */
	public final int getPuntosAsignar() {
		int puntosAsignar = nivel * COEF_ASIGN;
		int totalPuntosInicial = this.getFuerzaInicial() + this.getDestrezaInicial() + this.getInteligenciaInicial();
		int totalPuntosActual = this.getFuerza() + this.getDestreza() + this.getInteligencia();

		return puntosAsignar - (totalPuntosActual - totalPuntosInicial);
	}
}
