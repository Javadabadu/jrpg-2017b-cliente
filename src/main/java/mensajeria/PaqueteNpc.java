package mensajeria;

import com.sun.javafx.collections.MappingChange.Map;

import dominio.NonPlayableCharacter;

public class PaqueteNpc {

	private NonPlayableCharacter npc;
	private int id;
	private String type;
	private Map<Integer, PaqueteNpc> npcs;
	
	
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

	public Map<Integer, PaqueteNpc> getNpcs() {
		return npcs;
	}

	public void setNpcs(Map<Integer, PaqueteNpc> npcs) {
		this.npcs = npcs;
	}

	
	 @Override 
	 public Object clone() { 
		 Object obj = null; 
		 try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  return obj; 
	 } 
	
}
