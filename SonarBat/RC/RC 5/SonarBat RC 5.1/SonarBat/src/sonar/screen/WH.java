package sonar.screen;

abstract class WH
{
	private int width, height;
	WH(int width, int height)
	{
		this.width = width;
		this.height = height;
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