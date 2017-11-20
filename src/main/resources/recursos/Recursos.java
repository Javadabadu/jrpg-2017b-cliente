package recursos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.imageio.ImageIO;
import frames.MenuCarga;
import frames.MenuMapas;
import mundo.Tile;

/**
 * Obtiene los recursos necesarios para la creacion
 * de personajes
 * @author progra avanzada
 *
 */
public class Recursos {

	private static final int ELEMENTOS = 65;
	private static final int ANCHOBARRA = 345;
	private static final int ANCHO = 256; // Ancho del frame a obtener
	private static final int ALTO = 256; // Alto del frame a obtener
	private static final int SPRITE_NUM = 4;
	private static final int ANCHO_TILE_TREE = 42; // Ancho del arbol.
	private static final int ALTO_TILE_TREE = 50;  // Ancho del arbol.
	private static final int TAM_VEC_TILE_MAP = 81; //Dimension del vector de Tiles que usa el mapa. 
	private static final int COEF_MAP_TILE = 64 ; // Coeficiente usado para la generacion de Tiles.
	private static final int COEF_MAP_ID = 10 ;
	private static final int CANT_TILE_X = 10;
	private static final int CANT_TILE_Y =8;
	/**
	 *  Hash de imagenes 
	 *  para los personajes (humano, ogro, elfo)
	 *  **/
	public static Map<String, LinkedList<BufferedImage[]>> personaje = new HashMap<>();

	/**
	 * Humano
	 */
	private static SpriteSheet spriteHumano;
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	private static BufferedImage[] humanoIzq;
	private static BufferedImage[] humanoArribaIzq;
	private static BufferedImage[] humanoArriba;
	private static BufferedImage[] humanoArribaDer;
	private static BufferedImage[] humanoDer;
	private static BufferedImage[] humanoAbajoDer;
	private static BufferedImage[] humanoAbajo;
	private static BufferedImage[] humanoAbajoIzq;

	/**
	 * Ogro
	 */
	private static SpriteSheet spriteOgro;
	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	private static BufferedImage[] orcoIzq;
	private static BufferedImage[] orcoArribaIzq;
	private static BufferedImage[] orcoArriba;
	private static BufferedImage[] orcoArribaDer;
	private static BufferedImage[] orcoDer;
	private static BufferedImage[] orcoAbajoDer;
	private static BufferedImage[] orcoAbajo;
	private static BufferedImage[] orcoAbajoIzq;

	/**
	 * Elfos
	 */
	private static SpriteSheet spriteElfo;
	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	private static BufferedImage[] elfoIzq;
	private static BufferedImage[] elfoArribaIzq;
	private static BufferedImage[] elfoArriba;
	private static BufferedImage[] elfoArribaDer;
	private static BufferedImage[] elfoDer;
	private static BufferedImage[] elfoAbajoDer;
	private static BufferedImage[] elfoAbajo;
	private static BufferedImage[] elfoAbajoIzq;
	
	/**
	 * NPC Lucaneitor
	 */
	private static SpriteSheet spriteLucaneitor;
	public static LinkedList<BufferedImage[]> lucaneitor = new LinkedList<>();
	private static BufferedImage[] lucaneitorIzq;
	private static BufferedImage[] lucaneitorArribaIzq;
	private static BufferedImage[] lucaneitorArriba;
	private static BufferedImage[] lucaneitorArribaDer;
	private static BufferedImage[] lucaneitorDer;
	private static BufferedImage[] lucaneitorAbajoDer;
	private static BufferedImage[] lucaneitorAbajo;
	private static BufferedImage[] lucaneitorAbajoIzq;
	
	/**
	 * NPC Leonidas
	 */
	private static SpriteSheet spriteLeonidas;
	public static LinkedList<BufferedImage[]> leonidas = new LinkedList<>();
	private static BufferedImage[] leonidasIzq;
	private static BufferedImage[] leonidasArribaIzq;
	private static BufferedImage[] leonidasArriba;
	private static BufferedImage[] leonidasArribaDer;
	private static BufferedImage[] leonidasDer;
	private static BufferedImage[] leonidasAbajoDer;
	private static BufferedImage[] leonidasAbajo;
	private static BufferedImage[] leonidasAbajoIzq;
	
