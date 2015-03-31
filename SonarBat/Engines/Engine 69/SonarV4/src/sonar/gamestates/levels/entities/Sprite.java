package sonar.gamestates.levels.entities;

public class Sprite
{
	/*The Sprite class is what we use to give images to our entities. Every entity
	 * needs some form of image to be displayed in order to be rendered. The
	 * colourize array is used for colouring a sprite if we read in a grayscale
	 * sprite. The reason for this if want to use one character for multiple
	 * enemies or if the creator can't decide on the colour the actual character
	 * needs to be. Most of the time this will only be used for mobs as they will
	 * be changed alot.
	 */
	private int xw, yh;
	private int[] colourize;
	private int size;
	private int width, height;
	private int[] pixels;
	
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
	
	//Getters and setters for use by other classes
	public int[] getColourize(){return colourize;}
	public int getSize(){return size;}
	public int getWidth(){return width;}
	public void setWidth(int width){this.width = width;}
	public int getHeight(){return height;}
	public void setHeight(int height){this.height = height;}
	public int[] getPixels(){return pixels;}
	public void initPixels(int width, int height){pixels = new int[width * height];}
}