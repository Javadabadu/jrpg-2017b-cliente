package mundo;
/**
 * @author Javadabadu
 */
public class Nodo {

	private int x;
	private int y;
	private int indice;
	private int cantidadDeAdyacentes;
	private Nodo [] nodosAdyacentes;
	private static int tamañoNodosAdyacentes = 8;
	/**
	 * Constructor parametrizado
	 */
	public Nodo(final int indice, final int x, final int y) {
		this.x = x;
		this.y = y;
		this.indice = indice;
		cantidadDeAdyacentes = 0;
		nodosAdyacentes = new Nodo[tamañoNodosAdyacentes];
	}
	/**
	 * obtiene x
	 */
	public int obtenerX() {
		return x;
	}
	/**
	 * obtiene y
	 */
	public int obtenerY() {
		return y;
	}
	/**
	 * obtiene el indice
	 */
	public int obtenerIndice() {
		return indice;
	}
	/**
	 * obtiene los nodos adyacentes
	 */
	public Nodo [] obtenerNodosAdyacentes() {
		return nodosAdyacentes;
	}
	/**
	 * agrega un nodo adyacente
	 */
	public void agregarAdyacente(final Nodo nodo) {
		nodosAdyacentes[cantidadDeAdyacentes++] = nodo;
	}
	/**
	 * obtiene la cantidad de adyacentes
	 */
	public int obtenerCantidadDeAdyacentes() {
		return cantidadDeAdyacentes;
	}
}
