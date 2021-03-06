package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.NonPlayableCharacter;
import dominio.Personaje;
import dominio.NonPlayableCharacter;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

public class EstadoDeNpc {

	private static final int ANCHOBARRA = 122;
	private static final int ALTOSALUD = 14;
	private static final int ALTOMINIATURA = 64;
	private static final int ANCHOMINIATURA = 64;

	public static void dibujarEstadoDeNpc(Graphics g, int x, int y,
			NonPlayableCharacter npc, BufferedImage miniaturaPersonaje) {

		int drawBarra = 0;

		g.drawImage(Recursos.estadoPersonaje, x, y, null);

		g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA,
				ALTOMINIATURA, null);

		if (npc.getSalud() == npc.getSaludTope()) {
			drawBarra = ANCHOBARRA;

		} else {
			drawBarra = (npc.getSalud() * ANCHOBARRA)
					/ npc.getSaludTope();
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.drawImage(Recursos.barraSalud, x + 80, y + 26, drawBarra, ALTOSALUD,
				null);
		g.drawString(
				String.valueOf(npc.getSalud()) + " / "
						+ String.valueOf(npc.getSaludTope()), x + 132,
				y + 37);


	
		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(npc.getNivelNpc()), x + 59, y + 70);

	}

//	public static void dibujarEstadoDePersonaje(Graphics g, int x, int y,
//			PaquetePersonaje personaje, BufferedImage miniaturaPersonaje) {
//
//		int drawBarra = 0;
//
//		g.drawImage(Recursos.estadoPersonaje, x, y, null);
//
//		g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA,
//				ALTOMINIATURA, null);
//
//		g.setColor(Color.WHITE);
//		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		g.drawImage(Recursos.barraSalud, x + 80, y + 26, ANCHOBARRA, ALTOSALUD,
//				null);
//		g.drawString(
//				String.valueOf(personaje.getSaludTope()) + " / "
//						+ String.valueOf(personaje.getSaludTope()), x + 132,
//				y + 37);
//
//		g.drawImage(Recursos.barraEnergia, x + 80, y + 42, ANCHOBARRA,
//				ALTOENERGIA, null);
//		g.drawString(String.valueOf(personaje.getEnergiaTope()) + " / "
//				+ String.valueOf(personaje.getEnergiaTope()), x + 132, y + 52);
//
//		
//		g.setFont(new Font("Tahoma", Font.PLAIN, 8));
//		g.drawImage(Recursos.barraExperiencia, x + 77, y + 65, drawBarra,
//				ALTOEXPERIENCIA, null);
//		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		g.setColor(Color.GREEN);
//		g.drawString(String.valueOf(personaje.getNivel()), x + 59, y + 70);
//	}
//
//	public static void dibujarEstadoDePersonaje(Graphics g, int x, int y,
//			NonPlayableCharacter personajeNPC, BufferedImage miniaturaPersonaje) {
//
//		int drawBarra = 0;
//
//		g.drawImage(Recursos.estadoPersonaje, x, y, null);
//		g.drawImage(miniaturaPersonaje, x + 10, y + 9, ANCHOMINIATURA,
//				ALTOMINIATURA, null);
//		g.setColor(Color.WHITE);
//		g.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		g.drawImage(Recursos.barraSalud, x + 80, y + 26, ANCHOBARRA, ALTOSALUD,
//				null);
//		g.drawString(
//				String.valueOf(personajeNPC.getSalud()) + " / "
//						+ String.valueOf(personajeNPC.getSalud()), x + 132,
//				y + 37);
//
//	}
}
