package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * Menu Asignar Skills.
 */
public class MenuAsignarSkills extends JFrame {
	private static final int VALORINICIALCERO = 0;
	private static final int MULTIPLICADORPUNTOS = 3;
	private static final int BONUSINICIAL = 0;
	private static final int MAXIMOSKILL = 200;
	private static final int BX = 100;
	private static final int BY = 100;
	private static final int BW = 450;
	private static final int BZ = 300;
	private static final int EMPTYBORDER = 0;
	private static final int BORDER = 0;
	private static final int ASIGNARX = 100;
	private static final int ASIGNARY = 100;
	private static final int ASIGNARW = 298;
	private static final int ASIGNARZ = 294;
	private static final int SKILLX = 50;
	private static final int SKILLW = 56;
	private static final int SKILLZ = 16;
	private static final int SKILLFY = 101;
	private static final int SKILLDY = 159;
	private static final int SKILLIY = 217;
	private static final int PUNTOSX = 39;
	private static final int PUNTOSY = 41;
	private static final int PUNTOSW = 83;
	private static final int PUNTOSZ = 26;
	private static final int CANTPUNTOSX = 12;
	private static final int CANTPUNTOSY = 13;
	private static final int CANTPUNTOSW = 177;
	private static final int CANTPUNTOSZ = 29;
	private static final int INTELIGENCIAX = 39;
	private static final int INTELIGENCIAY = 188;
	private static final int INTELIGENCIAW = 83;
	private static final int INTELIGENCIAZ = 16;
	private static final int DESTREZAX = 50;
	private static final int DESTREZAY = 130;
	private static final int DESTREZAW = 56;
	private static final int DESTREZAZ = 16;
	private static final int FUERZAX = 50;
	private static final int FUERZAY = 130;
	private static final int FUERZAW = 56;
	private static final int FUERZAZ = 16;
	private static final int CONFIRMX = 176;
	private static final int CONFIRMY = 140;
	private static final int CONFIRMW = 97;
	private static final int CONFIRMZ = 25;
	private static final int CANCELX = 176;
	private static final int CANCELY = 182;
	private static final int CANCELW = 97;
	private static final int CANCELZ = 25;
	private static final int MINUSX = 12;
	private static final int MINUSW = 34;
	private static final int MINUSZ = 25;
	private static final int MINUSY = 92;
	private static final int MINUS1Y = 159;
	private static final int MINUS2Y = 217;
	private static final int MOREX = 118;
	private static final int MOREW = 34;
	private static final int MOREZ = 25;
	private static final int MOREY = 92;
	private static final int MORE1Y = 159;
	private static final int MORE2Y = 217;
	private static final int RESETX = 176;
	private static final int RESETY = 98;
	private static final int RESETW = 97;
	private static final int RESETZ = 25;
	private static final int IMAGEX = 0;
	private static final int IMAGEY = 0;
	private static final int IMAGEW = 298;
	private static final int IMAGEZ = 294;

	private JPanel contentPane;
	private int puntosAsignarInicial = VALORINICIALCERO;
	private int puntosFuerzaInicial = VALORINICIALCERO;
	private int puntosDestrezaInicial = VALORINICIALCERO;
	private int puntosInteligenciaInicial = VALORINICIALCERO;
	private int puntosAsignar = puntosAsignarInicial;
	private int puntosFuerza = puntosFuerzaInicial;
	private int puntosDestreza = puntosDestrezaInicial;
	private int puntosInteligencia = puntosInteligenciaInicial;
	private int puntosDelNivel = VALORINICIALCERO;
	private final Gson gson = new Gson();

