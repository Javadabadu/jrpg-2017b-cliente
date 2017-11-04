package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;
/**
 * @author Javadabadu
 */
public class MenuInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static int x1 = 100;
	private static int y1 = 100;
	private static int width1 = 450;
	private static int height1 = 300;
	private static int x2 = 0;
	private static int y2 = 0;
	private static int width2 = 444;
	private static int height2 = 271;
	private static int x3 = 111;
	private static int y3 = 118;
	private static int width3 = 68;
	private static int height3 = 21;
	private static int x4 = 111;
	private static int y4 = 66;
	private static int width4 = 55;
	private static int height4 = 23;
	private static int x5 = 193;
	private static int y5 = 183;
	private static int width5 = 68;
	private static int height5 = 23;
	private static int x6 = 198;
	private static int y6 = 69;
	private static int width6 = 118;
	private static int height6 = 20;
	private static int x7 = 198;
	private static int y7 = 119;
	private static int width7 = 118;
	private static int height7 = 20;
	private static int x8 = 141;
	private static int y8 = 182;
	private static int width8 = 153;
	private static int height8 = 23;
	private static int x9 = 0;
	private static int y9 = 0;
	private static int width9 = 444;
	private static int height9 = 271;
	private static int top = 5;
	private static int bottom = 5;
	private static int left = 5;
	private static int right = 5;
	private static int font1 = 15;
	private static int font2 = 11;
	private static int columns = 10;
	/**
	 * Constructor 
	 */
	public MenuInicioSesion(final Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(),
				new Point(0, 0), "custom cursor"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

		setTitle("WOME - Iniciar Sesion");
		setBounds(x1, y1, width1, height1);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(top, left, bottom, right));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(x2, y2, width2, height2);
		contentPane.add(layeredPane);
		JLabel lblNewLabel1 = new JLabel("Password");
		lblNewLabel1.setBounds(x3, y3, width3, height3);
		layeredPane.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, font1));
		lblNewLabel1.setForeground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(x4, y4, width4, height4);
		layeredPane.add(lblNewLabel, new Integer(2));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, font1));

		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setBounds(x5, y5, width5, height5);
		layeredPane.add(lblIngresar, new Integer(2));
		lblIngresar.setForeground(Color.WHITE);
		lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, font1));

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				logIn(cliente);
			}
		});
		textField.setBounds(x6, y6, width6, height6);
		layeredPane.add(textField, new Integer(1));
		textField.setColumns(columns);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logIn(cliente);
			}
		});
		passwordField.setBounds(x7, y7, width7, height7);
		layeredPane.add(passwordField, new Integer(1));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, font2));

		JButton btnConectar = new JButton("");
		btnConectar.setBounds(x8, y8, width8, height8);
		layeredPane.add(btnConectar, new Integer(1));
		btnConectar.setFocusable(false);
		btnConectar.setIcon(new ImageIcon(MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
		btnConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logIn(cliente);
			}
		});


		JLabel labelBackground = new JLabel("");
		labelBackground.setBounds(x9, y9, width9, height9);
		labelBackground.setIcon(new ImageIcon(
				MenuInicioSesion.class.getResource("/frames/menuBackground.jpg")));
		layeredPane.add(labelBackground, new Integer(0));
	}

	private void logIn(final Cliente cliente) {
		synchronized (cliente) {
			cliente.setAccion(Comando.INICIOSESION);
			cliente.getPaqueteUsuario().setUsername(textField.getText());
			cliente.getPaqueteUsuario().setPassword(String.valueOf(passwordField.getPassword()));
			cliente.notify();
			dispose();
		}
	}
}
