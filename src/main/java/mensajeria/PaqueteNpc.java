package mensajeria;

import dominio.NonPlayableCharacter;

public class PaqueteNpc {

	private NonPlayableCharacter npc;
	private int id;
	private String type;

	private int posX;
	private int posY;

	public PaqueteNpc(int id, String nombre, String tipo, int nivel, int dificultad, int posX, int posY) {
		this.npc = new NonPlayableCharacter(nombre, nivel, dificultad);
		this.id = id;
		this.type = tipo;
		this.posX = posX;
		this.posY = posY;
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

}
