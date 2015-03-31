package entity;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet
{
	private PixelHolder phold; //Needed here
	public SpriteSheet(String path)
	{
		phold = new PixelHolder();
		load(path);
	}
	private void load(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			phold.getDimension().setWidth(width);
			phold.getDimension().setHeight(height);
			phold.getPixel().setPixels(phold.getDimension());
			image.getRGB(0, 0, width, height, phold.getPixel().getPixels(), 0, width);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	PixelHolder getPhold(){return phold;}
}

/*
public class SpriteSheet extends PixelHolder
{	
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
*/