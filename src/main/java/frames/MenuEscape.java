package frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.sun.glass.events.KeyEvent;

import cliente.Cliente;
import estados.Estado;
import juego.Pantalla;

import mensajeria.Comando;
import mensajeria.Paquete;
/**
 * @author Javadabadu
 */
public class MenuEscape extends JFrame {

	private JPanel contentPane;
	private final Gson gson = new Gson();
	private static int x1 = 100;
	private static int y1 = 100;
	private static int width1 = 180;
	private static int height1 = 270;
	private static int x2 = 29;
	private static int y2 = 13;
	private static int width2 = 125;
	private static int height2 = 25;
	private static int x3 = 29;
	private static int y3 = 66;
	private static int width3 = 125;
	private static int height3 = 25;
	private static int x4 = 29;
	private static int y4 = 121;
	private static int width4 = 125;
	private static int height4 = 25;
	private static int x5 = 29;
	private static int y5 = 175;
	private static int width5 = 125;
	private static int height5 = 25;
	private static int x6 = 29;
	private static int y6 = 227;
	private static int width6 = 125;
	private static int height6 = 25;
	private static int x7 = 0;
	private static int y7 = 0;
	private static int width7 = 186;
	private static int height7 = 273;
	private static int top = 5;
	private static int bottom = 5;
	private static int left = 5;
	private static int right = 5;
	private static int widthScaled = 200;
	private static int heightScaled = 350:
	/**
	 * @param cliente
	 * Create the frame.
	 */
	public MenuEscape(final Cliente cliente) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setBounds(x1, y1, width1, height1);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(top, left, bottom, right));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton verStats = new JButton("Estadísticas");
		verStats.setIcon(new ImageIcon("recursos//stats.png"));
		verStats.setToolTipText("Presiona S para ver estadísticas");
		verStats.setBounds(x2, y2, width2, height2);
		verStats.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
				Pantalla.menuEscp = null;
				if (Pantalla.menuStats == null) {
					Pantalla.menuStats = new MenuStats(cliente);
					Pantalla.menuStats.setVisible(true);		
				}
			}
		});
		contentPane.add(verStats);
		JButton asignarSkills = new JButton("Asignar Skills");
		asignarSkills.setIcon(new ImageIcon("recursos//asignar skills.png"));
		asignarSkills.setToolTipText("Presiona A para asignar skills");
		asignarSkills.setBounds(x3, y3, width3, height3);
		asignarSkills.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
				Pantalla.menuEscp = null;
				if (Pantalla.menuAsignar == null) {
					Pantalla.menuAsignar = new MenuAsignarSkills(cliente);
					Pantalla.menuAsignar.setVisible(true);
				}
			}
		});
		contentPane.add(asignarSkills);
		JButton inventario = new JButton("Inventario");
		inventario.setIcon(new ImageIcon("recursos//inventario.png"));
		inventario.setToolTipText("Presiona I para abrir inventario");
		inventario.setBounds(x4, y4, width4, height4);
		inventario.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
				Pantalla.menuEscp = null;
				if (Estado.getEstado().esEstadoDeJuego()) {
					if (Pantalla.getMenuInventario() == null) {
						MenuInventario menu = new MenuInventario(cliente);
						Pantalla.setMenuInventario(menu);
						Pantalla.getMenuInventario().setVisible(true);
					}
				}
			}
		});
		contentPane.add(inventario);
		JButton desconectarse = new JButton("Desconectarse");
		desconectarse.setBounds(x5, y5, width5, height5);
		desconectarse.setIcon(new ImageIcon("recursos//desconectarse.png"));
		desconectarse.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
					try {
						Paquete p = new Paquete();
						p.setComando(Comando.DESCONECTAR);
						p.setIp(cliente.getMiIp());
						cliente.getSalida().writeObject(gson.toJson(p));
						cliente.getEntrada().close();
						cliente.getSalida().close();
						cliente.getSocket().close();
						System.exit(0);
					} catch (final IOException e1) {
						JOptionPane.showMessageDialog(null, "Error al desconectar");
					}
			}
		});
		contentPane.add(desconectarse);
		JButton volver = new JButton("Volver");
		volver.setIcon(new ImageIcon("recursos//volver.png"));
		volver.setBounds(x6, y6, width6, height6);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Pantalla.menuEscp = null;
				dispose();
			}
		});
		contentPane.add(volver);
		BufferedImage imagenFondo = null;
		try {
			imagenFondo = ImageIO.read(new File("recursos//fondo2.png"));
		} catch (final IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

		}
		JLabel background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(widthScaled, heightScaled, Image.SCALE_DEFAULT)));
		background.setBounds(x7, y7, width7, height7);
		contentPane.add(background);
	}
}
