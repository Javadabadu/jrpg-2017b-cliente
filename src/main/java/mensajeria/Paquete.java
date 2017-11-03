package mensajeria;

import java.io.Serializable;

import javax.swing.JOptionPane;
/**
 * @author Javadabadu
 */
public class Paquete implements Serializable, Cloneable {

	private static String msjExito = "1";
	private static String msjFracaso = "0";
	private String mensaje;
	private String ip;
	private int comando;
	/**
	 * Constructor por defecto
	 */
	public Paquete() {

	}
	/**
	 * Constructor parametrizado
	 */
	public Paquete(final String mensaje, final String nick, final String ip, final int comando) {
		this.mensaje = mensaje;
		this.ip = ip;
		this.comando = comando;
	}
	/**
	 * Constructor sin ip
	 */
	public Paquete(final String mensaje, final int comando) {
		this.mensaje = mensaje;
		this.comando = comando;
	}
	/**
	 * Constructor con comando
	 */
	public Paquete(final int comando) {
		this.comando = comando;
	}
	/**
	 * setea el mensaje
	 */
	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * setea la ip
	 */
	public void setIp(final String ip) {
		this.ip = ip;
	}
	/**
	 * setea el comando
	 */
	public void setComando(final int comando) {
		this.comando = comando;
	}
	/**
	 * obtiene el mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * obtiene la ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * obtiene el comando
	 */
	public int getComando() {
		return comando;
	}
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException ex) {
			JOptionPane.showMessageDialog(null, "Error al clonar");
		}
		return obj;
	}
	/**
	 * obtiene el Comando
	 */
	public Comando getObjeto(final String nombrePaquete) {
		Comando c = null;
		try {
			
			c = (Comando) Class.forName(nombrePaquete + "." + Comando.CLASSNAMES[comando]).newInstance();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return c;
		}
		return c;
	}
	/**
	 * Obtiene el comandoSet
	 */
	public static Comando getObjetoSet(final String nombrePaquete, final int accion) {
		Comando c = null;
		try {
			
			c = (Comando) Class.forName(nombrePaquete + "." + Comando.CLASSNAMESBIS[accion]).newInstance();
		
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return c;
		}
		return c;
	}

	public static String getMsjExito() {
		return msjExito;
	}

	public static void setMsjExito(String msjExito) {
		Paquete.msjExito = msjExito;
	}

	public static String getMsjFracaso() {
		return msjFracaso;
	}

	public static void setMsjFracaso(String msjFracaso) {
		Paquete.msjFracaso = msjFracaso;
	}


}
