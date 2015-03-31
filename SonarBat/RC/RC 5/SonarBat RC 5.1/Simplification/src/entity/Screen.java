package entity;

import entity.mob.Mob;
import entity.tile.Tile;

public class Screen
{
	private int xOffset, yOffset;
	private PixelHolder phold;
	
	public Screen(int width, int height)
	{
		phold = new PixelHolder();
		phold.getDimension().setWidth(width);
		phold.getDimension().setHeight(height);
		phold.getPixel().setPixels(phold.getDimension());
	}
	
	public void clear()
	{
		for(int i = 0; i < phold.getPixel().getPixels().length; i++)
		{
			phold.getPixel().getPixels()[i] = 0;
		}
	}

	public void renderPlayer(int xp, int yp, Mob player, int flip)
	{
		xp -= xOffset;
		yp -= yOffset;
		
		for(int y = 0; y < player.getImage().getSprite().getPhold().getDimension().getHeight(); y++)
		{
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3)
			{
				ys = player.getImage().getSprite().getPhold().getDimension().getHeight() - (y + 1);
			}
			for(int x = 0; x < player.getImage().getSprite().getPhold().getDimension().getWidth(); x++)
			{
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3)
				{
					xs = player.getImage().getSprite().getPhold().getDimension().getWidth() - (x + 1);
				}
				if(xa < -player.getImage().getSprite().getPhold().getDimension().getWidth() || xa >= phold.getDimension().getWidth() || ya < 0 || ya >= phold.getDimension().getHeight()) break;
				if(xa < 0) xa = 0;
				int col = player.getImage().getSprite().getPhold().getPixel().getPixels()[xs + ys * player.getImage().getSprite().getPhold().getDimension().getWidth()];
				if(col != 0xffff00ff && col != 0xff000000) 
				{
					if(player.getImage().getSprite().getColor().getSize() != -1)
					{
						col = colours(col, player);
					}
					phold.getPixel().getPixels()[xa + ya * phold.getDimension().getWidth()] = col;
				}
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		
		for(int y = 0; y < tile.getImage().getSprite().getPhold().getDimension().getHeight(); y++)
		{
			int ya = y + yp;
			for(int x = 0; x < tile.getImage().getSprite().getPhold().getDimension().getWidth(); x++)
			{
				int xa = x + xp;
				if(xa < -tile.getImage().getSprite().getPhold().getDimension().getWidth() || xa >= phold.getDimension().getWidth() || ya < 0 || ya >= phold.getDimension().getHeight()) break;
				if(xa < 0) xa = 0;
				int col = tile.getImage().getSprite().getPhold().getPixel().getPixels()[x + y * tile.getImage().getSprite().getPhold().getDimension().getWidth()];
				if(col != 0xffff00ff) phold.getPixel().getPixels()[xa + ya * phold.getDimension().getWidth()] = col;
			}
		}
	}
	
	private int colours(int col, Mob player)
	{
		if(player.getImage().getSprite().getColor().getSize() == 2)
		{
			//All black is always the hidden background of the player and should never be colorized 
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[1];
		}
		if(player.getImage().getSprite().getColor().getSize() == 3)
		{
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xff808080) col = player.getImage().getSprite().getColor().getColourize()[1];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[2];
		}
		if(player.getImage().getSprite().getColor().getSize() == 4)
		{
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xff555555) col = player.getImage().getSprite().getColor().getColourize()[1];
			if(col == 0xffaaaaaa) col = player.getImage().getSprite().getColor().getColourize()[2];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[3];
		}
		if(player.getImage().getSprite().getColor().getSize() == 5)
		{
			//if(col == 0xff000000)
			if(col == 0xff404040) col = player.getImage().getSprite().getColor().getColourize()[1];
			if(col == 0xff808080) col = player.getImage().getSprite().getColor().getColourize()[2];
			if(col == 0xffC0C0C0) col = player.getImage().getSprite().getColor().getColourize()[3];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[4];
			
		}
		if(player.getImage().getSprite().getColor().getSize() == 6)
		{
			//if(col == 0xff000000); //col = player.getSprite().getColourize()[0];						
			if(col == 0xff333333) col = player.getImage().getSprite().getColor().getColourize()[1];
			if(col == 0xff666666) col = player.getImage().getSprite().getColor().getColourize()[2];
			if(col == 0xff999999) col = player.getImage().getSprite().getColor().getColourize()[3];
			if(col == 0xffCCCCCC) col = player.getImage().getSprite().getColor().getColourize()[4];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[5];
		}
		if(player.getImage().getSprite().getColor().getSize() == 7)
		{
			//if(col == 0xff000000);
			if(col == 0xff2b2b2b) col = player.getImage().getSprite().getColor().getColourize()[1];
			if(col == 0xff565656) col = player.getImage().getSprite().getColor().getColourize()[2];
			if(col == 0xff818181) col = player.getImage().getSprite().getColor().getColourize()[3];
			if(col == 0xffacacac) col = player.getImage().getSprite().getColor().getColourize()[4];
			if(col == 0xffd7d7d7) col = player.getImage().getSprite().getColor().getColourize()[5];
			if(col == 0xffffffff) col = player.getImage().getSprite().getColor().getColourize()[6];
		}
		return col;
	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public PixelHolder getPhold(){return phold;}
}