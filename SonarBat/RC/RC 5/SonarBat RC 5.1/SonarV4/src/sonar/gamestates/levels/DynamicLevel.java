package sonar.gamestates.levels;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class DynamicLevel extends Level
{
	/*The DynamicLevel class is a subclass of LevelR and what it is designed to
	 * do is load the level from a file. To do this we need a function called
	 * loadLevel. What the loadLevel does is taken in a file and transforms it
	 * into an image. It also initializes the tiles array and the width and
	 * height so that the Level has all the necessary parameters it needs to
	 * render the level and update accordingly. This class will be an abstract
	 * class as it will never need to be created at all since there will never
	 * be a new version of the DynamicLevel. 
	 * 
	 */
	DynamicLevel(LevelManager lm, String path)
	{
		setLm(lm);
		loadLevel(path);
	}
	
	private void loadLevel(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(Level.class.getResource(path));
			setWidth(image.getWidth());
			setHeight(image.getHeight());
			getDrawObject().setTiles(getWidth(), getHeight());
			image.getRGB(0, 0, getWidth(), getHeight(), getDrawObject().getTiles(), 0 , getWidth());
		}
		catch (Exception e){e.printStackTrace();}
	}
}