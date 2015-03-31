package sonar.gamestates.levels.entities;

public class Sprite extends PixelHolder //extends PixelBox
{
	private int[] colourize;
	private int colourSize;
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet, int... colour)
	{
		int xw = x * width;
		int yh = y * height;
		commons(width, height);
		load(width, height, sheet, xw, yh);
		colourize = colour;
		colourSize = colour.length;
	}
	
	public Sprite(int size, int colour)
	{
		commons(size, size);
		setColour(colour, size);
		colourSize = -1;
	}
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet)
	{
		int xw = x * width;
		int yh = y * height;
		commons(width, height);
		load(width, height, sheet, xw, yh);
		colourSize = -1;
	}
	
	private void commons(int width, int height)
	{
		initPixels(width, height);
		setWidth(width);
		setHeight(height);
	}
	
	private void load(int width, int height, SpriteSheet sheet, int xw, int yh)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				getPixels()[x + y * width] = sheet.getPixels()[(x + xw) + (y + yh) * sheet.getWidth()];
			}
		}
	}
	
	private void setColour(int colour, int size)
	{
		if(getPixels() == null) System.out.println("Pixels array is null");
		//Sets the voidSprite colour
		for (int i = 0; i < size * size; i++)
		{
			getPixels()[i] = colour;
		}
	}
	
	public int[] getColourize()
	{
		return colourize;
	}
	
	public int getColourSize()
	{
		return colourSize;
	}
}