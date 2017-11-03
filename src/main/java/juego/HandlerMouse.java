package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * @author Javadabadu
 * Metodo HandlerMouse
*/

public class HandlerMouse implements MouseListener {

	private int [] posMouse;
	private int [] posMouseRecorrido;
	private boolean nuevoRecorrido;
	private boolean nuevoClick;

	/*
	   * @author Javadabadu
	   * Constructor HandlerMouse
	*/

	public HandlerMouse() {
		posMouse = new int[2];
		posMouseRecorrido = new int[2];
	}

	@Override
	public void mouseClicked(final MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			posMouse[0] = e.getX();
			posMouse[1] = e.getY();
			nuevoClick = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			posMouseRecorrido[0] = e.getX();
			posMouseRecorrido[1] = e.getY();
			nuevoRecorrido = true;
		}
	}

	@Override
	public void mouseEntered(final MouseEvent arg0) {

	}

	@Override
	public void mouseExited(final MouseEvent arg0) {

	}

	@Override
	public void mousePressed(final MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(final MouseEvent arg0) {

	}

	/*
	   * @author Javadabadu
	   * metodo getPosMouse
	*/
	
	public int[] getPosMouse() {
		return posMouse;
	}
	
	/*
	   * @author Javadabadu
	   * metodo getPosMouseRecorrido
	*/

	public int[] getPosMouseRecorrido() {
		return posMouseRecorrido;
	}

	/*
	   * @author Javadabadu
	   * metodo getNuevoRecorrido
	*/
	
	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
	}
	  
	/*
	   * @author Javadabadu
	   * metodo getNuevoClick
	*/
	
	public void setNuevoRecorrido(final boolean b) {
		nuevoRecorrido = b;
	}

  /*
   * @author Javadabadu
   * metodo getNuevoClick
  */
	
	public boolean getNuevoClick() {
		return nuevoClick;
	}

	  /*
	   * @author Javadabadu
	   * Metodo setNuevoClick
	  */
	public void setNuevoClick(final boolean b) {
		nuevoClick = b;
	}
}
