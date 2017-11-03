package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import cliente.Cliente;
import inventario.Inventario;
import juego.Pantalla;
import mensajeria.Comando;
/**
 * @author Javadabadu
 */
public class MenuInventario extends JFrame {
	private JButton cancelar = new JButton("Exit");
	private static int x = 600;
	private static int y = 600;
	private static int width = 600;
	private static int height = 600;
	private static int locationX = 900;
	private static int locationY = 140;
	/**
	 * Constructor
	 */
    public MenuInventario(final Cliente cliente) {
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				try {
					Gson gson = new Gson();
					cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARINVENTARIO);
					cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al actualizar inventario");
				}
				Pantalla.menuInventario = null;
				dispose();
			}
		});
		this.setTitle("Inventario");
		this.setUndecorated(true);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			this.setLayout(new BorderLayout());
			this.add(new Inventario(cliente.getPaquetePersonaje()));
			this.add(cancelar, BorderLayout.AFTER_LAST_LINE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló al iniciar el inventario");

		}
		this.setBounds(x, y, width, height);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setLocation(locationX, locationY);
		this.setResizable(false);
		this.setVisible(true);
		}
}