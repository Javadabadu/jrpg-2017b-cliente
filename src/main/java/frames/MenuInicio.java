package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * @author Javadabadu
 */
public class MenuInicio extends JFrame {

	private JPanel contentPane;
	private static int x1 = 100;
	private static int y1 = 100;
	private static int width1 = 450;
	private static int height1 = 300;
	private static int x2 = 109;
	private static int y2 = 39;
	private static int width2 = 216;
	private static int height2 = 90;
	private static int x3 = 0;
	private static int y3 = 0;
	private static int width3 = 444;
	private static int height3 = 271;
	private static int x4 = 205;
	private static int y4 = 162;
	private static int width4 = 482;
	private static int height4 = 23;
	private static int x5 = 210;
	private static int y5 = 202;
	private static int width5 = 91;
	private static int height5 = 23;
	private static int x6 = 127;
	private static int y6 = 162;
	private static int width6 = 191;
	private static int height6 = 23;
	private static int x7 = 127;
	private static int y7 = 202;
	private static int width7 = 191;
	private static int height7 = 23;
	private static int x8 = 0;
	private static int y8 = 0;
	private static int width8 = 444;
	private static int height8 = 271;
	private static int top = 5;
	private static int bottom = 5;
	private static int left = 5;
	private static int right = 5;
	private static int font = 15;
	/**
	 * Constructor por defecto
	 */
	public MenuInicio() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Cliente cliente = new Cliente();
					cliente.start();
					dispose();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
				new Point(0, 0), "custom cursor"));

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Propiedades de la ventana
		setTitle("WOME - World Of the Middle Earth");
		setBounds(x1, y1, width1, height1);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(top, left, bottom, right));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
		lblLogo.setBounds(x2, y2, width2, height2);
		contentPane.add(lblLogo);


		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(x3, y3, width3, height3);
		contentPane.add(layeredPane);

		// Boton Jugar
		JLabel lblRegistrarse = new JLabel("Jugar");
		lblRegistrarse.setBounds(x4, y4, width4, height4);
		layeredPane.add(lblRegistrarse, new Integer(2));
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblRegistrarse.setBackground(Color.WHITE);

		// Boton Salir
		JLabel lblIniciarSesion = new JLabel("Salir");
		lblIniciarSesion.setBounds(x5, y5, width5, height5);
		layeredPane.add(lblIniciarSesion, new Integer(2));
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, font));

		JButton btnRegistrar = new JButton("Jugar");
		btnRegistrar.setBounds(x6, y6, width6, height6);
		layeredPane.add(btnRegistrar, new Integer(1));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.start();
				dispose();
			}
		});
		JButton btnIniciarSesion = new JButton("Salir");
		btnIniciarSesion.setBounds(x7, y7, width7, height7);
		layeredPane.add(btnIniciarSesion, new Integer(1));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(x8, y8, width8, height8);
		lblBackground.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
		layeredPane.add(lblBackground, new Integer(0));
	}
	/**
	 * 
	 * Main
	 */
	public static void main(final String[] args) {
		new MenuInicio().setVisible(true);
	}
}
