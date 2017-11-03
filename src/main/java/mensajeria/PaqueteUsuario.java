package mensajeria;

import java.io.Serializable;
/**
 * @author Javadabadu
 */
public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

	private int idPj;
	private String username;
	private String password;
	private boolean inicioSesion;
	/**
	 * Constructor por defecto
	 */
	public PaqueteUsuario() {

	}
	/**
	 * Constructor parametrizado
	 */
	public PaqueteUsuario(final int pj, final String user, final String pw) {
		idPj = pj;
		username = user;
		password = pw;
		inicioSesion = false;
	}
	/**
	 * obtiene el id del pj
	 */
	public int getIdPj() {
		return idPj;
	}
	/**
	 * setea el id del pj
	 */
	public void setIdPj(final int idPj) {
		this.idPj = idPj;
	}
	/**
	 * obtiene el nombre de usuario
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * setea el nombre de usuario
	 */
	public void setUsername(final String username) {
		this.username = username;
	}
	/**
	 * obtiene la contraseña
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setea la contraseña
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
	/**
	 * obtiene inicioSesion
	 */
	public boolean isInicioSesion() {
		return inicioSesion;
	}
	/**
	 * setea inicioSesion
	 */
	public void setInicioSesion(final boolean inicioSesion) {
		this.inicioSesion = inicioSesion;
	}
	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
