package sonar.gamestates.levels;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import sonar.gamestates.levels.entities.Mob;
import sonar.gamestates.levels.entities.Screen;
import sonar.gamestates.levels.entities.Tile;

public abstract class Level
{
	private int width, height;
	private int[] tiles;
	private Random random;
	private TileHolder holder;
	private LevelManager lm;
	
	//private List<Mob> mobs = new ArrayList<Mob>();
	
	Level(int width, int height)
	{
		holder = new TileHolder();
		this.width = width;
		this.height = height;
		random = new Random();
		tiles = new int[width * height];
		generateLevel();
	}
	
	Level(String path, LevelManager lm)
	{
		holder = new TileHolder();
		loadLevel(path);
		this.lm = lm;
	}
	
	private void loadLevel(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(Level.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0 , width);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//Skipped 51 code
	}
	
	private void generateLevel()
	{
		for(int y = 0; y < height; y++)
		{
			for(int x = 0; x < width; x++)
			{
				tiles[x + y * width] = random.nextInt(4);
			}
		}
	}
	
	void update()
	{
		//for(int i = 0; i < mobs.size(); i++)
		//{
			//mobs.get(i).update();
		//}
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
		
		for(int y = y0; y < y1; y++)
		{
			for(int x = x0; x < x1; x++)
			{
				getTile(x,y).render(x, y, screen);
			}
		}
		
		//for(int i = 0; i < mobs.size(); i++)
		//{
			//mobs.get(i).render(screen, "Mobs");
		//}
	}
	
	public void add(Mob m)
	{
		//mobs.add(m);
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width || y >= height) return holder.voidTile;
		//if(tiles[x+y*width] == 0xff99d9ea) //return holder.warpTile;
		if(tiles[x+y*width] == holder.wallColour) return holder.wallTile; //0xffff7f27
		if(tiles[x+y*width] == holder.grassColour) return holder.grassTile; //0xff22b14c
		if(tiles[x+y*width] == holder.backgroundColour) return holder.backgroundTile; //0xffff00ff
		return holder.voidTile;
	}
	
	LevelManager getLm()
	{
		return lm;
	}
}