	/**
	 * Create the frame.
	 * 
	 * @param Cliente
	 *            (jugador)
	 */
	public MenuAsignarSkills(final Cliente cliente) {
		puntosDelNivel = (cliente.getPaquetePersonaje().getNivel()) * MULTIPLICADORPUNTOS;
		puntosAsignarInicial = cliente.getPaquetePersonaje().getPuntosAsignar();
		puntosFuerzaInicial = cliente.getPaquetePersonaje().getFuerza();
		puntosDestrezaInicial = cliente.getPaquetePersonaje().getDestreza();
		puntosInteligenciaInicial = cliente.getPaquetePersonaje().getInteligencia();
		puntosAsignar = puntosAsignarInicial;
		puntosFuerza = puntosFuerzaInicial;
		puntosDestreza = puntosDestrezaInicial;
		puntosInteligencia = puntosInteligenciaInicial;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(BX, BY, BW, BZ);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(EMPTYBORDER, EMPTYBORDER, EMPTYBORDER, EMPTYBORDER));
		contentPane.setLayout(new BorderLayout(BORDER, BORDER));
		setContentPane(contentPane);

		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
		setTitle("Asignar");
		setBounds(ASIGNARX, ASIGNARY, ASIGNARW, ASIGNARZ);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setLocationRelativeTo(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Pantalla.menuAsignar = null;
				dispose();
			}
		});

		final JLabel labelFuerza = new JLabel("");
		labelFuerza.setForeground(Color.WHITE);
		labelFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		labelFuerza.setBounds(SKILLX, SKILLFY, SKILLW, SKILLZ);
		labelFuerza.setText(String.valueOf(puntosFuerzaInicial));
		contentPane.add(labelFuerza);

		final JLabel labelDestreza = new JLabel("");
		labelDestreza.setForeground(Color.WHITE);
		labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		labelDestreza.setBounds(SKILLX, SKILLDY, SKILLW, SKILLZ);
		labelDestreza.setText(String.valueOf(puntosDestrezaInicial));
		contentPane.add(labelDestreza);

		final JLabel labelInteligencia = new JLabel("");
		labelInteligencia.setForeground(Color.WHITE);
		labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		labelInteligencia.setBounds(SKILLX, SKILLIY, SKILLW, SKILLZ);
		labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));
		contentPane.add(labelInteligencia);

		final JLabel labelPuntos = new JLabel("");
		labelPuntos.setForeground(Color.WHITE);
		labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntos.setBounds(PUNTOSX, PUNTOSY, PUNTOSW, PUNTOSZ);
		labelPuntos.setText(String.valueOf(puntosAsignarInicial));
		contentPane.add(labelPuntos);

		final JLabel lblCantidadDePuntos = new JLabel("Cantidad de Puntos a Asignar");
		lblCantidadDePuntos.setForeground(Color.WHITE);
		lblCantidadDePuntos.setBounds(CANTPUNTOSX, CANTPUNTOSY, CANTPUNTOSW, CANTPUNTOSZ);
		contentPane.add(lblCantidadDePuntos);

		final JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteligencia.setBounds(INTELIGENCIAX, INTELIGENCIAY, INTELIGENCIAW, INTELIGENCIAZ);
		contentPane.add(lblInteligencia);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestreza.setBounds(DESTREZAX, DESTREZAY, DESTREZAW, DESTREZAZ);
		contentPane.add(lblDestreza);

		final JLabel lblFuerza = new JLabel("Fuerza");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuerza.setBounds(FUERZAX, FUERZAY, FUERZAW, FUERZAZ);
		contentPane.add(lblFuerza);

		final JButton buttonConfirm = new JButton("Confirmar");
		ImageIcon iconoConfirm = new ImageIcon("recursos//botonConfirmar.png");
		buttonConfirm.setIcon(iconoConfirm);
		buttonConfirm.setEnabled(false);
		buttonConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntosAsignarInicial = puntosAsignar;
				int bonusF = puntosFuerza - puntosFuerzaInicial;
				int bonusD = puntosDestreza - puntosDestrezaInicial;
				int bonusI = puntosInteligencia - puntosInteligenciaInicial;
				cliente.getPaquetePersonaje().useBonus(BONUSINICIAL, BONUSINICIAL, bonusF, bonusD, bonusI);
				cliente.getPaquetePersonaje().removerBonus();
				cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARPERSONAJELV);
				try {
					cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al actualizar stats");

				}
				JOptionPane.showMessageDialog(null, "Se han actualizado tus atributos.");
				Pantalla.menuAsignar = null;
				dispose();
			}
		});
		buttonConfirm.setBounds(CONFIRMX, CONFIRMY, CONFIRMW, CONFIRMZ);
		contentPane.add(buttonConfirm);

		final JButton buttonCancel = new JButton("Cancelar");
		ImageIcon iconoC = new ImageIcon("recursos//botonCancelar.png");
		buttonCancel.setIcon(iconoC);
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantalla.menuAsignar = null;
				dispose();
			}
		});
		buttonCancel.setBounds(CANCELX, CANCELY, CANCELW, CANCELZ);
		contentPane.add(buttonCancel);

		final JButton buttonReset = new JButton("Reset");
		ImageIcon resetIcon = new ImageIcon("recursos//botonReset.png");
		buttonReset.setIcon(resetIcon);
		if (puntosAsignar == puntosDelNivel) {
			buttonReset.setEnabled(false);
		} else {
			buttonReset.setEnabled(true);
		}

		final JButton buttonMinus = new JButton("");
		final JButton buttonMinus1 = new JButton("");
		final JButton buttonMinus2 = new JButton("");
		final JButton buttonMore = new JButton("");
		final JButton buttonMore1 = new JButton("");
		final JButton buttonMore2 = new JButton("");
		buttonMinus.setEnabled(false);
		buttonMinus1.setEnabled(false);
		buttonMinus2.setEnabled(false);

		ImageIcon icono1 = new ImageIcon("recursos//botonMenoss.png");
		buttonMinus.setIcon(icono1);
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosFuerza > puntosFuerzaInicial) {
					puntosFuerza--;
					if (puntosAsignar == VALORINICIALCERO) {
						if (puntosInteligencia != MAXIMOSKILL) {
							buttonMore2.setEnabled(true);
						}
						if (puntosDestreza != MAXIMOSKILL) {
							buttonMore1.setEnabled(true);
						}
					} else {
						buttonMore.setEnabled(true);
						buttonMore1.setEnabled(true);
						buttonMore2.setEnabled(true);
					}
					puntosAsignar++;
					if (puntosAsignar == puntosAsignarInicial) {
						buttonConfirm.setEnabled(false);
					}
					if (puntosAsignar == puntosDelNivel) {
						buttonReset.setEnabled(false);
					}
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelFuerza.setText(String.valueOf(puntosFuerza));
					if (puntosFuerza == puntosFuerzaInicial) {
						buttonMinus.setEnabled(false);
						buttonMore.setEnabled(true);
					} else if (puntosFuerza >= puntosFuerzaInicial) {
						buttonMore.setEnabled(true);
					}
				}
			}
		});
		buttonMinus.setBounds(MINUSX, MINUSY, MINUSW, MINUSZ);
		contentPane.add(buttonMinus);

		buttonMinus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosDestreza > puntosDestrezaInicial) {
					puntosDestreza--;
					if (puntosAsignar == VALORINICIALCERO) {
						if (puntosInteligencia != MAXIMOSKILL) {
							buttonMore2.setEnabled(true);
						}
						if (puntosFuerza != MAXIMOSKILL) {
							buttonMore.setEnabled(true);
						}
					} else {
						buttonMore.setEnabled(true);
						buttonMore1.setEnabled(true);
						buttonMore2.setEnabled(true);
					}
					puntosAsignar++;
					if (puntosAsignar == puntosAsignarInicial) {
						buttonConfirm.setEnabled(false);
					}
					if (puntosAsignar == puntosDelNivel) {
						buttonReset.setEnabled(false);
					}
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelDestreza.setText(String.valueOf(puntosDestreza));
					if (puntosDestreza == puntosDestrezaInicial) {
						buttonMinus1.setEnabled(false);
						buttonMore1.setEnabled(true);
					} else if (puntosDestreza >= puntosDestrezaInicial) {
						buttonMore1.setEnabled(true);
					}
				}
			}
		});
		buttonMinus1.setIcon(icono1);
		buttonMinus1.setBounds(MINUSX, MINUS1Y, MINUSW, MINUSZ);
		contentPane.add(buttonMinus1);

		buttonMinus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosInteligencia > puntosInteligenciaInicial) {
					puntosInteligencia--;
					if (puntosAsignar == VALORINICIALCERO) {
						if (puntosFuerza != MAXIMOSKILL) {
							buttonMore.setEnabled(true);
						}
						if (puntosDestreza != MAXIMOSKILL) {
							buttonMore1.setEnabled(true);
						}
					} else {
						buttonMore.setEnabled(true);
						buttonMore1.setEnabled(true);
						buttonMore2.setEnabled(true);
					}
					puntosAsignar++;
					if (puntosAsignar == puntosAsignarInicial) {
						buttonConfirm.setEnabled(false);
					}
					if (puntosAsignar == puntosDelNivel) {
						buttonReset.setEnabled(false);
					}
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelInteligencia.setText(String.valueOf(puntosInteligencia));
					if (puntosInteligencia == puntosInteligenciaInicial) {
						buttonMinus2.setEnabled(false);
						buttonMore2.setEnabled(true);
					} else if (puntosInteligencia >= puntosInteligenciaInicial) {
						buttonMore2.setEnabled(true);
					}
				}
			}
		});
		buttonMinus2.setIcon(icono1);
		buttonMinus2.setBounds(MINUSX, MINUS2Y, MINUSW, MINUSZ);
		contentPane.add(buttonMinus2);

		buttonMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != VALORINICIALCERO && !labelFuerza.getText().equals("200")) {
					puntosFuerza++;
					puntosAsignar--;
					buttonConfirm.setEnabled(true);
					buttonReset.setEnabled(true);
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelFuerza.setText(String.valueOf(puntosFuerza));
					buttonMinus.setEnabled(true);
					if (puntosAsignar == VALORINICIALCERO) {
						buttonMore.setEnabled(false);
						buttonMore1.setEnabled(false);
						buttonMore2.setEnabled(false);
					}
				}
				if (puntosAsignar == VALORINICIALCERO || labelFuerza.getText().equals("200")) {
					buttonMore.setEnabled(false);
				}
			}
		});
		ImageIcon icono2 = new ImageIcon("recursos//botonMass.png");
		buttonMore.setIcon(icono2);
		buttonMore.setBounds(MOREX, MOREY, MOREW, MOREZ);
		contentPane.add(buttonMore);

		buttonMore1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != VALORINICIALCERO && !labelDestreza.getText().equals("200")) {
					puntosDestreza++;
					puntosAsignar--;
					buttonConfirm.setEnabled(true);
					buttonReset.setEnabled(true);
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelDestreza.setText(String.valueOf(puntosDestreza));
					buttonMinus1.setEnabled(true);
					if (puntosAsignar == VALORINICIALCERO) {
						buttonMore.setEnabled(false);
						buttonMore1.setEnabled(false);
						buttonMore2.setEnabled(false);
					}
					if (puntosAsignar == VALORINICIALCERO || labelDestreza.getText().equals("200")) {
						buttonMore1.setEnabled(false);
					}
				}
			}
		});
		buttonMore1.setIcon(icono2);
		buttonMore1.setBounds(MOREX, MORE1Y, MOREW, MOREZ);
		contentPane.add(buttonMore1);

		buttonMore2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != VALORINICIALCERO && !labelInteligencia.getText().equals("200")) {
					puntosInteligencia++;
					puntosAsignar--;
					buttonConfirm.setEnabled(true);
					buttonReset.setEnabled(true);
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelInteligencia.setText(String.valueOf(puntosInteligencia));
					buttonMinus2.setEnabled(true);
					if (puntosAsignar == VALORINICIALCERO) {
						buttonMore.setEnabled(false);
						buttonMore1.setEnabled(false);
						buttonMore2.setEnabled(false);
					}
					if (puntosAsignar == VALORINICIALCERO || labelInteligencia.getText().equals("200")) {
						buttonMore2.setEnabled(false);
					}
				}
			}
		});
		buttonMore2.setIcon(icono2);
		buttonMore2.setBounds(MOREX, MORE2Y, MOREW, MOREZ);
		contentPane.add(buttonMore2);

		// Boton Reset Skills
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Valores iniciales a usar
				puntosAsignar = puntosDelNivel; // Multiplico por 3 ya que
												// obtiene 3 puntos por nivel
				puntosFuerza = cliente.getPaquetePersonaje().getFuerzaInicial();
				puntosDestreza = cliente.getPaquetePersonaje().getDestrezaInicial();
				puntosInteligencia = cliente.getPaquetePersonaje().getInteligenciaInicial();
				puntosFuerzaInicial = puntosFuerza;
				puntosDestrezaInicial = puntosDestreza;
				puntosInteligenciaInicial = puntosInteligencia;

				labelPuntos.setText(String.valueOf(puntosAsignar));
				labelFuerza.setText(String.valueOf(puntosFuerza));
				labelDestreza.setText(String.valueOf(puntosDestreza));
				labelInteligencia.setText(String.valueOf(puntosInteligencia));

				// Si se usa el boton reiniciar, se pone en false los menos
				buttonConfirm.setEnabled(true);
				buttonReset.setEnabled(false);
				buttonMinus.setEnabled(false);
				buttonMinus1.setEnabled(false);
				buttonMinus2.setEnabled(false);

				JOptionPane.showMessageDialog(null, "Se han reseteado tus stats.");
			}
		});
		buttonReset.setBounds(RESETX, RESETY, RESETW, RESETZ);
		contentPane.add(buttonReset);

		final JLabel imageLabel = new JLabel(new ImageIcon("recursos//background.jpg"));
		imageLabel.setBounds(IMAGEX, IMAGEY, IMAGEW, IMAGEZ);
		imageLabel.setVisible(true);
		contentPane.add(imageLabel);
	}
}
