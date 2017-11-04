package interfaz;

import dominio.Personaje;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import juego.Pantalla;
import recursos.Recursos;
/*
 * @author Javadabadu
 * Clase MenuBatalla
 */

public class MenuBatalla {

  private static final int X = 100;
  private static final int Y = 380;
  private static final int ANCHOBOTON = 40;
  private static final int BOTONX1 = 48;
  private static final int BOTONY2 = 72;
  private static final int BOTONX3 = 221;
  private static final int BOTONY4 = 146;
  private static final int BOTONX5 = 394;
  private static final int BOTONX6 = 95;
  private static final int BOTONY7 = 94;
  private static final int BOTONX8 = 268;
  private static final int BOTONY9 = 168;
  private static final int BOTONX10 = 442;
  private static final int [][] BOTONES = {{X + BOTONX1, Y + BOTONY2},
    {X + BOTONX1, Y + BOTONY4},{X + BOTONX3 , Y + BOTONY2},
    {X + BOTONX3 , Y + BOTONY4},{X + BOTONX5 , Y + BOTONY2},
    {X + BOTONX5 , Y + BOTONY4}};

  private boolean habilitado;
  private final Personaje personaje;
  /*
   * @author Javadabadu
   * Constructor MenuBatalla
  */
  
  public MenuBatalla(boolean habilitado, Personaje personaje) {
    this.habilitado = habilitado;
    this.personaje = personaje;
  }
  
  /**
    * @author Javadabadu
    *
    * Metodo graficar
  **/
  
  public void graficar(final Graphics g) {
    if (habilitado) {
      g.drawImage(Recursos.getMenuBatalla(), X, Y, null);
    } else {
      g.drawImage(Recursos.getMenuBatallaDeshabilitado(), X, Y, null);
    }
    // Dibujo los boones
    g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesRaza()[0]),
        BOTONES[0][0], BOTONES[0][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesRaza()[1]),
        BOTONES[1][0], BOTONES[1][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[0]),
        BOTONES[2][0], BOTONES[2][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[1]),
        BOTONES[3][0], BOTONES[3][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get(personaje.getHabilidadesCasta()[2]),
        BOTONES[4][0], BOTONES[4][1],
        ANCHOBOTON, ANCHOBOTON, null);
    g.drawImage(Recursos.getHabilidades().get("Ser Energizado"),
        BOTONES[5][0], BOTONES[5][1],
        ANCHOBOTON, ANCHOBOTON, null);
    // Dibujo las leyendas
    g.setFont(new Font("Book Antiqua", 1, 14));
    g.drawString(personaje.getHabilidadesRaza()[0],
        X + BOTONX6, Y + BOTONY7);
    g.drawString(personaje.getHabilidadesRaza()[1],
        X + BOTONX6, Y + BOTONY9);
    g.drawString(personaje.getHabilidadesCasta()[0],
        X + BOTONX8, Y + BOTONY7);
    g.drawString(personaje.getHabilidadesCasta()[1],
        X + BOTONX8, Y + BOTONY9);
    g.drawString(personaje.getHabilidadesCasta()[2],
        X + BOTONX10, Y + BOTONY7);
    g.drawString("Ser energizado",
        X + BOTONX10, Y + BOTONY9);
    // Dibujo el turno de quien es
    g.setColor(Color.WHITE);
    if (habilitado) {
      Pantalla.centerString(g, 
            new Rectangle(X, Y + 5, Recursos.getMenuBatalla().getWidth(), 20),
            "Mi Turno");
    } else {
      Pantalla.centerString(g,
            new Rectangle(X, Y + 5, Recursos.getMenuBatalla().getWidth(), 20),
            "Turno Rival");
    }
  }
  
  /**
    * @author Javadabadu
    *
    * Metodo getBotonClickeado
  **/
  
  public int getBotonClickeado(final int mouseX, final int mouseY) {
    if (!habilitado) {
      return 0;
    }
    for (int i = 0 ; i < BOTONES.length ; i++) {
      if (mouseX >= BOTONES[i][0] && mouseX <= BOTONES[i][0] + ANCHOBOTON
          && mouseY >= BOTONES[i][1] && mouseY <= BOTONES[i][1] + ANCHOBOTON) {
        return i + 1;
      }
    }
    return 0;
  }
  
  /**
    * @author Javadabadu
    * Metodo clickEnMenu
  **/
  
  public boolean clickEnMenu(final int mouseX, final int mouseY) {
    if (mouseX >= X && mouseX <= X + Recursos.getMenuBatalla().getWidth()
        && mouseY >= Y && mouseY <= Y + Recursos.getMenuBatalla().getHeight()) {
      return habilitado;
    }
    return false;
  }
  
  /**
   * @author Javadabadu
    * Metodo setHabilitado
  **/
  
  public void setHabilitado(final boolean b) {
    habilitado = b;
  }
}
