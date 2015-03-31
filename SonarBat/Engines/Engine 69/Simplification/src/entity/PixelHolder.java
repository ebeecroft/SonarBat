package entity;

public class PixelHolder
{
	private Dimension dimension; //All sprites, screens, and spritesSheets need a dimension
	private Pixel pixel;
	
	PixelHolder()
	{
		dimension = new Dimension();
		pixel = new Pixel();
	}
	public Pixel getPixel(){return pixel;}
	public Dimension getDimension(){return dimension;}
}