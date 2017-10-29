package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.google.gson.Gson;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;
import frames.MenuEscape;
import frames.MenuInventario;
import frames.MenuJugar;
import frames.MenuStats;
import mensajeria.Comando;
import mensajeria.Paquete;

public class Pantalla {

	private JFrame pantalla;
	private Canvas canvas;
	private Cliente myClient;

	// Menus
	public static MenuInventario menuInventario;
	public static MenuAsignarSkills menuAsignar;
	public static MenuStats menuStats;
	public static MenuEscape menuEscp;
	public static VentanaContactos ventContac;
	private HashMap<Integer, Runnable> mapMenus = new HashMap<Integer, Runnable>(); //Necesito el hashmap de runnables para los metodos de menus
		
	private final Gson gson = new Gson();

	public Pantalla(final String NOMBRE, final int ANCHO, final int ALTO, final Cliente cliente) {
		
		this.myClient = cliente; //Necesito atributo cliente para usar en los metodos propios de la clase
		
		pantalla = new JFrame(NOMBRE);
		pantalla.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
			new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
			new Point(0,0),"custom cursor"));

		pantalla.setSize(ANCHO, ALTO);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		pantalla.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				try {
					Paquete p = new Paquete();
					p.setComando(Comando.DESCONECTAR);
					p.setIp(cliente.getMiIp());
					cliente.getSalida().writeObject(gson.toJson(p));
					cliente.getEntrada().close();
					cliente.getSalida().close();
					cliente.getSocket().close();
					System.exit(0);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Fallo al intentar cerrar la aplicación.");
					System.exit(1);
				}
			}
		});
		
		this.mapMenus.put(KeyEvent.VK_I, ()->menuInventario());
		this.mapMenus.put(KeyEvent.VK_A, ()->menuAsignarSkills());
		this.mapMenus.put(KeyEvent.VK_S, ()->menuStats());
		this.mapMenus.put(KeyEvent.VK_ESCAPE, ()->menuEscape());
		this.mapMenus.put(KeyEvent.VK_C, ()->ventanaContacto());
		
		pantalla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (mapMenus.get(e.getKeyCode()) != null) {
					
					if (Estado.getEstado().esEstadoDeJuego()) {
						
						mapMenus.get(e.getKeyCode()).run();
					}
				}
			}
		});



		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(false);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
		canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
		canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
		canvas.setFocusable(false);

		pantalla.add(canvas);
		pantalla.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return pantalla;
	}

	public void mostrar() {
		pantalla.setVisible(true);
	}

	public static void centerString(Graphics g, Rectangle r, String s) {
	    FontRenderContext frc = new FontRenderContext(null, true, true);

	    Rectangle2D r2D = g.getFont().getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int rHeight = (int) Math.round(r2D.getHeight());
	    int rX = (int) Math.round(r2D.getX());
	    int rY = (int) Math.round(r2D.getY());

	    int a = (r.width / 2) - (rWidth / 2) - rX;
	    int b = (r.height / 2) - (rHeight / 2) - rY;

	    g.drawString(s, r.x + a, r.y + b);
	}
	
	private void menuInventario(){
		
		if (menuInventario == null) {
			menuInventario = new MenuInventario(myClient);
			menuInventario.setVisible(true);
		}
	
	}
	
	private void menuAsignarSkills(){
		if(menuAsignar == null){
			menuAsignar = new MenuAsignarSkills(myClient);
			menuAsignar.setVisible(true);
		}
	}
	
	private void menuStats(){
		if(menuStats == null){
			menuStats = new MenuStats(myClient);
			menuStats.setVisible(true);
		}
	}
	
	private void menuEscape(){
		if (menuEscp == null) {
			menuEscp = new MenuEscape(myClient);
			menuEscp.setVisible(true);
		}
	}
	
	private void ventanaContacto(){
		if (ventContac == null) {
			ventContac = new VentanaContactos(myClient.getJuego());
			ventContac.setVisible(true);
		}
	}
}