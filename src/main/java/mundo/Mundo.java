package mundo;

import java.awt.Graphics;

import estados.Estado;
import juego.Juego;

/**
 * Class Mundo .
 * 
 * @author Progra Avanzada
 *
 */
public class Mundo {
	private static final int OFFSET_X = 30;
	private static final int OFFSET_Y = 60;
	private static final int G_DESP_Y = 32;
	private static final int G_ANC_ALT = 64;
	private static final int ARIS_MAP = 2;
	private static final int AUB_MAP = 1;
	private static final int EOD_MAP = 3;
	private static final int TILE_DESP = 4;
	private Juego juego;
	private int ancho;
	private int alto;

	private int xOffset;
	private int yOffset;

	private float[] iso = new float[2];
	private int[][] tiles;
	private int[][] tilesInv;

	private int xMinimo;
	private int xMaximo;
	private int yMinimo;
	private int yMaximo;

	private Grafo grafoDeTilesNoSolidos;
	private int spawnX; 
	private int spawnY;

	/**
	 * Constructor de Mundo
	 * 
	 * @param juego
	 * @param pathMap
	 * @param pathObstac
	 */
	public Mundo(Juego juego, final String pathMap, final String pathObstac) {
		this.juego = juego;
		cargarMundo(pathMap, pathObstac);
		mundoAGrafo();
	}

	public void actualizar() {

	}

	/**
	 * Metodo para graficar el mundo.
	 * 
	 * @param g
	 */
	public void graficar(final Graphics g) {
		xOffset = juego.getEstadoJuego().getPersonaje().getxOffset();
		yOffset = juego.getEstadoJuego().getPersonaje().getYOffset();

		xMinimo = (int) (juego.getCamara().getxOffset() - xOffset - OFFSET_X);
		xMaximo = xMinimo + juego.getAncho() + xOffset + OFFSET_X;
		yMinimo = (int) juego.getCamara().getyOffset() + yOffset - OFFSET_Y;
		yMaximo = yMinimo + juego.getAlto() + yOffset + OFFSET_Y;

		// Grafico el el tile base
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				iso = dosDaIso(j, i);
				if ((iso[0] >= xMinimo && iso[0] <= xMaximo) && (iso[1] >= yMinimo && iso[1] <= yMaximo)) {
					// Obtengo el mapa
					int map = juego.getPersonaje().getMapa();
					if (map == ARIS_MAP) {
						Tile.getAris()[Tile.getArisBase()].graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
								(int) (iso[1] - juego.getCamara().getyOffset() - G_DESP_Y), G_ANC_ALT, G_ANC_ALT);
					} else if(map == AUB_MAP || map == EOD_MAP) {
						Tile.getAubenor()[Tile.getAubenorBase()].graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
								(int) (iso[1] - juego.getCamara().getyOffset() - G_DESP_Y), G_ANC_ALT, G_ANC_ALT);
					}

					if (!getTile(j, i).esSolido()) {
						getTile(j, i).graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
								(int) (iso[1] - juego.getCamara().getyOffset() - G_DESP_Y), G_ANC_ALT, G_ANC_ALT);
					}

				}
			}
		} // fin del for
	}

	public void graficarObstaculos(final Graphics g) {
		Tile obst;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				iso = dosDaIso(j, i);
				// Grafico al personaje
				if (Estado.getEstado() == juego.getEstadoJuego()) {
					if (Mundo.mouseATile(juego.getUbicacionPersonaje().getPosX(),
						juego.getUbicacionPersonaje().getPosY())[0] == j
						&& Mundo.mouseATile(juego.getUbicacionPersonaje().getPosX(),
						juego.getUbicacionPersonaje().getPosY())[1] == i) {
						juego.getEstadoJuego().getPersonaje().graficar(g);
					}
						
				}

				// Grafico los obstaculos
				if ((iso[0] >= xMinimo && iso[0] <= xMaximo) && (iso[1] >= yMinimo && iso[1] <= yMaximo)
						&& getTile(j, i).esSolido()) {
					obst = getTile(j, i);
					obst.graficar(g, (int) (iso[0] - juego.getCamara().getxOffset()),
					(int) (iso[1] - juego.getCamara().getyOffset() - obst.getAlto() / 2),
					obst.getAncho(), obst.getAlto());
				}
			}
		}
	}

	public Tile getTile(final int x,final int y) {
		Tile t = Tile.getTiles()[tiles[x][y]];
		if (t == null) {
			int map = juego.getPersonaje().getMapa();
			if (map == ARIS_MAP) {
				return Tile.getAris()[Tile.getArisBase()];
			} else if (map == AUB_MAP || map == EOD_MAP) {
				return Tile.getAubenor()[Tile.getAubenorBase()];		
			}
		}
		return t;
	}

	private void cargarMundo(final String pathMapa, final String pathObstaculos) {
		String archivo = Utilitarias.archivoAString(pathMapa);
		String[] tokens = archivo.split("\\s+");
		ancho = Utilitarias.parseInt(tokens[0]);
		alto = Utilitarias.parseInt(tokens[1]);
		spawnX = Utilitarias.parseInt(tokens[2]);
		spawnY = Utilitarias.parseInt(tokens[3]);

		tiles = new int[ancho][alto];
		tilesInv = new int[alto][ancho];

		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				tiles[x][y] = Utilitarias.parseInt(tokens[(x + y * ancho + TILE_DESP)]);
				tilesInv[y][x] = tiles[x][y];
			}
		}

	}
