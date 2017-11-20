package cliente;

import com.google.gson.Gson;

import comandos.ComandosCliente;

import frames.MenuCarga;
import frames.MenuComerciar;
import frames.MenuJugar;
import frames.MenuMapas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.Properties;

import javax.swing.JOptionPane;

import juego.Juego;

import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteMensaje;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

/**
 * La clase Cliente tiene como función ejecutar el cliente.
 * 
 * @author Progra Avanzada
 */

public class Cliente extends Thread {

	private static final int ANCHO_JUEGO = 800;
	private static final int ALTO_JUEGO = 600;
	private final Gson gson = new Gson();
	private final int puerto = obtenerPuerto();
	private Socket cliente;
	private String miIp;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private PaqueteUsuario paqueteUsuario;
	private PaquetePersonaje paquetePersonaje;
	private PaqueteComerciar paqueteComercio;
	private PaqueteMensaje paqueteMensaje = new PaqueteMensaje();
	// Acciones que realiza el usuario
	private int accion;
	// MENU COMERCIAR
	private MenuComerciar m1;
	private String ip;

	/**
	 * @return Devuelve la accion
	 */
	public int getAccion() {
		return accion;
	}

	/**
	 * @param Setea
	 *            la accion a realizar
	 */
	public void setAccion(final int accion) {
		this.accion = accion;
	}

	private Juego wome;
	private MenuCarga menuCarga;

	/**
	 * Constructor del Cliente
	 */
	public Cliente() {

		ip = JOptionPane.showInputDialog("Ingrese IP del servidor: (default localhost)");
		if (ip == null)
			ip = "localhost";

		try {
			cliente = new Socket(ip, puerto);
			miIp = cliente.getInetAddress().getHostAddress();
			entrada = new ObjectInputStream(cliente.getInputStream());
			salida = new ObjectOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Fallo al iniciar la aplicación. " + "Revise la conexión con el servidor.");
			System.exit(1);
		}
	}

	public Cliente(String ip, int puerto) {
		try {
			cliente = new Socket(ip, puerto);
			miIp = cliente.getInetAddress().getHostAddress();
			entrada = new ObjectInputStream(cliente.getInputStream());
			salida = new ObjectOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Fallo al iniciar la aplicación. " + "Revise la conexión con el servidor.");
			System.exit(1);
		}
	}

	/**
	 * Metodo privado que permite obtener el puerto a partir de un archivo
	 * property
	 * 
	 * @return el numero de puerto
	 */
	private int obtenerPuerto() {
		String puertoArchivo = null;
		try {
			Properties prop = new Properties();
			FileInputStream archivoPuerto = new FileInputStream("puerto.properties");
			prop.load(archivoPuerto);
			puertoArchivo = prop.getProperty("puerto");

		} catch (IOException IO) {
			JOptionPane.showMessageDialog(null, "No se  ha indicado el puerto para el juego.");
			System.exit(1);
		}
		return Integer.parseInt(puertoArchivo);

	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				ComandosCliente comand;
				// Creo el paquete que le voy a enviar al servidor
				paqueteUsuario = new PaqueteUsuario();
				MenuJugar menuJugar = null;
				while (!paqueteUsuario.isInicioSesion()) {

					// Muestro el menú principal
					if (menuJugar == null) {
						menuJugar = new MenuJugar(this);
						menuJugar.setVisible(true);

						// Creo los paquetes que le voy a enviar al servidor
						paqueteUsuario = new PaqueteUsuario();
						paquetePersonaje = new PaquetePersonaje();

						// Espero a que el usuario seleccione alguna accion
						wait();

						comand = (ComandosCliente) Paquete.getObjetoSet(Comando.NOMBREPAQUETE, getAccion());
						comand.setCadena(null);
						comand.setCliente(this);
						comand.ejecutar();

						// Le envio el paquete al servidor
						salida.writeObject(gson.toJson(paqueteUsuario));
					}
					// Recibo el paquete desde el servidor
					String cadenaLeida = (String) entrada.readObject();
					Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);

					comand = (ComandosCliente) paquete.getObjeto(Comando.NOMBREPAQUETE);
					comand.setCadena(cadenaLeida);
					comand.setCliente(this);
					comand.ejecutar();
				}

				// Creo un paquete con el comando mostrar mapas
				paquetePersonaje.setComando(Comando.MOSTRARMAPAS);

				// Abro el menu de eleccion del mapa
				MenuMapas menuElegirMapa = new MenuMapas(this);
				menuElegirMapa.setVisible(true);

				// Espero a que el usuario elija el mapa
				wait();

