package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	private static final int TILES_TAM = 256;
	private static Tile[] tiles = new Tile[TILES_TAM];
	private static Tile[] aubenor;
	private static Tile[] aris;
	// es el piso de aubenor por defecto si queres llamarlo asi, es gris
	private static int arisBase = 3;
	private static int aubenorBase = 3;

	public static final int ANCHO = 64;
	public static final int ALTO = 32;

	protected BufferedImage textura;
	protected final int id;

	private boolean esSolido;

	protected int ancho;
	protected int alto;

	/**
	 * Constructor
	 * 
	 * @param textura
	 * @param id
	 * @param esSolido
	 */
	public Tile(final BufferedImage textura, final int id, final boolean esSolido) {
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.esSolido = esSolido;
	}

	/**
	 * constructor 2
	 * 
	 * @param textura
	 * @param id
	 * @param esSolido
	 * @param ancho
	 * @param alto
	 */
	public Tile(final BufferedImage textura, final int id, final boolean esSolido, final int ancho, final int alto) {
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.ancho = ancho;
		this.alto = alto;
		this.esSolido = esSolido;
	}

	/**
	 * actualizar, metodo sin uso
	 */
	public void actualizar() {

	}

	/**
	 * Grafica tomando alto y ancho por defecto
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	public void graficar(final Graphics g, final int x, final int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}

	/**
	 * grafica considerando un alto y ancho por parametro
	 * 
	 * @param g
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void graficar(final Graphics g, final int x, final int y, final int width, final int height) {
		g.drawImage(textura, x, y, width, height, null);
	}

	/**
	 * Establecer si el tile es solido o no
	 * 
	 * @param solidez
	 */
	public void setSolido(final boolean solidez) {
		esSolido = solidez;
	}

	/**
	 * 
	 * @return V o F
	 */
	public boolean esSolido() {
		return esSolido;
	}

	/**
	 * Obtengo el id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * obtengo el ancho
	 * 
	 * @return ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Obtengo el alto
	 * 
	 * @return alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * 
	 * @return vector de tiles
	 */
	public static Tile[] getTiles() {
		return tiles;
	}

	/**
	 * 
	 * @return tiles de aubenor
	 */
	public static Tile[] getAubenor() {
		return aubenor;
	}

	/**
	 * 
	 * @return tiles de aris
	 */
	public static Tile[] getAris() {
		return aris;
	}

	/**
	 * 
	 * @return la base de aris
	 */
	public static int getArisBase() {
		return arisBase;
	}

	/**
	 * 
	 * @return la base de aubenor
	 */
	public static int getAubenorBase() {
		return aubenorBase;
	}

	/**
	 * Establecer nuevos tiles
	 * 
	 * @param tiles
	 */
	public static void setTiles(Tile[] tiles) {
		Tile.tiles = tiles;
	}

	/**
	 * 
	 * @param aubenor
	 */
	public static void setAubenor(final Tile[] aubenor) {
		Tile.aubenor = aubenor;
	}
	
	/**
	 * Cambiar un Tile segun indice 
	 * @param index
	 * @param tile
	 */
    public static void setAubenor(final int index, final Tile tile){
    	Tile.aubenor[index] = tile;
    }
	/**
	 * 
	 * @param aris
	 */
	public static void setAris( final Tile[] aris) {
		Tile.aris = aris;
	}
	
	/**
	 * Cambiar un Tile segun indice 
	 * @param index
	 * @param tile
	 */
    public static void setAris( final int index, final Tile tile){
    	Tile.aris[index] = tile;
    }

}
