package sonar.gamestates.levels.entities;

abstract class PixelHolder
{
	private int[] pixels;
	private int width, height;
	
	void initPixels(int width, int height){pixels = new int[width * height];}
	public int[] getPixels(){return pixels;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	void setHeight(int height){this.height = height;}
	void setWidth(int width){this.width = width;}
}