				// Si clickeo en la Cruz al Seleccionar mapas
				if (paquetePersonaje.getMapa() == 0) {
					paquetePersonaje.setComando(Comando.DESCONECTAR);
					salida.writeObject(gson.toJson(paquetePersonaje));
				} else {
					// Establezco el mapa en el paquete personaje
					paquetePersonaje.setIp(miIp);

					// Le envio el paquete con el mapa seleccionado
					salida.writeObject(gson.toJson(paquetePersonaje));

					// Instancio el juego y cargo los recursos
					wome = new Juego("World Of the Middle Earth", ANCHO_JUEGO, ALTO_JUEGO, this, paquetePersonaje);

					// Muestro el menu de carga
					menuCarga = new MenuCarga(this);
					menuCarga.setVisible(true);

					// Espero que se carguen todos los recursos
					wait();

					// Inicio el juego
					wome.start();

					// Finalizo el menu de carga
					menuCarga.dispose();
				}
			} catch (IOException | InterruptedException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor durante el inicio de sesión.");
				System.exit(1);
			}
		}

	}

	/**
	 * @return el cliente
	 */
	public Socket getSocket() {
		return cliente;
	}

	/**
	 * Setea el cliente
	 * 
	 * @param cliente
	 *            cliente a setear
	 */
	public void setSocket(final Socket cliente) {
		this.cliente = cliente;
	}

	/**
	 * Pide la ip
	 * 
	 * @return Devuelve la ip
	 */
	public String getMiIp() {
		return miIp;
	}

	/**
	 * Setea la ip
	 * 
	 * @param miIp
	 *            ip a setear
	 */
	public void setMiIp(final String miIp) {
		this.miIp = miIp;
	}

	/**
	 * Pide la entrada
	 * 
	 * @return Devuelve la entrada
	 */
	public ObjectInputStream getEntrada() {
		return entrada;
	}

	/**
	 * Setea la entrada
	 * 
	 * @param entrada
	 *            entrada a setear
	 */
	public void setEntrada(final ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	/**
	 * Pide la salida
	 * 
	 * @return Devuelve la salida
	 */
	public ObjectOutputStream getSalida() {
		return salida;
	}

	/**
	 * Setea la salida
	 * 
	 * @param salida
	 */
	public void setSalida(final ObjectOutputStream salida) {
		this.salida = salida;
	}

	/**
	 * Pide el paquete usuario
	 * 
	 * @return Devuelve el paquete usuario
	 */
	public PaqueteUsuario getPaqueteUsuario() {
		return paqueteUsuario;
	}

	/**
	 * Pide el paquete personaje
	 * 
	 * @return Devuelve el paquete personaje
	 */
	public PaquetePersonaje getPaquetePersonaje() {
		return paquetePersonaje;
	}

	/**
	 * Pide el juego
	 * 
	 * @return Devuelve el juego
	 */
	public Juego getJuego() {
		return wome;
	}

	/**
	 * Pide el menu de carga
	 * 
	 * @return Devuelve el menu de carga
	 */
	public MenuCarga getMenuCarga() {
		return menuCarga;
	}

	/**
	 * Actualiza los items del personaje.
	 * 
	 * @param el personaje
	 */
	public void actualizarItems(PaquetePersonaje paqueteActualizado) {
		if (paquetePersonaje.getCantItems() != 0
				&& paquetePersonaje.getCantItems() != paqueteActualizado.getCantItems()) {
			paquetePersonaje.anadirItem(paqueteActualizado.getItems().get(paqueteActualizado.getItems().size() - 1));
		}
	}
	
	/**
	 * Solicitud de direccion ip-
	 * 
	 * @return la ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Pide el menu de carga
	 * 
	 * @param pP el cual es el nuevo paquetePersonaje.
	 */
	public void actualizarPersonaje(final PaquetePersonaje pP) {
		paquetePersonaje = pP;
	}
	
	public void actualizarCheats(final PaquetePersonaje pP) {
		paquetePersonaje = pP;
	}

	/**
	 * Solicitud de Juego actual
	 * @return el juego
	 */
	public Juego getWome() {
		return wome;
	}

	/**
	 * seteo de juego 
	 * @param wome ingreso de juego nuevo
	 */
	public void setWome(final Juego wome) {
		this.wome = wome;
	}

	/**
	 * 
	 * @return entero con el puerto actual
	 */
	
	public int getPuerto() {
		return puerto;
	}

	/**
	 * 
	 * @param paqueteUsuario
	 */
	public void setPaqueteUsuario(final PaqueteUsuario paqueteUsuario) {
		this.paqueteUsuario = paqueteUsuario;
	}
 
	/**
	 * 
	 * @param paquetePersonaje
	 */
	public void setPaquetePersonaje(final PaquetePersonaje paquetePersonaje) {
		this.paquetePersonaje = paquetePersonaje;
	}
  
	/**
	 * 
	 * @param ip
	 */
	public void setIp(final String ip) {
		this.ip = ip;
	}
	
	/**
	 * 
	 * @param menuCarga
	 */
	public void setMenuCarga(final MenuCarga menuCarga) {
		this.menuCarga = menuCarga;
	}

	/**
	 * 
	 * @return MenuComerciar
	 */
	public MenuComerciar getM1() {
		return m1;
	}
  
	/**
	 * 
	 * @param m1
	 */
	public void setM1(final MenuComerciar m1) {
		this.m1 = m1;
	}
    
	/**
	 * 
	 * @return PaqueteComerciar
	 */
	public PaqueteComerciar getPaqueteComercio() {
		return paqueteComercio;
	}
    
	/**
	 * 
	 * @param paqueteComercio
	 */
	public void setPaqueteComercio(final PaqueteComerciar paqueteComercio) {
		this.paqueteComercio = paqueteComercio;
	}
	
	/**
	 * 
	 * @return PaqueteMensaje
	 */
	public PaqueteMensaje getPaqueteMensaje() {
		return paqueteMensaje;
	}
  
	/**
	 * 
	 * @param paqueteMensaje
	 */
	public void setPaqueteMensaje(final PaqueteMensaje paqueteMensaje) {
		this.paqueteMensaje = paqueteMensaje;
	}
}