	/**
	 * Entorno
	 */
	private static SpriteSheet trees;
	private static BufferedImage cesped;
	private static BufferedImage roca;
	private static BufferedImage background;
	private static BufferedImage marco;
	private static BufferedImage botonMenu;
	private static BufferedImage menuEnemigo;
	private static BufferedImage greenTree;
	private static BufferedImage nievePiso1;
	private static BufferedImage iceBlock;
	
	/**
	 * Batalla
	 */
	private static BufferedImage barraSpells;
	public static BufferedImage estadoPersonaje;
	public static BufferedImage barraSalud;
	private static BufferedImage barraEnergia;
	private static BufferedImage barraExperiencia;
	private static BufferedImage menuBatalla;
	private static BufferedImage menuBatallaDeshabilitado;
	private static BufferedImage noItem;
	private static BufferedImage mochila;
	private static BufferedImage menu;
	private static BufferedImage chat;
	private static Map<String, BufferedImage> habilidades = new HashMap<>();
	
	/**
	 * Se cargan todos los recursos del juego una sola vez al inicio
	 * @param menuCarga
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public static void cargar(MenuCarga menuCarga) throws NumberFormatException, IOException {
		
		int elementosCargados = 0;
		int coeficienteAltura = 1;
		noItem = ImageIO.read(new File("recursos//noItem.png"));
		mochila = ImageIO.read(new File("recursos//mochila.png"));
		menu = ImageIO.read(new File("recursos//menu.png"));
		chat = ImageIO.read(new File("recursos//chat.png"));
		spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));	
		actualizarBarraDeCarga(++elementosCargados, menuCarga);	
		humanoIzq = new BufferedImage[SPRITE_NUM];
		humanoArribaIzq = new BufferedImage[SPRITE_NUM];
		humanoArriba = new BufferedImage[SPRITE_NUM];
		humanoArribaDer = new BufferedImage[SPRITE_NUM];
		humanoDer = new BufferedImage[SPRITE_NUM];
		humanoAbajoDer = new BufferedImage[SPRITE_NUM];
		humanoAbajo = new BufferedImage[SPRITE_NUM];
		humanoAbajoIzq = new BufferedImage[SPRITE_NUM];

		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoIzq[i] = spriteHumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoArribaIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO*coeficienteAltura, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoArriba[i] = spriteHumano.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i <SPRITE_NUM; i++) {
			humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO *coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		humano.add(humanoIzq);
		humano.add(humanoArribaIzq);
		humano.add(humanoArriba);
		humano.add(humanoArribaDer);
		humano.add(humanoDer);
		humano.add(humanoAbajoDer);
		humano.add(humanoAbajo);
		humano.add(humanoAbajoIzq);
		// Fin humano

		// Inicio Ogro
		spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		orcoIzq = new BufferedImage[SPRITE_NUM];
		orcoArribaIzq = new BufferedImage[SPRITE_NUM];
		orcoArriba = new BufferedImage[SPRITE_NUM];
		orcoArribaDer = new BufferedImage[SPRITE_NUM];
		orcoDer = new BufferedImage[SPRITE_NUM];
		orcoAbajoDer = new BufferedImage[SPRITE_NUM];
		orcoAbajo = new BufferedImage[SPRITE_NUM];
		orcoAbajoIzq = new BufferedImage[SPRITE_NUM];

		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoIzq[i] = spriteOgro.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura = 1;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoArribaIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoArriba[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoArribaDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoAbajoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoAbajo[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		orco.add(orcoIzq);
		orco.add(orcoArribaIzq);
		orco.add(orcoArriba);
		orco.add(orcoArribaDer);
		orco.add(orcoDer);
		orco.add(orcoAbajoDer);
		orco.add(orcoAbajo);
		orco.add(orcoAbajoIzq);

		// Fin Ogro

		// Inicio Elfo
		spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo2.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		elfoIzq = new BufferedImage[SPRITE_NUM];
		elfoArribaIzq = new BufferedImage[SPRITE_NUM];
		elfoArriba = new BufferedImage[SPRITE_NUM];
		elfoArribaDer = new BufferedImage[SPRITE_NUM];
		elfoDer = new BufferedImage[SPRITE_NUM];
		elfoAbajoDer = new BufferedImage[SPRITE_NUM];
		elfoAbajo = new BufferedImage[SPRITE_NUM];
		elfoAbajoIzq = new BufferedImage[SPRITE_NUM];

		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura = 1;
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO*coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);

		// Fin Elfo
		
		//INICIO NPC
		
		spriteLucaneitor = new SpriteSheet(CargadorImagen.cargarImagen("/Lucas.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		lucaneitorIzq = new BufferedImage[SPRITE_NUM];
		lucaneitorArribaIzq = new BufferedImage[SPRITE_NUM];
		lucaneitorArriba = new BufferedImage[SPRITE_NUM];
		lucaneitorArribaDer = new BufferedImage[SPRITE_NUM];
		lucaneitorDer = new BufferedImage[SPRITE_NUM];
		lucaneitorAbajoDer = new BufferedImage[SPRITE_NUM];
		lucaneitorAbajo = new BufferedImage[SPRITE_NUM];
		lucaneitorAbajoIzq = new BufferedImage[SPRITE_NUM];

		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorIzq[i] = spriteLucaneitor.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura = 1;
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorArribaIzq[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO*coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorArriba[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorArribaDer[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura ++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorDer[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorAbajoDer[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorAbajo[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			lucaneitorAbajoIzq[i] = spriteLucaneitor.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		lucaneitor.add(lucaneitorIzq);
		lucaneitor.add(lucaneitorArribaIzq);
		lucaneitor.add(lucaneitorArriba);
		lucaneitor.add(lucaneitorArribaDer);
		lucaneitor.add(lucaneitorDer);
		lucaneitor.add(lucaneitorAbajoDer);
		lucaneitor.add(lucaneitorAbajo);
		lucaneitor.add(lucaneitorAbajoIzq);

		
		spriteLeonidas = new SpriteSheet(CargadorImagen.cargarImagen("/Leo.png"));

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		leonidasIzq = new BufferedImage[SPRITE_NUM];
		leonidasArribaIzq = new BufferedImage[SPRITE_NUM];
		leonidasArriba = new BufferedImage[SPRITE_NUM];
		leonidasArribaDer = new BufferedImage[SPRITE_NUM];
		leonidasDer = new BufferedImage[SPRITE_NUM];
		leonidasAbajoDer = new BufferedImage[SPRITE_NUM];
		leonidasAbajo = new BufferedImage[SPRITE_NUM];
		leonidasAbajoIzq = new BufferedImage[SPRITE_NUM];

		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasIzq[i] = spriteLeonidas.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura = 1;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasArribaIzq[i] = spriteLeonidas.getTile(ANCHO * i, ALTO*coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasArriba[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasArribaDer[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasDer[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasAbajoDer[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura ++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasAbajo[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		coeficienteAltura++;
		
		for (int i = 0; i < SPRITE_NUM; i++) {
			leonidasAbajoIzq[i] = spriteLeonidas.getTile(ANCHO * i, ALTO * coeficienteAltura, ANCHO, ALTO);
		}

		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		leonidas.add(leonidasIzq);
		leonidas.add(leonidasArribaIzq);
		leonidas.add(leonidasArriba);
		leonidas.add(leonidasArribaDer);
		leonidas.add(leonidasDer);
		leonidas.add(leonidasAbajoDer);
		leonidas.add(leonidasAbajo);
		leonidas.add(leonidasAbajoIzq);
		//FIN NPC
				
		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);
		personaje.put("Lucaneitor", lucaneitor);
		personaje.put("Leonidas", leonidas);

		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		roca = CargadorImagen.cargarImagen("/rock.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		background = CargadorImagen.cargarImagen("/background.jpg");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		marco = CargadorImagen.cargarImagen("/marco.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		menuEnemigo = CargadorImagen.cargarImagen("/MenuEnemigo.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));  
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		greenTree = trees.getTile(0, 0, ANCHO_TILE_TREE, ALTO_TILE_TREE);
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		nievePiso1 = CargadorImagen.cargarImagen("/nieve piso.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		iceBlock = CargadorImagen.cargarImagen("/nieve cubo.png");
		
		
		// Mapa
		if (MenuMapas.numberMap == 1) {
			SpriteSheet mapaAubenor = new SpriteSheet(CargadorImagen.cargarImagen("/Aubenor.png"));
			Tile.setAubenor(new Tile[TAM_VEC_TILE_MAP]);
			boolean [][] solidezAubenor = {{true, true, false, true, false, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, false, false, false, false , false, false ,false, true, true},
					{false, false, false, false, false , false, false ,false, true, true},
					{false, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true}};		
			for(int y = 0 ; y < 8 ; y++){
				for(int x = 0; x < 10 ; x++){
					Tile.setAubenor(y * COEF_MAP_ID + x + 1, 
							new Tile(mapaAubenor.getTile(x * COEF_MAP_TILE, y * COEF_MAP_TILE, COEF_MAP_TILE, COEF_MAP_TILE),
									y * COEF_MAP_ID + x + 1, solidezAubenor[y][x], COEF_MAP_TILE, COEF_MAP_TILE));
				}
			}
		} else {
			SpriteSheet mapaAris = new SpriteSheet(CargadorImagen.cargarImagen("/Aris.png"));
			Tile.setAris(new Tile[TAM_VEC_TILE_MAP]);
			boolean [][] solidezAris = {{true, false, false, false, false, false, false, true, true, true},
					{false, false, false, false, false, false, false, false, true, true},
					{false, false, false, false, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{false, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true}};
			for (int y = 0 ; y < CANT_TILE_Y ; y++) {
				for (int x = 0; x < CANT_TILE_X ; x++) {
					Tile.setAris(y * COEF_MAP_ID + x + 1,
							new Tile(mapaAris.getTile(x * COEF_MAP_TILE, y * COEF_MAP_TILE, COEF_MAP_TILE, COEF_MAP_TILE),
									y * COEF_MAP_ID + x + 1, solidezAris[y][x], COEF_MAP_TILE, COEF_MAP_TILE));
				}
			}
		}
		
		// Fin Entorno

		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraEnergia = CargadorImagen.cargarImagen("/BarraDeEnergia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraExperiencia = CargadorImagen.cargarImagen("/BarraDeExperiencia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Level", CargadorImagen.cargarImagen("/Golpe Level.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ataque Bosque", CargadorImagen.cargarImagen("/Ataque Bosque.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Defensa", CargadorImagen.cargarImagen("/Golpe Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Mordisco de Vida", CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Incentivar", CargadorImagen.cargarImagen("/Incentivar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Fatal", CargadorImagen.cargarImagen("/Golpe Fatal.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ataque Doble", CargadorImagen.cargarImagen("/Ataque Doble.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Aumentar Defensa", CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ignorar Defensa", CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Bola de Fuego", CargadorImagen.cargarImagen("/Bola de Fuego.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Curar Aliado", CargadorImagen.cargarImagen("/Curar Aliado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Robar Energia y Salud", CargadorImagen.cargarImagen("/Robar Energia y Salud.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Golpe Critico", CargadorImagen.cargarImagen("/Golpe Critico.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Aumentar Evasion", CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		habilidades.put("Ser Energizado", CargadorImagen.cargarImagen("/Ser Energizado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		menuBatalla = CargadorImagen.cargarImagen("/MenuBatalla.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		
		menuBatallaDeshabilitado = CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// Fin Batalla
	}
	
	/**
	 * 
	 * @param elementosCargados
	 * @param menuCarga
	 */
	private static void actualizarBarraDeCarga(int elementosCargados, MenuCarga menuCarga) {
		menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
	}
	
