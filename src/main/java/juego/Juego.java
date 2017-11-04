package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.MiChat;
import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoBatallaNPC;
import estados.EstadoJuego;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaqueteNpc;
import mensajeria.PaquetePersonaje;
/**
 * @author Javadabadu
 */
public class Juego implements Runnable {

	private Pantalla pantalla;
	private final String nombre;
	private final int ancho;
	private final int alto;
	private static int direccionInicial = 6;
	private static int strategyInicial = 3;
	private static int fontStyle = 1;
	private static int fontSize = 15;
	private static int actsDeseadas = 60;
	private static double nanos = 1000000000;

	private Thread hilo;
	private boolean corriendo;
	// Estrategia para graficar mediante buffers 
	//(Primero se "grafica" en el/los buffer/s y finalmente en el canvas)
	private BufferStrategy bs; 
	private Graphics g;

	// Estados
	private Estado estadoJuego;
	private Estado estadoBatalla;

	// HandlerMouse
	private HandlerMouse handlerMouse;

	// Camara
	private Camara camara;

	// Conexion
	private Cliente cliente;
	private EscuchaMensajes escuchaMensajes;
	private PaquetePersonaje paquetePersonaje;
	private PaqueteMovimiento ubicacionPersonaje;
	private Map<Integer, PaquetePersonaje> personajesConectados;
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<String, MiChat> chatsActivos = new HashMap<>();

	private Map<Integer, PaqueteNpc> npcs;

	private CargarRecursos cargarRecursos;
	/**
	 * Constructor parametrizado
	 */
	public Juego(final String nombre, final int ancho, final int alto, final Cliente cliente, final PaquetePersonaje pp) {
		this.nombre = nombre;
		this.alto = alto;
		this.ancho = ancho;
		this.cliente = cliente;
		this.paquetePersonaje = pp;

		// Inicializo la ubicacion del personaje
		ubicacionPersonaje = new PaqueteMovimiento();
		ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
		ubicacionPersonaje.setFrame(0);
		ubicacionPersonaje.setDireccion(direccionInicial);

		// Creo el escucha de mensajes
		escuchaMensajes = new EscuchaMensajes(this);
		escuchaMensajes.start();

		handlerMouse = new HandlerMouse();

		iniciar();

		cargarRecursos = new CargarRecursos(cliente);
		cargarRecursos.start();
	}
	/**
	 * Carga lo necesario para iniciar el juego
	 */
	public void iniciar() {
				
		pantalla = new Pantalla(nombre, ancho, alto, cliente);

		pantalla.getCanvas().addMouseListener(handlerMouse);

		camara = new Camara(this, 0, 0);

		Personaje.cargarTablaNivel();
		
	}
	/**
	 * Actualiza los objetos y sus posiciones
	 */
	private void actualizar() {

		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}
	/**
	 * Grafica los objetos y sus posiciones
	 */
	private void graficar() {  
		bs = pantalla.getCanvas().getBufferStrategy();
		if (bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
			pantalla.getCanvas().createBufferStrategy(strategyInicial);
			return;
		}

		g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

		g.clearRect(0, 0, ancho, alto); // Limpiamos la pantalla

		// Graficado de imagenes
		g.setFont(new Font("Book Antiqua", fontStyle, fontSize));

		if (Estado.getEstado() != null) {
			Estado.getEstado().graficar(g);
		}

		// Fin de graficado de imagenes

		bs.show(); // Hace visible el pr�ximo buffer disponible
		g.dispose();
	}

	@Override
	public void run() { // Hilo principal del juego

		int fps = actsDeseadas; // Cantidad de actualizaciones por segundo que se desean
		double tiempoPorActualizacion = nanos / fps; // Cantidad de nanosegundos en FPS deseados
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; // Timer para mostrar fps cada un segundo
		int actualizaciones = 0; // Cantidad de actualizaciones que se realizan realmente

		while (corriendo) {
			ahora = System.nanoTime();
			// Calculo  para determinar cuando realizar la actualizacion y el graficado
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion;
			// Sumo el tiempo transcurrido hasta que se acumule 1 segundo y mostrar los FPS
			timer += ahora - ultimoTiempo;
			ultimoTiempo = ahora;// Para las proximas corridas del bucle

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}

			if (timer >= nanos) { // Si paso 1 segundo muestro los FPS
				pantalla.getFrame().setTitle(nombre + " | " + "FPS: " + actualizaciones);
				actualizaciones = 0;
				timer = 0;
			}
		}

