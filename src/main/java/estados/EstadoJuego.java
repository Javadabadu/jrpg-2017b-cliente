package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoPersonaje;
import interfaz.MenuNPC;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaqueteNpc;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;
/**
 * @author Javadabadu
 */
public class EstadoJuego extends Estado {

	private Entidad entidadPersonaje;
	private PaquetePersonaje paquetePersonaje;
	private Mundo mundo;
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	private Map<Integer, PaquetePersonaje> personajesConectados;
	private Map<Integer,String> mapas = new HashMap<Integer,String>();
	private boolean haySolicitud;
	private boolean haySolicitudNPC;
	private int tipoSolicitud;
	
	private Map<Integer, PaqueteNpc> npcs;
	
	private final Gson gson = new Gson();

	private BufferedImage miniaturaPersonaje;

	private MenuInfoPersonaje menuEnemigo;
	MenuNPC menuEnemigoNPC;

	public EstadoJuego(Juego juego) {
		super(juego);
		iniciarMapas();
		mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt", "recursos/" + getMundo() + ".txt");
		paquetePersonaje = juego.getPersonaje();
		entidadPersonaje = new Entidad(juego, mundo, 64, 64, juego.getPersonaje().getNombre(), 0, 0, Recursos.personaje.get(juego.getPersonaje().getRaza()), 150);
		miniaturaPersonaje = Recursos.personaje.get(paquetePersonaje.getRaza()).get(5)[0];

		try {
			// Le envio al servidor que me conecte al mapa y mi posicion
			juego.getPersonaje().setComando(Comando.CONEXION);
			juego.getPersonaje().setEstado(Estado.getEstadoJuego());
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
			juego.getCliente().getSalida().writeObject(gson.toJson(juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexion con el servidor al ingresar al mundo");
		}
	}

	private void iniciarMapas() {
		mapas.put(1, "Aubenor");
		mapas.put(2, "Aris");
		mapas.put(3, "Eodrim");
	}
	
	
	@Override
	public void actualizar() {
		mundo.actualizar();
		entidadPersonaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.getBackground(), 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		entidadPersonaje.graficar(g);
		graficarPersonajes(g);
		graficarNpc(g);
		mundo.graficarObstaculos(g);
		entidadPersonaje.graficarNombre(g);
		 g.drawImage(Recursos.getMarco(), 0, 0, juego.getAncho(), juego.getAlto(), null);
		EstadoDePersonaje.dibujarEstadoDePersonaje(g, 5, 5, paquetePersonaje, miniaturaPersonaje);
		g.drawImage(Recursos.getMochila(), 738, 545, 59, 52, null);
		g.drawImage(Recursos.getMenu(), 3, 562, 102, 35, null);
		g.drawImage(Recursos.getChat(), 3, 524, 102, 35, null);
		if(haySolicitud)
			menuEnemigo.graficar(g, tipoSolicitud);
		if(haySolicitudNPC)
			menuEnemigoNPC.graficar(g, tipoSolicitud);

	}
	
	public void graficarPersonajes(Graphics g) {

		if(juego.getPersonajesConectados() != null){
			personajesConectados = new HashMap(juego.getPersonajesConectados());
			ubicacionPersonajes = new HashMap(juego.getUbicacionPersonajes());
			Iterator<Integer> it = personajesConectados.keySet().iterator();
			int key;
			PaqueteMovimiento actual;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
			while (it.hasNext()) {
				key = it.next();
				actual = ubicacionPersonajes.get(key);
				if(juego.getPersonajesConectados().get(key).isModoInvisible() && !juego.getCliente().getPaquetePersonaje().isModoInvisible()) {
					
				}else {
					if (actual != null && actual.getIdPersonaje() != juego.getPersonaje().getId() && personajesConectados.get(actual.getIdPersonaje()).getEstado() == Estado.getEstadoJuego()) {
						Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32), (int) (actual.getPosY() - juego.getCamara().getyOffset() - 20 ), 0, 10), personajesConectados.get(actual.getIdPersonaje()).getNombre());
						g.drawImage(Recursos.personaje.get(personajesConectados.get(actual.getIdPersonaje()).getRaza()).get(actual.getDireccion())[actual.getFrame()],
								(int) (actual.getPosX() - juego.getCamara().getxOffset() ),
								(int) (actual.getPosY() - juego.getCamara().getyOffset()),
								64, 64, null);
						
					    }
					}
			}
		}
	}
	
	public void graficarNpc(Graphics g){
		if (juego.getNpcs() != null) {
			//Obtengo los NPC y su posicion que se crearon cuando inicio el juego
			npcs = new HashMap<Integer, PaqueteNpc>(juego.getNpcs());
			
			Iterator<Integer> itNpc = npcs.keySet().iterator();
			int key;
			PaqueteNpc actual;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
			while (itNpc.hasNext()) {				
				key = itNpc.next();
				actual = npcs.get(key);
				if (actual != null && npcs.get(actual.getId()).getEstado() == Estado.getEstadoJuego()){
		 		Pantalla.centerString(g, new Rectangle((int) (actual.getPosX() - juego.getCamara().getxOffset() + 32),
		 				(int) (actual.getPosY() - juego.getCamara().getyOffset() - 20 ), 0, 10),
		 				npcs.get(actual.getId()).getNombre());	
		 	
		 		g.drawImage(Recursos.personaje.get(actual.getType()).get(actual.getDireccion())[actual.getFrame()],
		 				(int) (actual.getPosX() - juego.getCamara().getxOffset() ),
		 				(int) (actual.getPosY() - juego.getCamara().getyOffset()),
		 				64, 64, null);
		 		
				}
			}
			
		}

	}
			 		

	public Entidad getPersonaje() {
		return entidadPersonaje;
	}

	private String getMundo() {
		return mapas.get(juego.getPersonaje().getMapa());
	}

	public void setHaySolicitud(boolean b, PaquetePersonaje enemigo, int tipoSolicitud) {
		haySolicitud = b;
		// menu que mostrara al enemigo
		menuEnemigo = new MenuInfoPersonaje(300, 50, enemigo);
		this.tipoSolicitud = tipoSolicitud;
	}

	public boolean getHaySolicitud() {
		return haySolicitud;
	}

	public void actualizarPersonaje() {
		paquetePersonaje = juego.getPersonaje();
	}

	public MenuInfoPersonaje getMenuEnemigo(){
		return menuEnemigo;
	}

	public void setMenuEnemigo(final MenuInfoPersonaje menu) {
		menuEnemigo = menu;
	}

	public int getTipoSolicitud() {
		return tipoSolicitud;
	}
	
	@Override
	public boolean esEstadoDeJuego() {
		return true;
	}
	
	public void setHaySolicitudNPC(boolean b, PaqueteNpc enemigo, int tipoSolicitud) {
		haySolicitudNPC = b;
		// menu que mostrara al enemigo
		menuEnemigoNPC = new MenuNPC(300, 50, enemigo);
		this.tipoSolicitud = tipoSolicitud;
	}

	public boolean getHaySolicitudNPC() {
		return haySolicitudNPC;
	}
	
	public MenuNPC getMenuEnemigoNPC(){
		return menuEnemigoNPC;
	}
}



