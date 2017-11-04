package mensajeria;

import java.io.Serializable;
/**
 * @author Javadabadu
 */
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {
		private String userEmisor;
		private String userReceptor;
		private String msj;
		/**
		 * Constructor por defecto
		 */
		public PaqueteMensaje() {
		}
		/**
		 * obtiene el mensaje
		 */
		public String getMensaje() {
			return msj;
		}
		/**
		 * setea el mensaje
		 */
		public void setMensaje(final String mensaje) {
			this.msj = mensaje;
		}
		/**
		 * obtiene el usuario emisor
		 */
		public String getUserEmisor() {
			return userEmisor;
		}
		/**
		 * setea el usuario emisor
		 */
		public void setUserEmisor(final String idEmisor) {
			this.userEmisor = idEmisor;
		}
		/**
		 * obtiene el usuario receptor
		 */
		public String getUserReceptor() {
			return userReceptor;
		}
		/**
		 * Setea el usuario receptor
		 */
		public void setUserReceptor(final String idReceptor) {
			this.userReceptor = idReceptor;
		}
		/**
		 * clona el objeto
		 */
		public Object clone() {
			Object obj = null;
			obj = super.clone();
			return obj;
		}
}
