package sonar.gamestates.states.levels.stages.entities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteManager
{
	//Manages the sprites for all objects
	public Sprite voidSprite, grass;
	
	//Inventory and Password sprites
	public Sprite cornerUpLeft, cornerUpRight, cornerDownLeft, cornerDownRight;
	public Sprite lineUp, lineDown, lineLeft, lineRight;
	public Sprite square;
	
	//Builds the starting Mob
	public Sprite starterMobUp, starterMobUp1, starterMobUp2;
	
	//Builds the weapons
	public Sprite sonarWave, fireBurn, grassField, zapDash, waterShot;
	
	//Builds the energies
	public Sprite[] sonarEnergy, fireEnergy, grassEnergy, zapEnergy, waterEnergy;
	private String identity;
	
	public SpriteManager(String identity)
	{
		this.identity = identity;
		if(identity.equals("Menu")) buildMenu(new SpriteSize(16, 16));
		if(identity.equals("Password")) buildPassword(new SpriteSize(16, 16));
		if(identity.equals("Inventory")) buildInventory(new SpriteSize(16, 16));
		if(identity.equals("Starter")) buildStarter();
	}
	
	private void buildMenu(SpriteSize size)
	{
		voidSprite = new Sprite(new HUDSpriteBuilder(size, 0xffff0000));
	}
	
	private void buildPassword(SpriteSize size)
	{
		voidSprite = new Sprite(new HUDSpriteBuilder(size, 0xff00ff00));
		SpriteSheet password = new SpriteSheet("/textures/tiles/InventorySheet.png");
		cornerUpLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 0, password)));
		cornerUpRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 0, password)));
		cornerDownLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 1, password)));
		cornerDownRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 1, password)));
		lineUp = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 0, password)));
		lineDown = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 1, password)));
		lineLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 2, password)));
		lineRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 2, password)));
		square = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 2, password)));
	}
	
	private void buildInventory(SpriteSize size)
	{
		buildInvTiles(size);
		buildWeapons();
		buildEnergies();
	}
	
	private void buildInvTiles(SpriteSize size)
	{
		voidSprite = new Sprite(new HUDSpriteBuilder(size, 0xff00ffff));
		SpriteSheet inventory = new SpriteSheet("/textures/tiles/InventorySheet.png");
		cornerUpLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 0, inventory)));
		cornerUpRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 0, inventory)));
		cornerDownLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 1, inventory)));
		cornerDownRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 1, inventory)));
		lineUp = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 0, inventory)));
		lineDown = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 1, inventory)));
		lineLeft = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(0, 2, inventory)));
		lineRight = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(1, 2, inventory)));
		square = new Sprite(new ColourSpriteBuilder(size, new SpriteLocation(2, 2, inventory)));		
	}
	
	private void buildWeapons()
	{
		SpriteSize weaponSize = new SpriteSize(16, 16);
		SpriteSheet weapon = new SpriteSheet("/textures/weapons/WeaponsOff.png");
		sonarWave = new Sprite(new ColourSpriteBuilder(weaponSize, new SpriteLocation(0, 0, weapon)));
		fireBurn = new Sprite(new ColourSpriteBuilder(weaponSize, new SpriteLocation(1, 0, weapon)));
		grassField = new Sprite(new ColourSpriteBuilder(weaponSize, new SpriteLocation(2, 0, weapon)));
		zapDash = new Sprite(new ColourSpriteBuilder(weaponSize, new SpriteLocation(0, 1, weapon)));
		waterShot = new Sprite(new ColourSpriteBuilder(weaponSize, new SpriteLocation(1, 1, weapon)));
	}
	
	private void buildEnergies()
	{
		SpriteSize energySize = new SpriteSize(23, 6);
		SpriteSheet energy12 = new SpriteSheet("/textures/energies/12EnergyOff.png");
		int size = 13;
		
		//Initializes the different energy arrays in the game
		sonarEnergy = new Sprite[size];
		fireEnergy = new Sprite[size];
		grassEnergy = new Sprite[size];
		zapEnergy = new Sprite[size];
		waterEnergy = new Sprite[size];
		
		//Sets the different sprites for each energy type
		for(int i = 0; i < size; i++)
		{
			sonarEnergy[i] = new Sprite(new ColourSpriteBuilder(energySize, new SpriteLocation(0, i, energy12)));
			fireEnergy[i] = new Sprite(new ColourSpriteBuilder(energySize, new SpriteLocation(0, i, energy12)));
			grassEnergy[i] = new Sprite(new ColourSpriteBuilder(energySize, new SpriteLocation(0, i, energy12)));
			zapEnergy[i] = new Sprite(new ColourSpriteBuilder(energySize, new SpriteLocation(0, i, energy12)));
			waterEnergy[i] = new Sprite(new ColourSpriteBuilder(energySize, new SpriteLocation(0, i, energy12)));
		}
	}
	
	private void buildStarter()
	{
		buildTileSprites();
		buildMobSprites();
	}
	
	private void buildMobSprites()
	{
		SpriteSize mob82by60 = new SpriteSize(82, 60);
		SpriteSheet smob = new SpriteSheet("/textures/mobs/StarterMob.png");
		starterMobUp = new Sprite(new ColourSpriteBuilder(mob82by60, new SpriteLocation(0, 0, smob)));
		starterMobUp1 = new Sprite(new ColourSpriteBuilder(mob82by60, new SpriteLocation(0, 0, smob)));
		starterMobUp2 = new Sprite(new ColourSpriteBuilder(mob82by60, new SpriteLocation(0, 0, smob)));		
	}
	
	private void buildTileSprites()
	{
		buildStaticTiles();
		buildDynamicTiles();
	}
	
	private void buildStaticTiles()
	{
		voidSprite = new Sprite(new HUDSpriteBuilder(new SpriteSize(16, 16), 0xff0000ff));
		grass = new Sprite(new ColourSpriteBuilder(new SpriteSize(16, 16), new SpriteLocation(0, 0, new SpriteSheet("/textures/tiles/SpriteSheet.png"))));
	}
	
	private void buildDynamicTiles()
	{
		
	}
	
	public String getIdentity(){return identity;}
}

