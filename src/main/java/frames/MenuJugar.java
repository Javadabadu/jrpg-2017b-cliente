package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.*;
import mensajeria.Comando;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;
/**
 * @author Javadabadu
 */
public class MenuJugar extends JFrame {

	private JPanel contentPane;
	private static int x = 100;
	private static int y = 100;
	private static int width = 450;
	private static int height = 300;
	private static int x2 = 0;
	private static int y2 = 0;
	private static int width2 = 444;
	private static int height2 = 271;
	private static int x3 = 181;
	private static int y3 = 162;
	private static int width3 = 82;
	private static int height3 = 23;
	private static int x4 = 175;
	private static int y4 = 91;
	private static int width4 = 91;
	private static int height4 = 23;
	private static int x5 = 121;
	private static int y5 = 162;
	private static int width5 = 191;
	private static int height5 = 23;
	private static int x6 = 121;
	private static int y6 = 92;
	private static int width6 = 191;
	private static int height6 = 23;
	private static int top = 5;
	private static int bottom = 5;
	private static int left = 5;
	private static int right = 5;
	private static int font = 15;
	/**
	 * Constructor parametrizado
	 */
	public MenuJugar(final Cliente cliente) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
					menuInicioSesion.setVisible(true);
					dispose();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
				new Point(0,0), "custom cursor"));

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
		setBounds(x, y, width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(top, left, bottom, right));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(x2, y2, width2, height2);
		contentPane.add(layeredPane);

		// Boton Registrarse
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setBounds(x3, y3, width3, height3);
		layeredPane.add(lblRegistrarse, new Integer(2));
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setEnabled(true);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, font));
		lblRegistrarse.setBackground(Color.WHITE);

		// Boton Iniciar sesion
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setBounds(x4, y4, width4, height4);
		layeredPane.add(lblIniciarSesion, new Integer(2));
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, font));

		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setBounds(x5, y5, width5, height5);
		layeredPane.add(btnRegistrar, new Integer(1));
		btnRegistrar.setFocusable(false);
		btnRegistrar.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				MenuRegistro menuRegistro = new MenuRegistro(cliente);
				menuRegistro.setVisible(true);
				dispose();
			}
		});

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(x6, y6, width6, height6);
		layeredPane.add(btnIniciarSesion, new Integer(1));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/BotonMenu.png")));
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				MenuInicioSesion menuInicioSesion = new MenuInicioSesion(cliente);
				menuInicioSesion.setVisible(true);
				dispose();
			}
		});
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(x2, y2, width2, height2);
		lblBackground.setIcon(new ImageIcon(MenuJugar.class.getResource("/frames/menuBackground.jpg")));
		layeredPane.add(lblBackground, new Integer(0));
	}
}


