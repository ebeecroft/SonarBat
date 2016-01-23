package sonar;

import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.animations.energies.Energy;
import sonar.gamestates.states.levels.stages.entities.animations.mobs.Mob;
import sonar.gamestates.states.levels.stages.entities.animations.tiles.Tile;
import sonar.gamestates.states.levels.stages.entities.animations.weapons.Weapon;

public class Screen
{
	private static int[] screenWindow, pixels, screenOffsets;
	
	private Screen(){} //Prevents multiple screens from being created
	final static Screen createScreen(final short width, final short height)
	{
		screenOffsets = new int[2];
		screenWindow = new int[2];
		screenWindow[0] = width;
		screenWindow[1] = height;
		pixels = new int[width * height];
		Screen screen = new Screen();
		return screen;
	}
	
	public void clear()
	{
		for(int i = 0; i < pixels.length; i++){pixels[i] = 0;}
	}
	
	public void render(Entity entity, int xp, int yp, int eWidth, int eHeight)
	{
		xp -= screenOffsets[0];
		yp -= screenOffsets[1];
		
		int hiddenColour = 0;
		for(int y = 0; y < eHeight; y++)
		{
			int ya = y + yp;
			for(int x = 0; x < eWidth; x++)
			{
				int xa = x + xp;
				if((xa < -eWidth || xa >= screenWindow[0]) || (ya < 0 || ya >= screenWindow[1])) break;
				if(xa < 0) xa = 0;
				int colour  = 0;
				int colourSize = 0;
				int[] colours = null;
				if(entity.getType() == "Energy")
				{
					Energy energy = (Energy) entity;
					colour = energy.getSprite().getPixels()[x + y * eWidth];
					hiddenColour = energy.getSprite().getHiddenColour();
					colourSize = energy.getSprite().getColourSize();
					colours = energy.getSprite().getColours();
				}
				if(entity.getType() == "Weapon")
				{
					Weapon weapon = (Weapon) entity;
					colour = weapon.getSprite().getPixels()[x + y * eWidth];
					hiddenColour = weapon.getSprite().getHiddenColour();
					colourSize = weapon.getSprite().getColourSize();
					colours = weapon.getSprite().getColours();
				}
				if(entity.getType() == "Mob")
				{
					Mob mob = (Mob) entity;
					colour = mob.getSprite().getPixels()[x + y * eWidth];
					hiddenColour = mob.getSprite().getHiddenColour();
					colourSize = mob.getSprite().getColourSize();
					colours = mob.getSprite().getColours();
				}
				if(entity.getType() == "Tile")
				{
					Tile tile = (Tile) entity;
					colour = tile.getSprite().getPixels()[x + y * eWidth];
					hiddenColour = tile.getSprite().getHiddenColour();
					colourSize = tile.getSprite().getColourSize();
					colours = tile.getSprite().getColours();
				}
				if(colour != hiddenColour)
				{
					if(colourSize >= 2 && colourSize < 257){colour = changeColour(colour, colourSize, colours);}
					pixels[xa + ya * screenWindow[0]] = colour;
				}
			}
		}
	}
	
	private int changeColour(int colourRead, int colourSize, int[] colours)
	{
		//A method that allows us to utilize grayscale colour sprites.
		if(colourRead != 0xffffffff)
		{
			int index = 1;
			if(colourSize >= 3 && colourSize < 7)
			{				
				switch(colourSize)
				{
				case 3:
					colourRead = colours[index];
					break;
				case 4:
					if(colourRead == 0xff555555) colourRead = colours[1];
					if(colourRead == 0xffaaaaaa) colourRead = colours[2];
					break;
				case 5:
					if(colourRead == 0xff404040) colourRead = colours[1];
					if(colourRead == 0xff808080) colourRead = colours[2];
					if(colourRead == 0xffc0c0c0) colourRead = colours[3];
					break;
				case 6:
					if(colourRead == 0xff333333) colourRead = colours[1];
					if(colourRead == 0xff666666) colourRead = colours[2];
					if(colourRead == 0xff999999) colourRead = colours[3];
					if(colourRead == 0xffcccccc) colourRead = colours[4];
					break;
				default:
					System.out.println("Something went wrong!");
				}
			}
			else
			{
				int alpha = 0xff000000;
				int colourMin = getColourIncrement(colourSize);
				int colourMax = 0x00ffffff;
				int colourInc = colourMin;
				for(int currentColour = colourMin; currentColour < colourMax; currentColour += colourInc)
				{
					int cur = currentColour + alpha;
					if(cur == colourRead)
					{
						colourRead = colours[index];
						break;
					}
					index++;
				}
			}
		}
		else
		{
			colourRead = colours[colourSize - 1];
		}
		return colourRead;
	}
	
	private int getColourIncrement(int colourSize)
	{
		int increment = 0;
		switch(colourSize)
		{
		case 7:
			increment = 0x002b2b2b;
			break;
		case 8:
			increment = 0x00242424;
			break;
		case 9:
			increment = 0x00202020;
			break;
		case 10:
			increment = 0x001c1c1c;
			break;
		case 11:
			increment = 0x001a1a1a;
			break;
		case 12:
			increment = 0x00171717;
			break;
		case 13:
			increment = 0x00151515;
			break;
		case 14:
			increment = 0x00141414;
			break;
		case 15:
			increment = 0x00121212;
			break;
		}
		return increment;
	}
	
	public final static void setOffset(final int xOffset, final int yOffset)
	{
		screenOffsets[0] = xOffset;
		screenOffsets[1] = yOffset;
	}
	
	public final static int[] getPixels(){return pixels;}
	public final static int getWidth(){return screenWindow[0];}
	public final static int getHeight(){return screenWindow[1];}
}