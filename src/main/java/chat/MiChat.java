package chat;

import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

/**
 * @author UnlamPrograAvanzada contenedor que tendra el chat.
 */

public class MiChat extends JFrame  {

	private static final long serialVersionUID = 1L;
	private static final int F_ALTO = 300;
	private static final int F_ANCHO = 450;
	private static final int F_VALORX = 100;
	private static final int F_VALORY = 100;
	private static final int PANEL_BORDE = 5;
	private static final int SCROLL_ALTO = 201;
	private static final int SCROLL_ANCHO = 414;
	private static final int SCROLL_VALORX = 10;
	private static final int SCROLL_VALORY = 11;
	private static final int BACK_ALTO = 283;
	private static final int BACK_ANCHO = 480;
	private static final int BACK_VALORX = -20;
	private static final int BACK_VALORY = 0;
	private static final int BOTONENV_ALTO = 23;
	private static final int BOTONENV_ANCHO = 81;
	private static final int BOTONENV_VALORX = 225;
	private static final int BOTONENV_VALORY = 334;
	private static final int TEXTO_ALTO = 27;
	private static final int TEXTO_ANCHO = 314;
	private static final int TEXTO_VALORX = 10;
	private static final int TEXTO_VALORY = 223;
	private static final String TIT_SALA = "Sala";
	private JPanel contentPane;
	private JTextField texto;
	private JTextArea chat;
	private PaquetePersonaje paquetePersonaje;

	/**
	 * @param atributo
	 *            que tendra el juego actual.
	 * 
	 */
	private Juego juego;
	private final Gson gson = new Gson();
	private final JLabel background = new JLabel(new ImageIcon("recursos//background.jpg"));
	private DefaultCaret caret;