		stop();
	}
	/**
	 * inicia el juego
	 */
	public synchronized void start() {
		if (corriendo) {
			return;
		}
		estadoJuego = new EstadoJuego(this);
		Estado.setEstado(estadoJuego);
		pantalla.mostrar();
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
	}
	/**
	 * Detiene el juego
	 */
	public synchronized void stop() {
		if (!corriendo) {
			return;
		}
		try {
			corriendo = false;
			hilo.join();
		} catch (final InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Fallo al intentar detener el juego.");
		}
	}
	/**
	 * obtiene el ancho
	 */
	public int getAncho() {
		return ancho;
	}
	/**
	 * obtiene el alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * obtiene el handlerMouse
	 */
	public HandlerMouse getHandlerMouse() {
		return handlerMouse;
	}
	/**
	 * obtiene la camara
	 */
	public Camara getCamara() {
		return camara;
	}
	/**
	 * obtiene el estadoJuego
	 */
	public EstadoJuego getEstadoJuego() {
		return (EstadoJuego) estadoJuego;
	}
	/**
	 * obtiene el estadoBatalla
	 */
	public EstadoBatalla getEstadoBatalla() {
		return (EstadoBatalla) estadoBatalla;
	}
	/**
	 * setea el estadoBatalla
	 */
	public void setEstadoBatalla(final EstadoBatalla estadoBatalla) {
		this.estadoBatalla = estadoBatalla;
	}
	/**
	 * obtiene el cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * obtiene el escuchaMensajes
	 */
	public EscuchaMensajes getEscuchaMensajes() {
		return escuchaMensajes;
	}
	/**
	 * obtiene el paquetePersonaje
	 */
	public PaquetePersonaje getPersonaje() {
		return paquetePersonaje;
	}
	/**
	 * obtiene la ubicacion del personaje
	 */
	public PaqueteMovimiento getUbicacionPersonaje() {
		return ubicacionPersonaje;
	}
	/**
	 * setea el personaje
	 */
	public void setPersonaje(final PaquetePersonaje paquetePersonaje) {
		this.paquetePersonaje = paquetePersonaje;
	}
	/**
	 * actualiza el personaje
	 */
	public void actualizarPersonaje() {
		paquetePersonaje = (PaquetePersonaje) (
				personajesConectados.get(paquetePersonaje.getId()).clone());
	}
	/**
	 * obtiene los personajes conectados
	 */
	public Map<Integer, PaquetePersonaje> getPersonajesConectados() {
		return personajesConectados;
	}
	/**
	 * setea los personajes conectados
	 */
	public void setPersonajesConectados(final Map<Integer, PaquetePersonaje> map) {
		this.personajesConectados = map;
	}
	/**
	 * obtiene la ubicacion de los personajes
	 */
	public Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
		return ubicacionPersonajes;
	}
	/**
	 * setea la ubicacion de los personajes
	 */
	public void setUbicacionPersonajes(final Map<Integer, PaqueteMovimiento> ubicacionPersonajes) {
		this.ubicacionPersonajes = ubicacionPersonajes;
	}
	/**
	 * obtiene los chats activos
	 */
	public Map<String, MiChat> getChatsActivos() {
		return chatsActivos;
	}
	/**
	 * obtiene los npcs
	 */
	public Map<Integer, PaqueteNpc> getNpcs() {
		return npcs;
	}
	/**
	 * setea los npcs
	 */
	public void setNpcs(final Map<Integer, PaqueteNpc> npcs) {
		this.npcs = npcs;
	}
	/**
	 * setea el estadoBatalla del npc
	 */
	public void setEstadoBatalla(final EstadoBatallaNPC estadoBatalla) {
		this.estadoBatalla = estadoBatalla;
	}
	/**
	 * obtiene el estadoBatalla del npc
	 */
	public EstadoBatallaNPC getEstadoBatallaNPC() {
		return (EstadoBatallaNPC) estadoBatalla;
	}
}



