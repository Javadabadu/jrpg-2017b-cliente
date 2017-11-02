package comandos;

import javax.swing.JOptionPane;

import mensajeria.PaquetePersonaje;
/**
 * 
 * @author Javadabadu se crea el personaje
 *
 */
public class CrearPersonaje extends ComandosCliente {

	@Override
	public void ejecutar() {
		JOptionPane.showMessageDialog(null, "Registro exitoso.");
		cliente.setPaquetePersonaje((PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class));
		cliente.getPaqueteUsuario().setInicioSesion(true);
	}

}
