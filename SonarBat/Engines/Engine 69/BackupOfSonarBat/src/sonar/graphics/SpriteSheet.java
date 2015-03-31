package sonar.graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SpriteSheet extends PixelBox
{
	private int size;
	public SpriteSheet(String path)
	{
		load(path);
	}
	
	private void load(String path)
	{
		BufferedImage image;
		int width = 0, height = 0;
		try
		{
			image = ImageIO.read(SpriteSheet.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			initPixels(width, height);
			size = width;
			image.getRGB(0, 0, width, height, getPixels(), 0, width);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	int getSize()
	{
		return size;
	}
}