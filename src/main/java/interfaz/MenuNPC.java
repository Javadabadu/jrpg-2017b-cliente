package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import juego.Pantalla;
import mensajeria.PaqueteNpc;
import  recursos.Recursos;

public class MenuNPC {

	private static final int anchoPersonaje = 128;
	private static final BufferedImage menu = Recursos.getMenuEnemigo();
	public static final int menuBatallar = 0;
	public static final int menuInformacion = 1;
	public static final int menuGanarBatalla = 2;
	public static final int menuPerderBatalla = 3;
	private static final String [] leyendaBoton = {"Batallar", "Volver", "Aceptar", "Aceptar"};

	private int x;
	private int y;
	private PaqueteNpc personajeNPC;

	public MenuNPC(int x, int y, PaqueteNpc personajeNPC){
		this.x = x;
		this.y = y;
		this.personajeNPC = personajeNPC;
	}

	public void graficar(Graphics g, int tipoMenu){

		// dibujo el menu
		g.drawImage(menu, x, y, null);

		// dibujo el personajeNPC
		g.drawImage(Recursos.personaje.get(personajeNPC.getType()).get(1)[1], x + menu.getWidth() / 2  - anchoPersonaje / 2, y + 70, 128, 128, null);

		// muestro el nombre
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", 1, 20));
		Pantalla.centerString(g, new Rectangle(x, y + 15, menu.getWidth(), 0), personajeNPC.getNombre());

		// Grafico la leyenda segun el tipo de menu
		switch(tipoMenu){
			case menuBatallar:
				graficarMenuInformacion(g);
				break;
			case menuInformacion:
				graficarMenuInformacion(g);
				break;
			case menuGanarBatalla:
				graficarMenuGanarBatalla(g);
				break;
			case menuPerderBatalla:
				graficarMenuPerderBatalla(g);
				break;
		}


		// muestro los botones
		g.setFont(new Font("Book Antiqua", 1, 20));
		g.drawImage(Recursos.getBotonMenu(), x + 50, y + 380, 200, 25, null);
		g.setColor(Color.WHITE);
		Pantalla.centerString(g, new Rectangle(x + 50, y + 380, 200, 25), leyendaBoton[tipoMenu]);
	}

	public void graficarMenuInformacion(Graphics g){

		// muestro los nombres de los atributos
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 210, menu.getWidth(), 0), personajeNPC.getType());
		g.drawString("Tipo: ", x + 30, y + 260);

		// muestro los atributos
		g.setFont(new Font("Book Antiqua", 0, 20));
		g.drawString(personajeNPC.getType(), x + 100, y + 260);
	}
	
	
	private void graficarMenuPerderBatalla(Graphics g) {
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), "¡Has sido derrotado!");

		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 250, menu.getWidth(), 0), "Te gano el NPC");
		Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0), "Porque resolviste todo en una clase");
		Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0), "Igual todavia tenes chances");
		Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0), "de promocionar o de ir a final");
		Pantalla.centerString(g, new Rectangle(x, y + 330, menu.getWidth(), 0), "Muscula, Never Pony");
		
		
	}
	
	private void graficarMenuGanarBatalla(Graphics g) {
		g.setColor(Color.BLACK);
		Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0), "¡Has sido derrotado!");

		g.setFont(new Font("Book Antiqua", 0, 14));
		Pantalla.centerString(g, new Rectangle(x, y + 250, menu.getWidth(), 0), "Te gano el NPC");
		Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0), "Porque resolviste todo en una clase");
		Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0), "Igual todavia tenes chances");
		Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0), "de promocionar o de ir a final");
		Pantalla.centerString(g, new Rectangle(x, y + 330, menu.getWidth(), 0), "Muscula, Never Pony");
		
		
	}
	
	public boolean clickEnBoton(int mouseX, int mouseY){
		if(mouseX >= x + 50 && mouseX <= x + 250 && mouseY >= y + 380 && mouseY <= y + 405)
			return true;
		return false;
	}

	public boolean clickEnCerrar(int mouseX, int mouseY){
		if(mouseX >= x + menu.getWidth() - 24 && mouseX <= x + menu.getWidth() + 4 && mouseY >= y + 12 && mouseY <= y + 36)
			return true;
		return false;
	}

	public boolean clickEnMenu(int mouseX, int mouseY){
		if(mouseX >= x && mouseX <= x + menu.getWidth() && mouseY >= y  && mouseY <= y + menu.getHeight())
			return true;
		return false;
	}
}
