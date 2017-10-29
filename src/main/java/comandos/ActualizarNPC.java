package comandos; 
 
import mensajeria.PaqueteDeNPC; 
 
public class ActualizarNPC extends ComandosEscucha { 
 
  @Override 
  public void ejecutar() { 
    PaqueteDeNPC paqueteNPC = (PaqueteDeNPC) gson.fromJson(cadenaLeida,PaqueteDeNPC.class); 
    juego.setNpcs(paqueteNPC.getPersonajesNPC()); 
  } 
 
} 