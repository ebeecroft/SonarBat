package sonar.graphics;

abstract class PixelBox
{
	private int[] pixels;
	
	void initPixels(int width, int height)
	{
		pixels = new int[width * height];
	}
	
	public int[] getPixels()
	{
		return pixels;
	}
	
	void setPixels(int[] array2, int xw, int yh, int size, int x, int y, int width)
	{
		if(array2 == null) System.out.println("SpriteSheet or Sprite array2 is null");
		pixels[x + y * width] = array2[(x + xw) + (y + yh) * size];
	}
	
	void setPixels(int value, int i)
	{
		pixels[i] = value;
	}
}