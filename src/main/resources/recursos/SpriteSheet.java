package recursos;

import java.awt.image.BufferedImage;
/**
 * @author Javadabadu
 */
public class SpriteSheet {
	private BufferedImage sprite;
	/**
	 * Constructor
	 */
	public SpriteSheet(final BufferedImage sprite) {
		this.sprite = sprite;
	}
	/**
	 * obtiene el Tile
	 */
	public BufferedImage getTile(final int x,final int y,final int ancho,final int alto) {
		return sprite.getSubimage(x, y, ancho, alto);
	}
}