	/**
	 * 
	 * @return
	 */
	public static BufferedImage getCesped() {
		return cesped;
	}

	/**
	 * 
	 * @param cesped
	 */
	public static void setCesped(BufferedImage cesped) {
		Recursos.cesped = cesped;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getRoca() {
		return roca;
	}

	/**
	 * 
	 * @param roca
	 */
	public static void setRoca(final BufferedImage roca) {
		Recursos.roca = roca;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBackground() {
		return background;
	}

	/**
	 * 
	 * @param background
	 */
	public static void setBackground(final BufferedImage background) {
		Recursos.background = background;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMarco() {
		return marco;
	}

	/**
	 * 
	 * @param marco
	 */
	public static void setMarco(final BufferedImage marco) {
		Recursos.marco = marco;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBotonMenu() {
		return botonMenu;
	}

	/**
	 * 
	 * @param botonMenu
	 */
	public static void setBotonMenu(final BufferedImage botonMenu) {
		Recursos.botonMenu = botonMenu;
	}
	
	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMenuEnemigo() {
		return menuEnemigo;
	}

	/**
	 * 
	 * @param menuEnemigo
	 */
	public static void setMenuEnemigo(final BufferedImage menuEnemigo) {
		Recursos.menuEnemigo = menuEnemigo;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getGreenTree() {
		return greenTree;
	}

	/**
	 * 
	 * @param greenTree
	 */
	public static void setGreenTree(final BufferedImage greenTree) {
		Recursos.greenTree = greenTree;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getNievePiso1() {
		return nievePiso1;
	}

	/**
	 * 
	 * @param nievePiso1
	 */
	public static void setNievePiso1(BufferedImage nievePiso1) {
		Recursos.nievePiso1 = nievePiso1;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getIceBlock() {
		return iceBlock;
	}

	/**
	 * 
	 * @param iceBlock
	 */
	public static void setIceBlock(final BufferedImage iceBlock) {
		Recursos.iceBlock = iceBlock;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBarraSalud() {
		return barraSalud;
	}

	/**
	 * 
	 * @param barraSalud
	 */
	public static void setBarraSalud(final BufferedImage barraSalud) {
		Recursos.barraSalud = barraSalud;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBarraSpells() {
		return barraSpells;
	}

	/**
	 * 
	 * @param barraSpells
	 */
	public static void setBarraSpells(BufferedImage barraSpells) {
		Recursos.barraSpells = barraSpells;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getEstadoPersonaje() {
		return estadoPersonaje;
	}

	/**
	 * 
	 * @param estadoPersonaje
	 */
	public static void setEstadoPersonaje(BufferedImage estadoPersonaje) {
		Recursos.estadoPersonaje = estadoPersonaje;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBarraEnergia() {
		return barraEnergia;
	}

	/**
	 * 
	 * @param barraEnergia
	 */
	public static void setBarraEnergia(BufferedImage barraEnergia) {
		Recursos.barraEnergia = barraEnergia;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getBarraExperiencia() {
		return barraExperiencia;
	}

	/**
	 * 
	 * @param barraExperiencia
	 */
	public static void setBarraExperiencia(BufferedImage barraExperiencia) {
		Recursos.barraExperiencia = barraExperiencia;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMenuBatalla() {
		return menuBatalla;
	}

	/**
	 * 
	 * @param menuBatalla
	 */
	public static void setMenuBatalla(BufferedImage menuBatalla) {
		Recursos.menuBatalla = menuBatalla;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMenuBatallaDeshabilitado() {
		return menuBatallaDeshabilitado;
	}

	/**
	 * 
	 * @param menuBatallaDeshabilitado
	 */
	public static void setMenuBatallaDeshabilitado(BufferedImage menuBatallaDeshabilitado) {
		Recursos.menuBatallaDeshabilitado = menuBatallaDeshabilitado;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getNoItem() {
		return noItem;
	}

	/**
	 * 
	 * @param noItem
	 */
	public static void setNoItem(BufferedImage noItem) {
		Recursos.noItem = noItem;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMochila() {
		return mochila;
	}

	/**
	 * 
	 * @param mochila
	 */
	public static void setMochila(BufferedImage mochila) {
		Recursos.mochila = mochila;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getMenu() {
		return menu;
	}

	/**
	 * 
	 * @param menu
	 */
	public static void setMenu(BufferedImage menu) {
		Recursos.menu = menu;
	}

	/**
	 * 
	 * @return
	 */
	public static BufferedImage getChat() {
		return chat;
	}

	/**
	 * 
	 * @param chat
	 */
	public static void setChat(BufferedImage chat) {
		Recursos.chat = chat;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, BufferedImage> getHabilidades() {
		return habilidades;
	}

	/**
	 * 
	 * @param habilidades
	 */
	public static void setHabilidades(Map<String, BufferedImage> habilidades) {
		Recursos.habilidades = habilidades;
	}
	
	
	
}