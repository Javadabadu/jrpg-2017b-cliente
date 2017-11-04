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
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cliente.Cliente;
import mensajeria.Comando;
/**
 * @author Javadabadu
 */
public class MenuRegistro extends JFrame {

	private JTextField txtUsuario;
	private JPasswordField pwPassword;
	private static int x1 = 100;
	private static int y1 = 100;
	private static int width1 = 450;
	private static int height1 = 300;
	private static int x2 = 0;
	private static int y2 = 0;
	private static int width2 = 444;
	private static int height2 = 271;
	private static int x3 = 113;
	private static int y3 = 70;
	private static int width3 = 57;
	private static int height3 = 19;
	private static int x4 = 113;
	private static int y4 = 121;
	private static int width4 = 65;
	private static int height4 = 17;
	private static int x5 = 186;
	private static int y5 = 182;
	private static int width5 = 82;
	private static int height5 = 23;
	private static int x6 = 143;
	private static int y6 = 182;
	private static int width6 = 153;
	private static int height6 = 23;
	private static int x7 = 199;
	private static int y7 = 120;
	private static int width7 = 118;
	private static int height7 = 20;
	private static int x8 = 199;
	private static int y8 = 69;
	private static int width8 = 118;
	private static int height8 = 20;
	private static int x9 = 0;
	private static int y9 = 0;
	private static int width9 = 444;
	private static int height9 = 271;
	private static int columns = 10;
	private static int font1 = 15;
	/**
	 * Constructor
	 */
	public MenuRegistro(final Cliente cliente) {
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
				dispose();
			}
		});
		setTitle("WOME - Registrarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(x1, y1, width1, height1);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(x2, y2, width2, height2);
		getContentPane().add(layeredPane);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(x3, y3, width3, height3);
		layeredPane.add(lblUsuario, new Integer(1));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, font1));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(x4, y4, width4, height4);
		layeredPane.add(lblPassword, new Integer(1));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, font1));

		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setBounds(x5, y5, width5, height5);
		layeredPane.add(lblRegistrarse, new Integer(2));
		lblRegistrarse.setForeground(Color.WHITE);
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, font1));

		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBounds(x6, y6, width6, height6);
		layeredPane.add(btnRegistrarse, new Integer(1));
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/BotonMenu.png")));

		pwPassword = new JPasswordField();
		pwPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logIn(cliente);
				dispose();
			}
		});
		pwPassword.setBounds(x7, y7, width7, height7);
		layeredPane.add(pwPassword, new Integer(1));

		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logIn(cliente);
				dispose();
			}
		});
		txtUsuario.setBounds(x8, y8, width8, height8);
		layeredPane.add(txtUsuario, new Integer(1));
		txtUsuario.setColumns(columns);

		JLabel labelBackground = new JLabel("");
		labelBackground.setBounds(x9, y9, width9, height9);
		layeredPane.add(labelBackground, new Integer(0));
		labelBackground.setIcon(new ImageIcon(MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
		btnRegistrarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				logIn(cliente);
				dispose();
			}
		});
	}
	/**
	 * @return obtiene el txtUsuario
	 */
	public JTextField gettxtUsuario() {
		return txtUsuario;
	}
	/**
	 * setea el txtUsuario
	 */
	public void settxtUsuario(final JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	/**
	 * @return obtiene el pwPassword
	 */
	public JPasswordField getPasswordField() {
		return pwPassword;
	}
	/**
	 * setea el pwPassword
	 */
	public void setPasswordField(final JPasswordField pwPassword) {
		this.pwPassword = pwPassword;
	}
	/**
	 * Loguea
	 */
	private void logIn(final Cliente cliente) {
		synchronized (cliente) {
			cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
			cliente.getPaqueteUsuario().setPassword(String.valueOf(pwPassword.getPassword()));
			cliente.setAccion(Comando.REGISTRO);
			cliente.notify();
		}
	}
}