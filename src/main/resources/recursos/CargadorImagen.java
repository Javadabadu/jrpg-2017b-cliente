package recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 * 
 * @author UnlamPrograAvanzada
 * carga la imagen
 */
public class CargadorImagen {
	
	private CargadorImagen(){
	}
	public static BufferedImage cargarImagen(final String path) {
		try {
			/**
			 * @return se retorna la imagen 
			 */
			return  ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el archivo " + path);
		}
		return null;
	}
}