/**
 * Metodo que pasa el mundo a un modelo de gragos.
 */
	private void mundoAGrafo() {
		// Creo una matriz de nodos
		Nodo[][] nodos = new Nodo[ancho][alto];
		int indice = 0;
		// Lleno la matriz con los nodos
		for (int y = 0; y < alto; y++){
			for (int x = 0; x < ancho; x++){
				nodos[y][x] = new Nodo(indice++, x, y);
			}
				
		}
			
		// Variables finales
		int xFinal = ancho;
		int yFinal = alto;
		// Uno cada nodo con sus adyacentes
		for (int x = 0; x < yFinal; x++) {
			for (int y = 0; y < xFinal; y++) {
				if (!Tile.getTiles()[tilesInv[x][y]].esSolido()) {
					// Si no es la ultima fila y el tile de abajo es no solido,
					// lo uno
					if (y < yFinal - 1 && !Tile.getTiles()[tilesInv[x][y + 1]].esSolido()) {
						nodos[x][y].agregarAdyacente(nodos[x][y + 1]);
						nodos[x][y + 1].agregarAdyacente(nodos[x][y]);
					}
					// Si no es la ultima columna
					if (x < xFinal - 1) {
						/* Si el de arriba a la derecha no es un tile solido
						 Y ademas el de arriba ni el de la derecha lo son, lo
						 unoTiene que ser a partir de la segunda fila
						*/ 
						if (y > 0 && !Tile.getTiles()[tilesInv[x + 1][y - 1]].esSolido()
								&& !Tile.getTiles()[tilesInv[x + 1][y]].esSolido()
								&& !Tile.getTiles()[tilesInv[x][y - 1]].esSolido()) {
							nodos[x][y].agregarAdyacente(nodos[x + 1][y - 1]);
							nodos[x + 1][y - 1].agregarAdyacente(nodos[x][y]);
						}
						// Si el de la derecha no es un tile solido lo uno
						if (!Tile.getTiles()[tilesInv[x + 1][y]].esSolido()) {
							nodos[x][y].agregarAdyacente(nodos[x + 1][y]);
							nodos[x + 1][y].agregarAdyacente(nodos[x][y]);
						}
						// Si el de abajo a la derecha no es un tile solido
						// Y ademas el de abajo ni el de la derecha lo son, lo
						// uno
						// Debe ser antes de la ultima fila
						if (y < yFinal - 1 && !Tile.getTiles()[tilesInv[x + 1][y + 1]].esSolido()
								&& !Tile.getTiles()[tilesInv[x + 1][y]].esSolido()
								&& !Tile.getTiles()[tilesInv[x][y + 1]].esSolido()) {
							nodos[x][y].agregarAdyacente(nodos[x + 1][y + 1]);
							nodos[x + 1][y + 1].agregarAdyacente(nodos[x][y]);
						}
					}
				}
			}
		}
		// Creo un grafo para almacenar solo los tiles no solidos
		grafoDeTilesNoSolidos = new Grafo(ancho * alto);
		indice = 0;
		// Paso la matriz a un array
		for (int i = 0; i < ancho; i++)
			for (int j = 0; j < alto; j++)
				grafoDeTilesNoSolidos.agregarNodo(nodos[i][j]);
	}

	public Grafo obtenerGrafoDeTilesNoSolidos() {
		return grafoDeTilesNoSolidos;
	}

	public int obtenerAncho() {
		return ancho;
	}

	public int obtenerAlto() {
		return alto;
	}

	public static float[] isoA2D(float x, float y) {
		float[] dosD = new float[2];

		dosD[0] = (x / (Tile.ANCHO / 2) + y / (Tile.ALTO / 2)) / 2;
		dosD[1] = (y / (Tile.ALTO / 2) - (x / (Tile.ANCHO / 2))) / 2;

		return dosD;
	}

	public static float[] dosDaIso(float x, float y) {
		float[] iso = new float[2];

		iso[0] = (x - y) * (Tile.ANCHO / 2);
		iso[1] = (x + y) * (Tile.ALTO / 2);

		return iso;
	}

	public static int[] mouseATile(float x, float y) {
		int tile[] = new int[2];

		tile[0] = (int) Math.floor((y / Tile.ALTO) + (x / Tile.ANCHO)) + 1;
		tile[1] = (int) Math.floor((-x / Tile.ANCHO) + (y / Tile.ALTO)) + 1;

		return tile;
	}
}