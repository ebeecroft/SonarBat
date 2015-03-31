package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.Screen;

class Level
{
	/*The Level class is the base class for all levels that will be created. To
	 * perform its basic functions it needs to have an update and render method.
	 * What the update method does here is update all the mobs or animated tiles
	 * that exist in the levels. The width and height tells us how big our
	 * current level is so that we know the end of the level and when we are
	 * at the boundary. The LevelManager is needed for every level since it is
	 * what allows us to switch from one level to the next. The DrawObject
	 * variable of the draw class is necessary to abstract away the different
	 * drawing components of our render method to make it easier on the
	 * programmer to find bugs and potentially avoid confusion. The smaller
	 * a levels code is, the easier it is to manage. We need the Level
	 * constructor to be empty since we will never really create a level
	 * from this class and will instead allow the subclasses to construct the
	 * actual level. This class will be an abstract class.
	 */
	
	private int width, height;
	private Draw drawObject;
	private LevelManager lm;
	
	Level(){drawObject = new Draw(this);}
	void update()
	{
		//This method will always be empty as we will be extending this class
	}
	
	void render(int xScroll, int yScroll, Screen screen)
	{
		if(xScroll < 0) xScroll = 0;
		if(yScroll < 0) yScroll = 0;
		if(xScroll > ((width << 4) - screen.getWidth())) xScroll = ((width << 4) - screen.getWidth());
		if(yScroll > ((height << 4) - screen.getHeight())) yScroll = ((height << 4) - screen.getHeight());
		screen.setOffset(xScroll, yScroll);
		//This is kind of bad since we are under assumption tiles are only 16
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.getWidth() + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.getHeight() + 16) >> 4;
		drawObject.drawLevel(x0, x1, y0, y1, screen);
		drawObject.drawMob();
	}

	//Setters and Getters for subclasses of LevelR only
	LevelManager getLm(){return lm;}
	void setLm(LevelManager lm){this.lm = lm;}
	int getWidth(){return width;}
	void setWidth(int width){this.width = width;}
	int getHeight(){return height;}
	void setHeight(int height){this.height = height;}
	Draw getDrawObject(){return drawObject;}
}