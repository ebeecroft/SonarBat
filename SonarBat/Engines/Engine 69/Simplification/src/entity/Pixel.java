package entity;

public class Pixel
{
	private int[] pixels;
	public int[] getPixels(){return pixels;}
	void setPixels(Dimension dimension){pixels = new int[dimension.getWidth() * dimension.getHeight()];}
}