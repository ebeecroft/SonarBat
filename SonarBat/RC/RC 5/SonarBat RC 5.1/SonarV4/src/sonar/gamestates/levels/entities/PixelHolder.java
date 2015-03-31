package sonar.gamestates.levels.entities;

abstract class PixelHolder
{
	/*The pixelHolder class is what allows us to generate pixels. The way these
	 * pixels is generated is based on the width, and height of what we take in
	 * as parameters. The width and height is all we need to determine the size
	 * of our array. The height field is only useful when we are dealing with
	 * the screen itself as it will not be set if we are using the spritesheet
	 * instead. Pixels array is what are used to hold the pixels that make up
	 * the images of our image and allows us to read it in as well as write to
	 * it. 
	 */
	private int[] pixels;
	private int width, height;
	void initPixels(int width, int height){pixels = new int[width * height];}
	public int[] getPixels(){return pixels;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	void setHeight(int height){this.height = height;}
	void setWidth(int width){this.width = width;}
}