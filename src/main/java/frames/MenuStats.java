package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * Menu Estadisticas.
 */
public class MenuStats extends JFrame {

	private static final int EMPTYBORDER = 5;
	private static final int BX = 100;
	private static final int BY = 100;
	private static final int BW = 346;
	private static final int BZ = 321;
	private static final int NOMBREX = 12;
	private static final int NOMBREY = 13;
	private static final int NOMBREW = 56;
	private static final int NOMBREZ = 16;
	private static final int CASTAX = 12;
	private static final int CASTAY = 42;
	private static final int CASTAW = 56;
	private static final int CASTAZ = 16;
	private static final int RAZAX = 12;
	private static final int RAZAY = 71;
	private static final int RAZAW = 56;
	private static final int RAZAZ = 16;
	private static final int NIVELX = 169;
	private static final int NIVELY = 13;
	private static final int NIVELW = 56;
	private static final int NIVELZ = 16;
	private static final int EXPERIENCIAX = 169;
	private static final int EXPERIENCIAY = 42;
	private static final int EXPERIENCIAW = 72;
	private static final int EXPERIENCIAZ = 16;
	private static final int ENERGIAX = 169;
	private static final int ENERGIAY = 100;
	private static final int ENERGIAW = 48;
	private static final int ENERGIAZ = 16;
	private static final int SALUDX = 12;
	private static final int SALUDY = 100;
	private static final int SALUDW = 56;
	private static final int SALUDZ = 16;
	private static final int FUERZAX = 12;
	private static final int FUERZAY = 129;
	private static final int FUERZAW = 48;
	private static final int FUERZAZ = 16;
	private static final int DESTREZAX = 12;
	private static final int DESTREZAY = 158;
	private static final int DESTREZAW = 56;
	private static final int DESTREZAZ = 16;
	private static final int INTELIGENCIAX = 12;
	private static final int INTELIGENCIAY = 187;
	private static final int INTELIGENCIAW = 72;
	private static final int INTELIGENCIAZ = 16;
	private static final int ATAQUEX = 169;
	private static final int ATAQUEY = 129;
	private static final int ATAQUEW = 48;
	private static final int ATAQUEZ = 16;
	private static final int DEFENSAX = 169;
	private static final int DEFENSAY = 158;
	private static final int DEFENSAW = 56;
	private static final int DEFENSAZ = 16;
	private static final int MAGIAX = 169;
	private static final int MAGIAY = 187;
	private static final int MAGIAW = 39;
	private static final int MAGIAZ = 16;
	private static final int CANTIDADITEMSX = 12;
	private static final int CANTIDADITEMSY = 216;
	private static final int CANTIDADITEMSW = 110;
	private static final int CANTIDADITEMSZ = 16;
	private static final int PJX = 80;
	private static final int PJW = 77;
	private static final int PJZ = 16;
	private static final int NMBPJY = 13;
	private static final int CSTPJY = 42;
	private static final int RZPJY = 71;
	private static final int SALUDPJY = 100;
	private static final int FZAPJY = 129;
	private static final int DSTRZAPJY = 158;
	private static final int INTPJY = 187;
	private static final int CANTITEMSX = 118;
	private static final int CANTITEMSY = 216;
	private static final int CANTITEMSW = 39;
	private static final int CANTITEMSZ = 16;
	private static final int PjX = 251;
	private static final int PjW = 77;
	private static final int PjZ = 16;
	private static final int LVPJY = 13;
	private static final int XPPJY = 42;
	private static final int ENERGIAPJY = 100;
	private static final int ATAPJY = 129;
	private static final int DEFPJY = 158;
	private static final int MAGICPJY = 187;

	private static final int VOLVERX = 158;
	private static final int VOLVERY = 245;
	private static final int VOLVERW = 97;
	private static final int VOLVERZ = 25;

	private static final int BACKX = 158;
	private static final int BACKY = 245;
	private static final int BACKW = 97;
	private static final int BACKZ = 25;
	
	private static final int IMAGENX = 400;
	private static final int IMAGENY = 350;

	private JPanel contentPane;
	private PaquetePersonaje paquetePersonaje;
	private final double mod = 1.5;

