package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.ImageIcon;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * @author Javadabadu
 */
public class MenuCarga extends JFrame {

	private JPanel contentPane;
	private JLabel barraCargando;
	private static int x1 = 100;
	private static int y1 = 100;
	private static int width1 = 450;
	private static int height1 = 300;
	private static int x2 = 52;
	private static int y2 = 160;
	private static int width2 = 0;
	private static int height2 = 27;
	private static int x3 = 47;
	private static int y3 = 154;
	private static int width3 = 355;
	private static int height3 = 40;
	private static int x4 = 109;
	private static int y4 = 39;
	private static int width4 = 216;
	private static int height4 = 90;
	private static int x5 = 0;
	private static int y5 = 0;
	private static int width5 = 444;
	private static int height5 = 271;
	private static int top = 5;
	private static int bottom = 5;
	private static int left = 5;
	private static int right = 5;
	/**
	 * Constructor
	 */
	public MenuCarga(final Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
				new Point(0,0),"custom cursor"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// En caso de cerrar la ventana
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				dispose();
			}
		});

		// Propiedades de la ventana
		setTitle("WOME - World Of the Middle Earth");
		setBounds(x1, y1, width1, height1);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(top, left, bottom, right));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		barraCargando = new JLabel("");
		barraCargando.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/Barra.png")));
		barraCargando.setBounds(x2, y2, 0, height2);
		contentPane.add(barraCargando);

		JLabel lblBarraCarga = new JLabel("");
		lblBarraCarga.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/BarraCarga.png")));
		lblBarraCarga.setBounds(x3, y3, width3, height3);
		contentPane.add(lblBarraCarga);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
		lblLogo.setBounds(x4, y4, width4, height4);
		contentPane.add(lblLogo);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(x5, y5, width5, height5);
		contentPane.add(lblBackground);
		lblBackground.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/menuBackground.jpg")));
	}
	/**
	 * setea la barra de carga
	 */
	public void setBarraCargando(final int ancho) {
		barraCargando.setSize(ancho, 27);
	}
}


