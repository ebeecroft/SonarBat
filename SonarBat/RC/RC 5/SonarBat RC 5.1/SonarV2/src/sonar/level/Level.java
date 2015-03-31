package sonar.level;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import sonar.entities.Screen;
import sonar.entities.Tile;

public class Level
{
	private LevelManager lm;
	private int[] tiles;
	private int width, height;
	private Random random;
	private TileHolder tholder;
	
	Level(LevelManager lm, String path)
	{
		this.lm = lm;
		loadLevel(path);
		tholder = new TileHolder();
	}
	
	Level(LevelManager lm, int width, int height)
	{
		this.lm = lm;
		tiles = new int[width * height];
		tholder = new TileHolder();
		generateLevel();
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
	
	private void loadLevel(String path)
	{
		BufferedImage image;
		try
		{
			image = ImageIO.read(Level.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void update()
	{
		
	}
	
	void render(int xScroll, int yScroll, Screen screen)
	{
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.getWidth() + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.getHeight() + 16) >> 4;
		
		for(int y = y0; y < y1; y++)
		{
			for(int x = x0; x < x1; x++)
			{
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y < 0 || x >= width || y >= height) return tholder.voidTile;
		if (tiles[x + y * width] == Tile.col_grass) return tholder.grass;
		if (tiles[x + y * width] == Tile.col_wall) return tholder.wall;
		return tholder.voidTile;
	}
	
	LevelManager getLevelManager(){return lm;}
}