	/**
	 * Create the frame.
	 */
	public MenuStats(final Cliente cliente) {
		paquetePersonaje = cliente.getPaquetePersonaje();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(BX, BY, BW, BZ);
		this.setLocationRelativeTo(null);
		this.setTitle("Estadísticas");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(EMPTYBORDER, EMPTYBORDER, EMPTYBORDER, EMPTYBORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Pantalla.menuStats = null;
				dispose();
			}
		});

		BufferedImage imagenFondo = null;
		try {
			imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

		}

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(NOMBREX, NOMBREY, NOMBREW, NOMBREZ);
		contentPane.add(lblNombre);

		JLabel lblCasta = new JLabel("Casta");
		lblCasta.setForeground(Color.WHITE);
		lblCasta.setBounds(CASTAX, CASTAY, CASTAW, CASTAZ);
		contentPane.add(lblCasta);

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setForeground(Color.WHITE);
		lblRaza.setBounds(RAZAX, RAZAY, RAZAW, RAZAZ);
		contentPane.add(lblRaza);

		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setBounds(NIVELX, NIVELY, NIVELW, NIVELZ);
		contentPane.add(lblNivel);

		JLabel lblExperiencia = new JLabel("Experiencia");
		lblExperiencia.setForeground(Color.WHITE);
		lblExperiencia.setBounds(EXPERIENCIAX, EXPERIENCIAY, EXPERIENCIAW, EXPERIENCIAZ);
		contentPane.add(lblExperiencia);

		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setForeground(Color.WHITE);
		lblEnergia.setBounds(ENERGIAX, ENERGIAY, ENERGIAW, ENERGIAZ);
		contentPane.add(lblEnergia);

		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setBounds(SALUDX, SALUDY, SALUDW, SALUDZ);
		contentPane.add(lblSalud);

		JLabel lblFuerza = new JLabel("Fuerza");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setBounds(FUERZAX, FUERZAY, FUERZAW, FUERZAZ);
		contentPane.add(lblFuerza);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setBounds(DESTREZAX, DESTREZAY, DESTREZAW, DESTREZAZ);
		contentPane.add(lblDestreza);

		JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setBounds(INTELIGENCIAX, INTELIGENCIAY, INTELIGENCIAW, INTELIGENCIAZ);
		contentPane.add(lblInteligencia);

		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setForeground(Color.WHITE);
		lblAtaque.setBounds(ATAQUEX, ATAQUEY, ATAQUEW, ATAQUEZ);
		contentPane.add(lblAtaque);

		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setForeground(Color.WHITE);
		lblDefensa.setBounds(DEFENSAX, DEFENSAY, DEFENSAW, DEFENSAZ);
		contentPane.add(lblDefensa);

		JLabel lblMagia = new JLabel("Magia");
		lblMagia.setForeground(Color.WHITE);
		lblMagia.setBounds(MAGIAX, MAGIAY, MAGIAW, MAGIAZ);
		contentPane.add(lblMagia);

		JLabel lblCantidadDeItems = new JLabel("Cantidad de Items");
		lblCantidadDeItems.setForeground(Color.WHITE);
		lblCantidadDeItems.setBounds(CANTIDADITEMSX, CANTIDADITEMSY, CANTIDADITEMSW, CANTIDADITEMSZ);
		contentPane.add(lblCantidadDeItems);

		JLabel nmbPj = new JLabel(paquetePersonaje.getNombre());
		nmbPj.setForeground(Color.WHITE);
		nmbPj.setHorizontalAlignment(SwingConstants.RIGHT);
		nmbPj.setBounds(PJX, NMBPJY, PJW, PJZ);
		contentPane.add(nmbPj);

		JLabel cstPj = new JLabel(paquetePersonaje.getCasta());
		cstPj.setForeground(Color.WHITE);
		cstPj.setHorizontalAlignment(SwingConstants.RIGHT);
		cstPj.setBounds(PJX, CSTPJY, PJW, PJZ);
		contentPane.add(cstPj);

		JLabel rzPj = new JLabel(paquetePersonaje.getRaza());
		rzPj.setForeground(Color.WHITE);
		rzPj.setHorizontalAlignment(SwingConstants.RIGHT);
		rzPj.setBounds(PJX, RZPJY, PJW, PJZ);
		contentPane.add(rzPj);

		JLabel saludPj = new JLabel(String.valueOf(paquetePersonaje.getSaludTope()));
		saludPj.setForeground(Color.WHITE);
		saludPj.setHorizontalAlignment(SwingConstants.RIGHT);
		saludPj.setBounds(PJX, SALUDPJY, PJW, PJZ);
		contentPane.add(saludPj);

		JLabel fzaPj = new JLabel(String.valueOf(paquetePersonaje.getFuerza()));
		fzaPj.setForeground(Color.WHITE);
		fzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
		fzaPj.setBounds(PJX, FZAPJY, PJW, PJZ);
		contentPane.add(fzaPj);

		JLabel dstzaPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
		dstzaPj.setForeground(Color.WHITE);
		dstzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
		dstzaPj.setBounds(PJX, DSTRZAPJY, PJW, PJZ);
		contentPane.add(dstzaPj);

		JLabel intPj = new JLabel(String.valueOf(paquetePersonaje.getInteligencia()));
		intPj.setForeground(Color.WHITE);
		intPj.setHorizontalAlignment(SwingConstants.RIGHT);
		intPj.setBounds(PJX, INTPJY, PJW, PJZ);
		contentPane.add(intPj);

		JLabel cantItem = new JLabel(String.valueOf(paquetePersonaje.getCantItems()));
		cantItem.setForeground(Color.WHITE);
		cantItem.setHorizontalAlignment(SwingConstants.RIGHT);
		cantItem.setBounds(CANTITEMSX, CANTITEMSY, CANTITEMSW, CANTITEMSZ);
		contentPane.add(cantItem);

		JLabel lvPj = new JLabel(String.valueOf(paquetePersonaje.getNivel()));
		lvPj.setForeground(Color.WHITE);
		lvPj.setHorizontalAlignment(SwingConstants.RIGHT);
		lvPj.setBounds(PjX, LVPJY, PjW, PjZ);
		contentPane.add(lvPj);

		JLabel xpPj = new JLabel(String.valueOf(paquetePersonaje.getExperiencia()));
		xpPj.setForeground(Color.WHITE);
		xpPj.setHorizontalAlignment(SwingConstants.RIGHT);
		xpPj.setBounds(PjX, XPPJY, PjW, PjZ);
		contentPane.add(xpPj);

		JLabel energiaPj = new JLabel(String.valueOf(paquetePersonaje.getEnergiaTope()));
		energiaPj.setForeground(Color.WHITE);
		energiaPj.setHorizontalAlignment(SwingConstants.RIGHT);
		energiaPj.setBounds(PjX, ENERGIAPJY, PjW, PjZ);
		contentPane.add(energiaPj);

		int ataquePj = calcularAtaque(paquetePersonaje.getFuerza());
		JLabel ataPj = new JLabel(String.valueOf(ataquePj));
		ataPj.setForeground(Color.WHITE);
		ataPj.setHorizontalAlignment(SwingConstants.RIGHT);
		ataPj.setBounds(PjX, ATAPJY, PjW, PjZ);
		contentPane.add(ataPj);

		JLabel defPj = new JLabel(String.valueOf(paquetePersonaje.getDestreza()));
		defPj.setForeground(Color.WHITE);
		defPj.setHorizontalAlignment(SwingConstants.RIGHT);
		defPj.setBounds(PjX, DEFPJY, PjW, PjZ);
		contentPane.add(defPj);

		int intePj = calcularMagia(paquetePersonaje.getInteligencia());
		JLabel magicPj = new JLabel(String.valueOf(intePj));
		magicPj.setForeground(Color.WHITE);
		magicPj.setHorizontalAlignment(SwingConstants.RIGHT);
		magicPj.setBounds(PjX, MAGICPJY, PjW, PjZ);
		contentPane.add(magicPj);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon("recursos//volver.png"));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla.menuStats = null;
				dispose();
			}
		});
		btnVolver.setBounds(VOLVERX, VOLVERY, VOLVERW, VOLVERZ);
		contentPane.add(btnVolver);
		JLabel background = new JLabel(new ImageIcon(imagenFondo.getScaledInstance(IMAGENX, IMAGENY, Image.SCALE_DEFAULT)));
		background.setBounds(BACKX, BACKY, BACKW, BACKZ);
		contentPane.add(background);
	}

	/**
	 * Calcula Magia
	 * 
	 * @param inteligencia
	 * @return Magia
	 */
	private int calcularMagia(final int inteligencia) {
		return (int) (inteligencia * mod);
	}

	/**
	 * Calcula Ataque
	 * 
	 * @param fuerza
	 * @return Ataque
	 */
	private int calcularAtaque(final int fuerza) {
		return (int) (fuerza * mod);
	}
}
