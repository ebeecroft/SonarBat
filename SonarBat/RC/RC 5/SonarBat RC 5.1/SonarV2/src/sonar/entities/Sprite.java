package sonar.entities;

public class Sprite extends PixelHolder //extends PixelBox
{	
	public Sprite(int size, int colour)
	{
		initPixels(size, size);
		setColour(colour, size);
		setWidth(size);
		setHeight(size);
	}
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet)
	{
		int xw = x * width;
		int yh = y * height;
		initPixels(width, height);
		setWidth(width);
		setHeight(height);
		load(width, height, sheet, xw, yh);
	}
	
	private void load(int width, int height, SpriteSheet sheet, int xw, int yh)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				//pixels[x + y * width] = array2[(x + xw) + (y + yh) * size];
				getPixels()[x + y * width] = sheet.getPixels()[(x + xw) + (y + yh) * sheet.getWidth()];
			}
		}
	}
	
	private void setColour(int colour, int size)
	{
		//Sets the voidSprite colour
		for (int i = 0; i < size * size; i++)
		{
			getPixels()[i] = colour; //setPixels(colour, i);
		}
	}
}