package mensajeria;

import java.io.IOException;
import java.io.Serializable;

import dominio.NonPlayableCharacter;
import estados.Estado;

public class PaqueteNpc extends Paquete implements Serializable, Cloneable{
	
	public static final String LUCANEITOR = "Lucaneitor";
	public static final String LEONIDAS = "Leo-nidas";
	
	private NonPlayableCharacter npc;
	private int id;
	private String type;

	private int posX;
	private int posY;
	private int direccion;
	private int frame;
	
	private int estado;
	
	public  PaqueteNpc() throws IOException {
		estado = Estado.estadoOffline;
	}
	public PaqueteNpc(int id, String nombre, String tipo, int nivel, int dificultad, int posX, int posY, int estado, int direccion, int frame) {
		this.npc = new NonPlayableCharacter(nombre, nivel, dificultad);
		this.id = id;
		this.type = tipo;
		this.posX = posX;
		this.posY = posY;
		this.estado = estado;
		this.direccion = direccion;
		this.frame = frame;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.npc.getNombre();
	}

	public String getType() {
		return this.type;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

}
