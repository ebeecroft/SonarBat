package entity;

public class Sprite
{
	private int xw, yh;
	private PixelHolder phold; //Needed in Sprite, Spritesheet, and Screen
	private Colour color; //Can only exist here
	
	public Sprite(int size, int colour)
	{
		//Initialize
		color = new Colour();
		phold = new PixelHolder();
		
		//Basic holding
		phold.getDimension().setWidth(size);
		phold.getDimension().setHeight(size);
		phold.getPixel().setPixels(phold.getDimension());
		color.setSize(-1);
		setColour(size, colour);
	}
	
	public Sprite(int x, int y, int width, int height, SpriteSheet sheet, int... colour)
	{
		//Initialize
		color = new Colour();
		phold = new PixelHolder();
		
		//Basic holding
		phold.getDimension().setWidth(width);
		phold.getDimension().setHeight(height);
		phold.getPixel().setPixels(phold.getDimension());
		color.setColourize(colour);
		color.setSize(color.getColourize().length);
		xw = x * width;
		yh = y * height;
		load(width, height, xw, yh, sheet);
	}
	
	private void load(int width, int height, int xw, int yh, SpriteSheet sheet)
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				phold.getPixel().getPixels()[x + y * width] = sheet.getPhold().getPixel().getPixels()[(x + xw) + (y + yh) * sheet.getPhold().getDimension().getWidth()];
			}
		}
	}
	
	private void setColour(int size, int colour)
	{
		for(int i = 0; i < size * size; i++)
		{
			phold.getPixel().getPixels()[i] = colour;
		}
	}
	
	public PixelHolder getPhold(){return phold;}
	public Colour getColor(){return color;}
}