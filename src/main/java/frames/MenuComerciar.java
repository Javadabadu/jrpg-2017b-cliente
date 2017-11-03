package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.google.gson.Gson;
import cliente.Cliente;
import dominio.Item;
import mensajeria.Comando;

public class MenuComerciar extends JFrame {

  private JPanel contentPane;
  private DefaultListModel<String> misItems = new DefaultListModel<String>();
  private DefaultListModel<String> dar = new DefaultListModel<String>();
  private DefaultListModel<String> obtener = new DefaultListModel<String>();
  private int cantListos = 0;
  private JLabel cantListo;
  private Item item1;
  private int count = 0;
  private final Gson gson = new Gson();
  private int sizeItems;
  private JCheckBox chckbxListo;
  private JLabel leyenda;
  private static final int BACKGROUNDZ = 336;
  private static final int BACKGROUNDW = 628;
  private static final int BACKGROUNDY = 0;
  private static final int BACKGROUNDX = -12;
  private static final int CBOXZ = 25;
  private static final int CBOXW = 71;
  private static final int CBOXY = 123;
  private static final int CBOXX = 289;
  private static final int CANTLISTOX = 317;
  private static final int CANTLISTOY = 278;
  private static final int CANTLISTOW = 56;
  private static final int CANTLISTOZ = 16;
  private static final int BTNSACARX = 181;
  private static final int BTNSACARY = 131;
  private static final int BTNSACARW = 51;
  private static final int BTNSACARZ = 25;
  private static final int TAMMAXIMOITEM = 9;
  private static final int BTNAGREGARX = 181;
  private static final int BTNAGREGARY = 93;
  private static final int BTNAGREGARW = 51;
  private static final int BTNAGREGARZ = 25; 
  private static final int LEYENDAX = 12;
  private static final int LEYENDAY = 299;
  private static final int LEYENDAW = 282;
  private static final int LEYENDAZ = 16;
  private static final int INTENEMYX = 428;
  private static final int INTENEMYY = 263;
  private static final int INTENEMYW = 56;
  private static final int INTENEMYZ = 16;
  private static final int DESENEMYX = 536;
  private static final int DESENEMYY = 240;
  private static final int DESENEMYW = 56;
  private static final int DESENEMYZ = 16;
  private static final int FZAENEMYX = 536;
  private static final int FZAENEMYY = 217;
  private static final int FZAENEMYW = 56;
  private static final int FZAENEMYZ = 16;
  private static final int ENEENEMYX = 428;
  private static final int ENEENEMYY = 240;
  private static final int ENEENEMYW = 56;
  private static final int ENEENEMYZ = 16;
  private static final int SALENEMYX = 428;
  private static final int SALENEMYY = 217;
  private static final int SALENEMYW = 56;
  private static final int SALENEMYZ = 16;
  private static final int BONUSX = 51;
  private static final int BONUSY = 263;
  private static final int BONUSW = 56; 
  private static final int BONUSZ = 16;
  private static final int BONDESX = 176;
  private static final int BONDESY = 240;
  private static final int BONDESW = 56;
  private static final int BONDESZ = 16;
  private static final int BONFX = 176;
  private static final int BONFY = 217;
  private static final int BONFW = 56;
  private static final int BONFZ = 16;
  private static final int BONENX = 51;
  private static final int BONENY = 240;
  private static final int BONENW = 56; 
  private static final int BONENZ = 16;
  private static final int BONSALX = 51;
  private static final int BONSALY = 217;
  private static final int BONSALW = 56;
  private static final int BONSALZ = 16;
  private static final int LISTOX = 276;
  private static final int LISTOY = 279;
  private static final int LISTOW = 56;
  private static final int LISTOZ = 16;
  private static final int LBLINTENEMYX = 387;
  private static final int LBLINTENEMYY = 263;
  private static final int LBLINTENEMYW = 71;
  private static final int LBLINTENEMYZ = 16;
  private static final int LBLDESENEMYX = 497;
  private static final int LBLDESENEMYY = 240;
  private static final int LBLDESENEMYW = 56;
  private static final int LBLDESENEMYZ = 16;
  private static final int LBLFZAENEMYX = 497;
  private static final int LBLFZAENEMYY = 217;
  private static final int LBLFZAENEMYW = 56;
  private static final int LBLFZAENEMYZ = 16;
  private static final int LBLENEENEMYX = 387;
  private static final int LBLENEENEMYY = 240;
  private static final int LBLENEENEMYW = 56;
  private static final int LBLENEENEMYZ = 16;
  private static final int LBLSALENEMYX = 387;
  private static final int LBLSALENEMYY = 217;
  private static final int LBLSALENEMYW = 56;
  private static final int LBLSALENEMYZ = 16;
  private static final int LBLINTX = 12;
  private static final int LBLINTY = 263;
  private static final int LBLINTW = 71;
  private static final int LBLINTZ = 16;
  private static final int LBLDESX = 113;
  private static final int LBLDESY = 240;
  private static final int LBLDESW = 56;
  private static final int LBLDESZ = 16;
  private static final int LBLFUEX = 113;
  private static final int LBLFUEY = 217;
  private static final int LBLFUEW = 56;
  private static final int LBLFUEZ = 16;
  private static final int LBLENX = 12;
  private static final int LBLENY = 240;
  private static final int LBLENW = 56;
  private static final int LBLENZ = 16;
  private static final int LBLSALX = 12;
  private static final int LBLSALY = 217;
  private static final int LBLSALW = 56;
  private static final int LBLSALZ = 16;
  private static final int LBLITX = 428;
  private static final int LBLITY = 13;
  private static final int LBLITW = 157;
  private static final int LBLITZ = 16;
  private static final int INTERX = 244;
  private static final int INTERY = 13;
  private static final int INTERW = 157;
  private static final int INTERZ = 16;
  private static final int MISITX = 12;
  private static final int MISITY = 13;
  private static final int MISITW = 157;
  private static final int MISITZ = 16;
  private static final int OBTX = 428;
  private static final int OBTY = 42;
  private static final int OBTW = 157;
  private static final int OBTZ = 162;
  private static final int ADARX = 244;
  private static final int ADARY = 42;
  private static final int ADARW = 157;
  private static final int ADARZ = 162;
  private static final int LISTMIX = 12;
  private static final int LISTMIY = 42;
  private static final int LISTMIW = 157;
  private static final int LISTMIZ = 162;
  private static final int BOTONCANCELARX = 276;
  private static final int BOTONCANCELARY = 245;
  private static final int BOTONCANCELARW = 97;
  private static final int BOTONCANCELARZ = 25;
  private static final int PANE = 5;
  private static final int BX = 100;
  private static final int BY = 100;
  private static final int BW = 610;
  private static final int BZ = 363;
	/**
	 * @author javadabadu
	 * Create the frame.
	 */
	public MenuComerciar(final Cliente cliente) {
		this.setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds( BX, BY, BW, BZ);
		this.setLocationRelativeTo(null);
		this.setTitle("Comercio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(PANE, PANE,
				PANE, PANE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cliente.setM1(null);
				dispose();
			}
		});
		BufferedImage imagenFondo = null;
		try {
			imagenFondo = ImageIO.read(new File(
					"recursos//background.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo cargar el fondo");
		}
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("recursos//volver.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setM1(null);
				dispose();
			}
		});
		btnCancelar.setBounds( BOTONCANCELARX, BOTONCANCELARY,
				BOTONCANCELARW, BOTONCANCELARZ);
		contentPane.add(btnCancelar);
		final JList<String> listMisItems = new JList<String>();
		listMisItems.setBounds( LISTMIX, LISTMIY,
				LISTMIW, LISTMIZ);
		contentPane.add(listMisItems);
		final JList<String> listADar = new JList<String>();
		listADar.setBounds( ADARX, ADARY, ADARW, ADARZ);
		contentPane.add(listADar);
		final JList<String> listAObtener = new JList<String>();
		listAObtener.setBounds(OBTX, OBTY, OBTW, OBTZ);
		contentPane.add(listAObtener);
		final JLabel lblMisItems = new JLabel("Mis Items");
		lblMisItems.setForeground(Color.WHITE);
		lblMisItems.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblMisItems.setBounds(MISITX, MISITY,
				MISITW, MISITZ);
		contentPane.add(lblMisItems);
		final JLabel lblItemsAIntercambiar = new JLabel(
				"Items a Dar");
		lblItemsAIntercambiar.setForeground(Color.WHITE);
		lblItemsAIntercambiar.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblItemsAIntercambiar.setBounds(INTERX, INTERY,
				INTERW, INTERZ);
		contentPane.add(lblItemsAIntercambiar);
		final JLabel lblItemsAObtener = new JLabel(
				"Items a Obtener");
		lblItemsAObtener.setForeground(Color.WHITE);
		lblItemsAObtener.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblItemsAObtener.setBounds(LBLITX, LBLITY,
				LBLITW, LBLITZ);
		contentPane.add(lblItemsAObtener);
		final JLabel lblSalud = new JLabel("Salud");
		lblSalud.setForeground(Color.WHITE);
		lblSalud.setBounds(LBLSALX, LBLSALY, LBLSALW, LBLSALZ);
		contentPane.add(lblSalud);
		final JLabel lblEnerga = new JLabel("Energía");
		lblEnerga.setForeground(Color.WHITE);
		lblEnerga.setBounds(LBLENX, LBLENY, LBLENW, LBLENZ);
		contentPane.add(lblEnerga);
		final JLabel lblFuerza = new JLabel("Fuerza");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setBounds(LBLFUEX, LBLFUEY,
				LBLFUEW, LBLFUEZ);
		contentPane.add(lblFuerza);
		final JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setBounds(LBLDESX, LBLDESY,
				LBLDESW, LBLDESZ);
		contentPane.add(lblDestreza);
		final JLabel lblInteligencia = new JLabel(
				"Inteligencia");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setBounds(LBLINTX , LBLINTY,
				LBLINTW, LBLINTZ);
		contentPane.add(lblInteligencia);
		final JLabel lblSaludEnemy = new JLabel("Salud");
		lblSaludEnemy.setForeground(Color.WHITE);
		lblSaludEnemy.setBounds(LBLSALENEMYX, LBLSALENEMYY,
				LBLSALENEMYW, LBLSALENEMYZ);
		contentPane.add(lblSaludEnemy);
		final JLabel lblEnergiaEnemy = new JLabel("Energía");
		lblEnergiaEnemy.setForeground(Color.WHITE);
		lblEnergiaEnemy.setBounds(LBLENEENEMYX, LBLENEENEMYY,
				LBLENEENEMYW, LBLENEENEMYZ);
		contentPane.add(lblEnergiaEnemy);
		final JLabel lblFzaEnemy = new JLabel("Fuerza");
		lblFzaEnemy.setForeground(Color.WHITE);
		lblFzaEnemy.setBounds(LBLFZAENEMYX, LBLFZAENEMYY,
				LBLFZAENEMYW, LBLFZAENEMYZ);
		contentPane.add(lblFzaEnemy);
		final JLabel lblDesEnemy = new JLabel("Destreza");
		lblDesEnemy.setForeground(Color.WHITE);
		lblDesEnemy.setBounds(LBLDESENEMYX, LBLDESENEMYY,
				LBLDESENEMYW, LBLDESENEMYZ);
		contentPane.add(lblDesEnemy);
		final JLabel lblIntEnemy = new JLabel("Inteligencia");
		lblIntEnemy.setForeground(Color.WHITE);
		lblIntEnemy.setBounds(LBLINTENEMYX, LBLINTENEMYY,
				LBLINTENEMYW, LBLINTENEMYZ);
		contentPane.add(lblIntEnemy);
		final JLabel lblListo = new JLabel("Listo");
		lblListo.setForeground(Color.WHITE);
		lblListo.setBounds(LISTOX, LISTOY, LISTOW, LISTOZ);
		contentPane.add(lblListo);
		final JLabel  bonusSalud = new JLabel("");
		bonusSalud.setForeground(Color.WHITE);
		bonusSalud.setHorizontalAlignment(SwingConstants.RIGHT);
		bonusSalud.setBounds(BONSALX, BONSALY , BONSALW , BONSALZ);
		contentPane.add(bonusSalud);
		final JLabel bonusEnergia = new JLabel("");
		bonusEnergia.setForeground(Color.WHITE);
		bonusEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		bonusEnergia.setBounds(BONENX, BONENY, BONENW, BONENZ);
		contentPane.add(bonusEnergia);
		final JLabel bonusFuerza = new JLabel("");
		bonusFuerza.setForeground(Color.WHITE);
		bonusFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
		bonusFuerza.setBounds(BONFX, BONFY, BONFW , BONFZ);
		contentPane.add(bonusFuerza);
		final JLabel bonusDes = new JLabel("");
		bonusDes.setForeground(Color.WHITE);
		bonusDes.setHorizontalAlignment(SwingConstants.RIGHT);
		bonusDes.setBounds(BONDESX, BONDESY, BONDESW, BONDESZ);
		contentPane.add(bonusDes);
     	final JLabel bonusInt = new JLabel("");
		bonusInt.setForeground(Color.WHITE);
		bonusInt.setHorizontalAlignment(SwingConstants.RIGHT);
		bonusInt.setBounds(BONUSX, BONUSY, BONUSW, BONUSZ);
		contentPane.add(bonusInt);
		final JLabel saludEnemy = new JLabel("");
		saludEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		saludEnemy.setForeground(Color.WHITE);
		saludEnemy.setBounds(SALENEMYX, SALENEMYY, SALENEMYW, SALENEMYZ);
		contentPane.add(saludEnemy);
		final JLabel energyEnemy = new JLabel("");
		energyEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		energyEnemy.setForeground(Color.WHITE);
		energyEnemy.setBounds(ENEENEMYX, ENEENEMYY, ENEENEMYW, ENEENEMYZ);
		contentPane.add(energyEnemy);
		final JLabel fzaEnemy = new JLabel("");
		fzaEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		fzaEnemy.setForeground(Color.WHITE);
		fzaEnemy.setBounds(FZAENEMYX, FZAENEMYY, FZAENEMYW, FZAENEMYZ);
		contentPane.add(fzaEnemy);
		final JLabel desEnemy = new JLabel("");
		desEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		desEnemy.setForeground(Color.WHITE);
		desEnemy.setBounds(DESENEMYX, DESENEMYY, DESENEMYW, DESENEMYZ);
		contentPane.add(desEnemy);
		final JLabel intEnemy = new JLabel("");
		intEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
		intEnemy.setForeground(Color.WHITE);
		intEnemy.setBounds(INTENEMYX, INTENEMYY, INTENEMYW, INTENEMYZ);
		contentPane.add(intEnemy);
		chckbxListo = new JCheckBox("Listo");
		chckbxListo.setForeground(Color.WHITE);
		chckbxListo.setBackground(Color.BLACK);
		// Arranca deshabilitada
		chckbxListo.setEnabled(false);
		leyenda = new JLabel("Recuerda que la máxima cantidad de items es 9");
		leyenda.setForeground(Color.WHITE);
		leyenda.setBounds(LEYENDAX, LEYENDAY, LEYENDAW, LEYENDAZ);
		contentPane.add(leyenda);
		leyenda.setVisible(false);
		final JButton btnAgregar = new JButton("-->");
		btnAgregar.setIcon(new ImageIcon("recursos//flechaDer.png"));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				if (listMisItems.getSelectedValue() != null) {
					dar.addElement(listMisItems.getSelectedValue());
					if (obtener.size() != 0) {
						if (sizeItems - dar.size() + obtener.size() <= TAMMAXIMOITEM) {
							chckbxListo.setEnabled(true);
							leyenda.setVisible(false);
						}		
					}
					// Pongo el primer item y pregunto si es igual al seleccionado
					// Entonces mientras que sean distinto lo busca
					// Cuando sea igual sale del while y lo agrega en la lista
					item1 = cliente.getPaquetePersonaje().getItems().get(count);
					while (!item1.getNombre().equals(listMisItems.getSelectedValue())) {
						count++;
						item1 = cliente.getPaquetePersonaje().getItems().get(count);
					}
					count = 0;
					cliente.getPaqueteComercio().getItemsADar().add(item1);
					misItems.removeElement(listMisItems.getSelectedValue());
					cliente.getPaqueteComercio().setComando(
							Comando.ACTUALIZARCOMERCIO);
					try {
						cliente.getSalida().writeObject(
								gson.toJson(cliente.getPaqueteComercio()));
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null,
								"No se pudo actualizar comercio");
					}
					if (misItems.size() == 0) {
						bonusSalud.setText("");
						bonusEnergia.setText("");
						bonusFuerza.setText("");
						bonusDes.setText("");
						bonusInt.setText("");
					}
				}
			}
		});
		btnAgregar.setBounds(BTNAGREGARX, BTNAGREGARY, BTNAGREGARW,BTNAGREGARZ);
		contentPane.add(btnAgregar);
		final JButton btnSacar = new JButton("<--");
		btnSacar.setIcon(new ImageIcon("recursos//flechaIzq.png"));
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				if (listADar.getSelectedValue() != null) {
					misItems.addElement(listADar.getSelectedValue());
					for (Item item : cliente.getPaquetePersonaje().getItems()) {
						if (item.getNombre().equals(listADar.getSelectedValue())) {
							cliente.getPaqueteComercio().getItemsADar(
									).remove(item);
						}
					}
					dar.removeElement(listADar.getSelectedValue());
					// Si saque el item y la lista no tiene nada deshabilito el check
					if (dar.size() == 0) {
						chckbxListo.setEnabled(false);
					}
					// Si los items en total es mayor a 9 no puedo comerciar
					if (sizeItems - dar.size() + obtener.size() > TAMMAXIMOITEM) {
						chckbxListo.setEnabled(false);
						leyenda.setVisible(true);
					}
					cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
					try {
						cliente.getSalida().writeObject(gson.toJson
								(cliente.getPaqueteComercio()));
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "No se pudo actualizar comercio");
					}
					// Cuando paso un item de ofertar a no ofertado muestro el que movi
					int i = misItems.size();
					if (i >= 1) {
						for (Item item : cliente.getPaquetePersonaje().getItems()) {
							if (misItems.getElementAt(i - 1).equals(item.getNombre())) {
								bonusSalud.setText("+ " + item.getBonusSalud());
								bonusEnergia.setText("+ " + item.getBonusEnergia());
								bonusFuerza.setText("+ " + item.getBonusFuerza());
								bonusDes.setText("+ " + item.getBonusDestreza());
								bonusInt.setText("+ " + item.getBonusInteligencia());
							}
						}
					}
				}
			}
		});
		btnSacar.setBounds(BTNSACARX, BTNSACARY, BTNSACARW, BTNSACARZ);
		contentPane.add(btnSacar);
		// List Listener para cargar stats del item mio clickeado
		listMisItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					if (listMisItems.getSelectedValue() != null) {
						for (Item item : cliente.getPaquetePersonaje().getItems()) {
							if (listMisItems.getSelectedValue().equals(item.getNombre())) {
								bonusSalud.setText("+ " + item.getBonusSalud());
								bonusEnergia.setText("+ " + item.getBonusEnergia());
								bonusFuerza.setText("+ " + item.getBonusFuerza());
								bonusDes.setText("+ " + item.getBonusDestreza());
								bonusInt.setText("+ " + item.getBonusInteligencia());
							}
						}
					}
				}
			}
		});
		// List Listener para cargar stats del item del enemigo clickeado
		listAObtener.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					if (obtener.size() != 0) {
						//cambiar la variable del for each a la lista que va a venir del otro pj
						for (Item item : cliente.getPaqueteComercio().getItemsAObtener()) {
							if (listAObtener.getSelectedValue().equals(item.getNombre())) {
								saludEnemy.setText("+ " + item.getBonusSalud());
								energyEnemy.setText("+ " + item.getBonusEnergia());
								fzaEnemy.setText("+ " + item.getBonusFuerza());
								desEnemy.setText("+ " + item.getBonusDestreza());
								intEnemy.setText("+ " + item.getBonusInteligencia());
							}
						}
					}
				}
			}
		});
		//CARGO MIS ITEMS
		for (Item item : cliente.getPaquetePersonaje().getItems()) {
			misItems.addElement(item.getNombre());
		}
		// Seteo la cantidad de mis items en mi mochila
		sizeItems = misItems.size();
		//Seteo de JList
		listMisItems.setModel(misItems);
		listADar.setModel(dar);
		listAObtener.setModel(obtener);
		cantListo = new JLabel("0/2");
		cantListo.setHorizontalAlignment(SwingConstants.RIGHT);
		cantListo.setForeground(Color.WHITE);
		cantListo.setBounds(CANTLISTOX, CANTLISTOY, CANTLISTOW, CANTLISTOZ);
		contentPane.add(cantListo);
		chckbxListo.addItemListener(new ItemListener() {
		public void itemStateChanged(final ItemEvent arg0) {
				if (chckbxListo.isSelected()) {
					// Si ya la persona con la que voy a comerciar esta en LISTO
						if (cantListos == 1) {
							cantListos++;
							// Primero actualizo el label de cant Listos
							cantListo.setText(cantListos + "/2");
							// Le envio al otro que toque listo
							//y
							//esta 2/2 listo para trueque
							cliente.getPaqueteComercio().aumentarListo();
							cliente.getPaqueteComercio().setComando(
									Comando.ACTUALIZARCOMERCIO);
							try {
								cliente.getSalida().writeObject(gson.toJson
										(cliente.getPaqueteComercio()));
							} catch (IOException e) {
								JOptionPane.showMessageDialog(null,
										"No se pudo actualizar comercio");
							}
							////////
							// Ahora le digo que haga el trueque
							cliente.getPaqueteComercio().setComando(Comando.TRUEQUE);
							// Le informo al otro que vamos a hacer el trueque
							try {
								cliente.getSalida().writeObject(gson.toJson
										(cliente.getPaqueteComercio()));
							} catch (IOException e) {
								JOptionPane.showMessageDialog(null,
										"No se pudo actualizar comercio");
							}
							JOptionPane.showMessageDialog(cliente.getM1(),
									"Se ha realizado con exito el comercio");
							dispose();
						} else {
							// Si todavía LISTO = 0, le informo al otro
							cantListos++;
							// Deshabilito los botones para que no pueda agregar nada
							btnAgregar.setEnabled(false);
							btnSacar.setEnabled(false);
							cliente.getPaqueteComercio().aumentarListo();
							cliente.getPaqueteComercio().setComando(
									Comando.ACTUALIZARCOMERCIO);
							//Tambien le tiene que avisar el LISTO al otro jugador
							try {
								cliente.getSalida().writeObject(gson.toJson
										(cliente.getPaqueteComercio()));
							} catch (IOException e) {
								JOptionPane.showMessageDialog(null,
										"No se pudo actualizar comercio");
							}
							cantListo.setText(cantListos + "/2");
						}
				  } else {
					// Si habia clickeado LISTO, pero lo desclickie entonces le digo 
					// que disminuya en el otro cliente
					if (cantListos != 2) {
						// Si no tenia nada en la lista no tengo que disminuir la cant
						// de listos
						cantListos--;
						cliente.getPaqueteComercio().disminuirListo();
						btnAgregar.setEnabled(true);
						btnSacar.setEnabled(true);
                        cliente.getPaqueteComercio().setComando(Comando.ACTUALIZARCOMERCIO);
						//Tambien le tiene que avisar el NO LISTO al otro jugador
						try {
							cliente.getSalida().writeObject(gson.toJson
									(cliente.getPaqueteComercio()));
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null,
									"No se pudo actualizar comercio"); // 456
						}
					    cantListo.setText (cantListos + "/2");
					}
				}
			}
		});
		
		chckbxListo.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxListo.setBounds(CBOXX,CBOXY,CBOXW,CBOXZ);
		contentPane.add(chckbxListo);

		final JLabel background = new JLabel(new ImageIcon
				(imagenFondo.getScaledInstance(610, 416, Image.SCALE_DEFAULT)));
		background.setBounds(BACKGROUNDX, BACKGROUNDY, BACKGROUNDW, BACKGROUNDZ);
		contentPane.add(background);
	}
	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getCantListos
	 */
	public int getCantListos() {
		return cantListos;
	}
	
	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo setCantListo
	 */
	public void setCantListos(final int cantListos) {
		this.cantListos = cantListos;
	}

	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getCantListo
	 */
	
	public JLabel getCantListo() {
		return cantListo;
	}
	
	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo setObtener
	 */

	public void setObtener(final DefaultListModel<String> obtener) {
		this.obtener = obtener;
	}

	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getObtener
	 */
	
	public DefaultListModel<String> getObtener() {
		return obtener;
	}

	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getDar
	 */
	
	public DefaultListModel<String> getDar() {
		return dar;
	}

	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getSizeItems
	 */
	public int getSizeItems() {
		return sizeItems;
	}

	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getChckbxListo
	 */
	public JCheckBox getChckbxListo() {
		return chckbxListo;
	}
	/**
	 * @Autor Javadabadu 
	 * 
	 * Metodo getLeyenda
	 */
	public JLabel getLeyenda() {
		return leyenda;
	}
}