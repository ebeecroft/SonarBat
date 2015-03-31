package sonar.gamestates.levels.entities;

public class Sprite extends PixelHolder
{
	//private int width, height;
	private int xw, yh;
	private int[] colourize;
	private int size;
	
	public Sprite(int size, int colour)
	{
		setWidth(size);
		setHeight(size);
		initPixels(size, size);
		setColour(size, colour);
		size = -1;
	}
	
	private void setColour(int size, int colour)
	{
		for(int i = 0; i < size * size; i++)
		{
			getPixels()[i] = colour;
		}
	}
	
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet, int... colour)
	{
		setWidth(width);
		setHeight(height);
		xw = x * width;
		yh = y * height;
		initPixels(width, height);
		load(width, height, xw, yh, sheet);
		//colourize = new int[255];
		colourize = colour;
		size = colourize.length;
	}
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet)
	{
		setWidth(width);
		setHeight(height);
		xw = x * width;
		yh = y * height;
		initPixels(width, height);
		load(width, height, xw, yh, sheet);
		size = -1;
	}
	
	private void load(int width, int height, int xw, int yh, SpriteSheet sheet)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				getPixels()[x + y * width] = sheet.getPixels()[(x + xw) + (y + yh) * sheet.getWidth()];
			}
		}
	}
	
	public int[] getColourize(){return colourize;}
	public int getSize(){return size;}
}