package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

public class VentanaContactos extends JFrame{	

	private static final long serialVersionUID = 1L;
	private static final int F_ALTO = 273;
	private static final int F_ANCHO = 237;
	private static final int F_VALORX = 100;
	private static final int F_VALORY = 100;
	private static final int PANEL_BORDE = 5;
	private static final int SCROLL_ALTO = 188;
	private static final int SCROLL_ANCHO = 299;
	private static final int SCROLL_VALORX = 10;
	private static final int SCROLL_VALORY = 11;
	private static final int BOTONMC_ALTO = 23;
	private static final int BOTONMC_ANCHO = 89;
	private static final int BOTONMC_VALORX = 119;
	private static final int BOTONMC_VALORY = 208;
	private static final int BACK_ALTO = 254;
	private static final int BACK_ANCHO = 352;
	private static final int BACK_VALORX = -16;
	private static final int BACK_VALORY = 0;
	
	private JPanel contentPane;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private static JList<String> list = new JList<String>();
	private static JButton botonMc;
	private JLabel background;

	/**
	 * Create the frame.
	 */
	public VentanaContactos(final Juego juego){
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(F_VALORX, F_VALORY, F_ANCHO, F_ALTO);
		setLocationRelativeTo(null);
		setTitle("Usuarios");
		
		contentPane = new JPanel();
		contentPane.setBorder(
			new EmptyBorder(
				PANEL_BORDE,PANEL_BORDE,PANEL_BORDE, PANEL_BORDE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(
				SCROLL_VALORX, SCROLL_VALORY, SCROLL_ANCHO, SCROLL_ALTO);
		contentPane.add(scrollPane);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent arg0) {
				Pantalla.ventContac = null;
				dispose();
			}
		});
		
		botonMc = new JButton("Multichat");
		botonMc.setIcon(new ImageIcon("recursos//multichatButton.png"));
		botonMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelo.size() != 0) {
					if(!juego.getChatsActivos().containsKey("Sala")) {
						MiChat chat = new MiChat(juego);
						juego.getChatsActivos().put("Sala", chat);
						chat.setTitle("Sala");
						chat.setVisible(true);
						botonMc.setEnabled(false);
					}
				}
			}
		});
		botonMc.setBounds(
				BOTONMC_VALORX, BOTONMC_VALORY, BOTONMC_ANCHO, BOTONMC_ALTO);
		contentPane.add(botonMc);
		
		// Cargo la lista de contactos
		actualizarLista(juego);
		// Pregunto si la ventana sala esta abierta y cancelo el boton multichat
		if (juego.getChatsActivos().containsKey("Sala")) {
			botonMc.setEnabled(false);
		} else {
			botonMc.setEnabled(true);
		}
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					if(list.getSelectedValue() != null) {
						if(!juego.getChatsActivos().containsKey(list.getSelectedValue())) {
							if (juego.getCliente() != null) {
								MiChat chat = new MiChat(juego);
								juego.getChatsActivos().put(list.getSelectedValue(), chat);
								chat.setTitle(list.getSelectedValue());
								chat.setVisible(true);
							}	
						}
					}
				}
			}
		});


		list.setModel(modelo);
		scrollPane.setViewportView(list);
		
		background = new JLabel(new ImageIcon("recursos//background.jpg"));
		background.setBounds(
				BACK_VALORX,BACK_VALORY, BACK_ANCHO,BACK_ALTO);
		contentPane.add(background);
	}

	private void actualizarLista(final Juego juego) {
		if(juego.getCliente() != null) {
			synchronized (juego.getCliente()) {
				modelo.removeAllElements();
				if (juego.getPersonajesConectados() != null) {
					for (Map.Entry<Integer, PaquetePersonaje> personaje : juego.getPersonajesConectados().entrySet()) {
						modelo.addElement(personaje.getValue().getNombre());
					}
					modelo.removeElement(juego.getPersonaje().getNombre());
					list.setModel(modelo);
				}
			}
		}
	}
	
	public static JList<String> getList() {
		return list;
	}
	
	public static JButton getBotonMc() {
		return botonMc;
	}
}
