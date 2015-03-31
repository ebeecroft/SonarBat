package sonar.gamestates.levels.entities;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SpriteSheet extends PixelHolder
{
	/*The SpriteSheet class is a huge collection of individual sprites.
	 * They are loaded from a String path and then utilized by the
	 * sprite class to allow the correct sprite to be chosen at will.
	 * Every SpriteSheet holds a list of sprites of infinite size
	 * until they are read into a buffered image that gets the correct
	 * size accordingly and stores that size into a variable.
	 */
	public SpriteSheet(String path)
	{
		load(path);
	}
	
	private void load(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			initPixels(width, height);
			setWidth(width);
			image.getRGB(0, 0, width, height, getPixels(), 0, width);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}