	public MiChat(final Juego juego) {
		this.juego = juego;
		setTitle("Mi Chat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(F_VALORX, F_VALORY, F_ANCHO, F_ALTO);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(PANEL_BORDE, PANEL_BORDE, PANEL_BORDE, PANEL_BORDE));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(SCROLL_VALORX, SCROLL_VALORY, SCROLL_ANCHO, SCROLL_ALTO);
		contentPane.add(scrollPane);

		chat = new JTextArea();
		chat.setEditable(false);
		scrollPane.setViewportView(chat);
		caret = (DefaultCaret) chat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		texto = new JTextField();
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				texto.requestFocus();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				if (getTitle() == TIT_SALA) {
					if (Pantalla.ventContac != null) {
						VentanaContactos.getBotonMc().setEnabled(true);
					}
				}
				juego.getChatsActivos().remove(getTitle());
			}
		});

		// SI TOCO ENTER
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensajeChat = texto.getText();
				switch(mensajeChat) {
					case "iddqd":
						try {
						texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
						
						paquetePersonaje = juego.getCliente().getPaquetePersonaje();

						if(paquetePersonaje.isModoDios()) {
							paquetePersonaje.setModoDios(false);
							chat.append("Me: " + mensajeChat  + "   (modo dios desactivado) " + "\n");
						}
						else {
							paquetePersonaje.setModoDios(true);
							chat.append("Me: " + mensajeChat  + "   (modo dios activado) " + "\n");	
						}
							
						
						paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
						juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "Error al aplicar truco");
						}
						break;
					case "noclip":
						try {
							texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
							
							paquetePersonaje = juego.getCliente().getPaquetePersonaje();
							
							if(paquetePersonaje.isModoNoclip()) {
								paquetePersonaje.setModoNoclip(false);
								chat.append("Me: " + mensajeChat  + "   (atravesar paredes desactivado) "+ "\n");	
							}
							else {
								paquetePersonaje.setModoNoclip(true);
								chat.append("Me: " + mensajeChat  + "   (atravesar paredes activado) "+ "\n");		
								}
							
							paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
							juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
							} catch (IOException e2) {
								JOptionPane.showMessageDialog(null, "Error al aplicar truco");
							}
						break;
					case "bigdaddy":
						try {
						texto.setText("");
						
						paquetePersonaje = juego.getCliente().getPaquetePersonaje();

						if(paquetePersonaje.isModoFuerte()) {
							paquetePersonaje.setModoFuerte(false);
							chat.append("Me: " + mensajeChat  + "   (bigdaddy desactivado) "+ "\n");
							paquetePersonaje.setFuerza(paquetePersonaje.getFuerza()/2);
						}else {
							paquetePersonaje.setModoFuerte(true);
							chat.append("Me: " + mensajeChat  + "   (bigdaddy activado) "+ "\n");
							paquetePersonaje.setFuerza(paquetePersonaje.getFuerza()*2);
						}
						paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
						juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "Error al aplicar truco");
						}
						break;
					case "tinydaddy":
						try {
						texto.setText("");
						
						paquetePersonaje = juego.getCliente().getPaquetePersonaje();

						if(paquetePersonaje.isModoFuerte()) {
							paquetePersonaje.setModoFuerte(false);
							chat.append("Me: " + mensajeChat  + "   (tinydaddy desactivado) "+ "\n");
							paquetePersonaje.setFuerza(paquetePersonaje.getFuerza()*2);
						}else {
							paquetePersonaje.setModoFuerte(true);
							chat.append("Me: " + mensajeChat  + "   (tinydaddy activado) "+ "\n");
							paquetePersonaje.setFuerza(paquetePersonaje.getFuerza()/2);
						}
						paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
						juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "Error al aplicar truco");
						}
						break;
					case "war aint what it used to be":
						try {
							texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
							
							paquetePersonaje = juego.getCliente().getPaquetePersonaje();

							if(paquetePersonaje.isModoInvisible()) {
								paquetePersonaje.setModoInvisible(false);
								chat.append("Me: " + mensajeChat  + "   (Modo Invisible desactivado) "+ "\n");
							}
							else {
								paquetePersonaje.setModoInvisible(true);
								chat.append("Me: " + mensajeChat  + "   (Modo Invisible activado) "+ "\n");
							}
								
							
							paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
							juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
							} catch (IOException e2) {
								JOptionPane.showMessageDialog(null, "Error al aplicar truco");
							}
						break;
					case "":
						System.out.println("No escribiste nada");
						break;
					default: 
							chat.append("Me: " + mensajeChat  + "\n");
							juego.getCliente().getPaqueteMensaje().setUserEmisor(juego.getPersonaje().getNombre());
							juego.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
							juego.getCliente().getPaqueteMensaje().setMensaje(mensajeChat);
							// MANDO EL COMANDO PARA QUE ENVIE EL MSJ
							juego.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
							// El user receptor en espacio indica que es para todos
							if (getTitle() == TIT_SALA) {
								juego.getCliente().getPaqueteMensaje().setUserReceptor(null);
							}
							try {
								juego.getCliente().getSalida().writeObject(gson.toJson(juego.getCliente().getPaqueteMensaje()));
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "Error al enviar mensaje");
							}
							texto.setText("");
						break;
				}
				texto.requestFocus();
			}
		});

		// SI TOCO ENVIAR
		JButton enviar = new JButton("ENVIAR");
		enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensajeChat = texto.getText();
				switch(mensajeChat) {
				case "iddqd":
					try {
					texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
					chat.append("Me: " + mensajeChat  + "   (modo dios) " + "\n");
					paquetePersonaje = juego.getCliente().getPaquetePersonaje();

					if(paquetePersonaje.isModoDios())
						paquetePersonaje.setModoDios(false);
					else
						paquetePersonaje.setModoDios(true);
					
					paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
					juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
					} catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "Error al aplicar truco");
					}
					break;
				case "noclip":
					try {
						texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
						chat.append("Me: " + mensajeChat  + "   (atravesar paredes) "+ "\n");
						paquetePersonaje = juego.getCliente().getPaquetePersonaje();

						if(paquetePersonaje.isModoNoclip())
							paquetePersonaje.setModoNoclip(false);
						else
							paquetePersonaje.setModoNoclip(true);
						
						paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
						juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "Error al aplicar truco");
						}
					break;
				case "bigdaddy":
					texto.setText("");
					chat.append("Me: " + mensajeChat  + " ( tiene 100% más de fuerza) " + "\n");
					juego.getPersonaje().setFuerza(juego.getPersonaje().getFuerza()*2);
					break;
				case "tinydaddy":
					texto.setText("");
					chat.append("Me: " + mensajeChat  + " ( tiene  50% menos de fuerza) " + "\n");
					juego.getPersonaje().setFuerza((int) (juego.getPersonaje().getFuerza()*1.5));
					break;
				case "war aint what it used to be":
					try {
						texto.setText(""); // PARA PONER EL RENGLON PARA ESCRIBIR EN BLANCO
						chat.append("Me: " + mensajeChat  + "   (Modo Invisible) "+ "\n");
						paquetePersonaje = juego.getCliente().getPaquetePersonaje();

						if(paquetePersonaje.isModoInvisible())
							paquetePersonaje.setModoInvisible(false);
						else
							paquetePersonaje.setModoInvisible(true);
						
						paquetePersonaje.setComando(Comando.ACTUALIZARCHEATS);
						juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
						} catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "Error al aplicar truco");
						}
					break;
				case "":
					System.out.println("No escribiste nada");
					break;
				default: 
						chat.append("Me: " + mensajeChat  + "\n");
						juego.getCliente().getPaqueteMensaje().setUserEmisor(juego.getPersonaje().getNombre());
						juego.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
						juego.getCliente().getPaqueteMensaje().setMensaje(mensajeChat);
						// MANDO EL COMANDO PARA QUE ENVIE EL MSJ
						juego.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
						// El user receptor en espacio indica que es para todos
						if (getTitle() == TIT_SALA) {
							juego.getCliente().getPaqueteMensaje().setUserReceptor(null);
						}
						try {
							juego.getCliente().getSalida().writeObject(gson.toJson(juego.getCliente().getPaqueteMensaje()));
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Error al enviar mensaje");
						}
						texto.setText("");
					break;
				}
				texto.requestFocus();
			}
		});
		enviar.setBounds(BOTONENV_VALORX, BOTONENV_VALORY, BOTONENV_ANCHO, BOTONENV_ALTO);

		contentPane.add(enviar);
		texto.setBounds(TEXTO_VALORX, TEXTO_VALORY, TEXTO_ANCHO, TEXTO_ALTO);
		contentPane.add(texto);
		texto.setColumns(10);
		background.setBounds(BACK_VALORX, BACK_VALORY, BACK_ANCHO, BACK_ALTO);
		contentPane.add(background);
	}

	public JTextArea getChat() {
		return chat;
	}

	public JTextField getTexto() {
		return texto;
	}
}
