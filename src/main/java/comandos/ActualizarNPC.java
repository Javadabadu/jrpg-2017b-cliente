package comandos; 
 
import mensajeria.PaqueteDeNPC; 
 
public class ActualizarNPC extends ComandosEscucha { 
 
  @Override 
  public void ejecutar() { 
    PaqueteDeNPC paqueteNPC = (PaqueteDeNPC) getGson().fromJson(getCadenaLeida(),PaqueteDeNPC.class); 
    juego.setNpcs(paqueteNPC.getPersonajesNPC()); 
  } 
 
} 