package sonar.screen;

abstract class PixelDS extends WH
{
	private int[] pixels;
	PixelDS(int width, int height, String type)
	{
		super(width, height);
		if(type == "Screen") pixels = new int[width * height];
	}
	
	int[] getPixels()
	{
		return pixels;
	}
	
	void initPixels(int[] set)
	{
		pixels = set;
	}
	
	//Copies data from Sprite to the screen pixels Screen only
	void setPixels(int[] array2, int x, int y, int awidth, int xa, int ya, int width)
	{
		pixels[xa + ya * width] = array2[x + y * awidth];
	}
	
	void setPixels(int value, int x, int y, int width)
	{
		pixels[x + y * width] = value; 
	}
	
	//Only for single pixels
	void setPixels(int value, int i)
	{
		pixels[i] = value;
	}
	
	//Copies from one array to the other Display Only
	void setPixels(int[] array2, int i)
	{
		pixels[i] = array2[i];
	}
}