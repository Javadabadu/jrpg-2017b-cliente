package mundo;
/**
 * @author Javadabadu
 */
public class Grafo {

	private int cantidadDeNodos;
	private int cantidadDeNodosTotal;
	private Nodo [] nodos;
	/**
	 * Constructor
	 */
	public Grafo(final int cantidadDeNodosTotal) {
		cantidadDeNodos = 0;
		nodos = new Nodo[cantidadDeNodosTotal];
		this.cantidadDeNodosTotal = cantidadDeNodosTotal;
	}
	/**
	 * agrega un nodo
	 */
	public void agregarNodo(final Nodo nodo) {
		nodos [cantidadDeNodos++] = nodo;
	}
	/**
	 * agrega nodos adyacentes
	 */
	public void agregarAdyacentes(final Nodo nodoUno,final Nodo nodoDos){
		nodoUno.agregarAdyacente(nodoDos);
	}
	/**
	 * obtiene los nodos
	 */
	public Nodo [] obtenerNodos() {
		return nodos;
	}
	/**
	 * obtiene la cantidad de nodos
	 */
	public int obtenerCantidadDeNodos() {
		return cantidadDeNodos;
	}
	/**
	 * obtiene la cantidad total de nodos
	 */
	public int obtenerCantidadDeNodosTotal() {
		return cantidadDeNodosTotal;
	}
}
