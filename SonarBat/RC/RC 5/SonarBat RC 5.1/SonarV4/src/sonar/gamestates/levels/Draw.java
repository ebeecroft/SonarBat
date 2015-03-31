package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.Screen;
import sonar.gamestates.levels.entities.Tile;

class Draw
{
	/*The draw class is what allows the levels to be able to draw the mobs and levels
	 * to the screen. We need several methods to accomplish this task. We need the
	 * drawLevel to allow us to actually render out the given level be it read in
	 * from a file or statically defined. It just needs to be defined once here and
	 * no where else. The next thing we need to draw is all the different types of
	 * mobs to the screen. This will be any projectiles, NPC's or even the player
	 * himself. To do this we use the drawMob class and it is only used with the
	 * class named Level.
	 * 
	 * The third method we need here is the getTile method. This method was built
	 * by TheCherno who is an awesome guy and serves a dual purpose. While initially
	 * I thought this was only useful for building the levels themselves I have gone
	 * to discover that this is also very useful for finding solid tiles as well and
	 * does this by only needing a simple x and y position to do so. So I like to
	 * say to TheCherno nice job at finding this dual purpose. :)
	 * 
	 * Now the TileHolder class is a method I built on my own intuition, it is used
	 * to store all the available tiles that we need to build the level, without
	 * them we wouldn't have a game running. The TileHolder is defined in the
	 * constructor of the draw class so that we can utilize its functionality here.
	 * The tiles array is necessary when it comes to actually storing the tiles we
	 * need when this array is read we then know which ones to actually use. The
	 * level variable is needed for us to tie the LevelR directly to the level
	 * itself otherwise we both be able to find the width or other functions in
	 * this class.
	 */
	private int[] tiles;
	private TileHolder holder;
	private Level level;
	
	Draw(Level level)
	{
		this.level = level;
		holder = new TileHolder();
	}
	
	void drawLevel(int x0, int x1, int y0, int y1, Screen screen)
	{
		for(int y = y0; y < y1; y++)
		{
			for(int x = x0; x < x1; x++)
			{
				getTile(x,y).render(x, y, screen);
			}
		}
	}
	
	void drawMob()
	{
		//for(int i = 0; i < mobs.size(); i++)
				//{
					//mobs.get(i).render(screen, "Mobs");
				//}
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= level.getWidth() || y >= level.getHeight()) return holder.voidTile;
		//if(tiles[x+y*width] == 0xff99d9ea) //return holder.warpTile;
		if(tiles[x+y*level.getWidth()] == holder.getTcolour().wallColour) return holder.wallTile; //0xffff7f27
		if(tiles[x+y*level.getWidth()] == holder.getTcolour().grassColour) return holder.grassTile; //0xff22b14c
		if(tiles[x+y*level.getWidth()] == holder.getTcolour().backgroundColour) return holder.backgroundTile; //0xffff00ff
		return holder.voidTile;
	}

	//Constructors to be used only with subclasses
	int[] getTiles(){return tiles;}
	void setTiles(int width, int height){tiles = new int[width * height];}
}