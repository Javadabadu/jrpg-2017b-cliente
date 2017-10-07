package mensajeria;

import java.io.Serializable;
import java.util.Map;

public class PaqueteDeNPC extends Paquete implements Serializable, Cloneable{
	
	private Map<Integer, PaqueteNpc> personajesNPC;

	public PaqueteDeNPC() {

	}

	public PaqueteDeNPC(Map<Integer, PaqueteNpc> personajesNPC) {
		this.personajesNPC = personajesNPC;
	}

	public Map<Integer, PaqueteNpc> getPersonajesNPC() {
		return personajesNPC;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}