abstract class SpriteBuilder
{
	private SpriteSize size;
	private int[] pixels;
	SpriteBuilder(SpriteSize size)
	{
		this.size = size;
		pixels = new int[size.getWidth() * size.getHeight()];
	}
	int getWidth(){return size.getWidth();}
	int getHeight(){return size.getHeight();}
	int[] getPixels(){return pixels;}
	abstract int hiddenColour();
	abstract String spriteType();
}

class HUDSpriteBuilder extends SpriteBuilder
{
	HUDSpriteBuilder(SpriteSize size, int colour)
	{
		super(size);
		loadHUD(size, colour);
	}
	
	private void loadHUD(SpriteSize size, int colour)
	{
		for(int y = 0; y < size.getHeight(); y++)
		{
			for(int x = 0; x < size.getWidth(); x++)
			{
				getPixels()[x + y * size.getWidth()] = colour;
			}
		}
	}
	
	int hiddenColour(){return 0xffff00ff;}
	String spriteType(){return "HUD";}
}

class ColourSpriteBuilder extends SpriteBuilder
{
	ColourSpriteBuilder(SpriteSize size, SpriteLocation location)
	{
		super(size);
		loadColour(size, location);
	}
	
	private void loadColour(SpriteSize size, SpriteLocation location)
	{
		int xw = location.getX() * size.getWidth();
		int yh = location.getY() * size.getHeight();
		for(int y = 0; y < size.getHeight(); y++)
		{
			for(int x = 0; x < size.getWidth(); x++)
			{
				getPixels()[x + y * size.getWidth()] = location.getSheet().getPixels()[(x + xw) + (y + yh) * location.getSheet().getSize()];
			}
		}
	}

	int hiddenColour(){return 0xffff00ff;}
	String spriteType(){return "Colour";}
}

class GreySpriteBuilder extends SpriteBuilder
{
	private int[] colours;
	GreySpriteBuilder(SpriteSize size, SpriteLocation location, int... colours)
	{
		super(size);
		this.colours = colours;
		loadGrey(size, location);
	}
	
	private void loadGrey(SpriteSize size, SpriteLocation location)
	{
		int xw = location.getX() * size.getWidth();
		int yh = location.getY() * size.getHeight();
		for(int y = 0; y < size.getHeight(); y++)
		{
			for(int x = 0; x < size.getWidth(); x++)
			{
				getPixels()[x + y * size.getWidth()] = location.getSheet().getPixels()[(x + xw) + (y + yh) * location.getSheet().getSize()];
			}
		}
	}
	
	int[] getColours(){return colours;}
	int colourSize(){return colours.length;}
	int hiddenColour(){return 0xff000000;}
	String spriteType(){return "Grey";}
}

class SpriteLocation
{
	private int x, y;
	private SpriteSheet sheet;
	
	SpriteLocation(int x, int y, SpriteSheet sheet)
	{
		this.x = x;
		this.y = y;
		this.sheet = sheet;
	}
	
	int getX(){return x;}
	int getY(){return y;}
	SpriteSheet getSheet(){return sheet;}
}

class SpriteSheet
{
	private int[] pixels;
	private int size;
	
	SpriteSheet(String path)
	{
		loadSheet(path);
	}
	
	private void loadSheet(String path)
	{
		BufferedImage image;
		try
		{
			image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			size = width;
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}
		catch (IOException e){e.printStackTrace();}
	}
	
	int[] getPixels(){return pixels;}
	int getSize(){return size;}
}

class SpriteSize
{
	private int width, height;
	
	SpriteSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	int getWidth(){return width;}
	int getHeight(){return height;}
}