package sonar.graphics;

public class Sprite extends PixelBox
{	
	private int width, height;
	
	public Sprite(int size, int colour)
	{
		this.height = size;
		this.width = size;
		initPixels(size, size);
		setColour(colour, size);
	}
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet)
	{
		this.width = width;
		this.height = height;
		int xw = x * width;
		int yh = y * height;
		initPixels(width, height);
		load(width, height, sheet, xw, yh);
	}
	
	private void load(int width, int height, SpriteSheet sheet, int xw, int yh)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				setPixels(sheet.getPixels(), xw, yh, sheet.getSize(), x, y, width);
			}
		}
	}
	
	private void setColour(int colour, int size)
	{
		//Sets the voidSprite colour
		for (int i = 0; i < size * size; i++)
		{
			setPixels(colour, i);
		}
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}