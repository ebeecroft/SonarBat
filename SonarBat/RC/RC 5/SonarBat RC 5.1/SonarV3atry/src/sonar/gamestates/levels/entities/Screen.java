package sonar.gamestates.levels.entities;

public class Screen extends PixelHolder
{	
	private int xOffset, yOffset;
	
	public Screen(int width, int height)
	{
		setWidth(width);
		setHeight(height);
		initPixels(width, height);
	}
	
	public void clear()
	{
		for(int i = 0; i < getPixels().length; i++)
		{
			getPixels()[i] = 0;
		}
	}
	
	void renderTile(int xp, int yp, Tile tile)
	{
		//329 3:12min
		//30
		xp -= xOffset;
		yp -= yOffset;
		
		for(int y = 0; y < tile.getSprite().getHeight(); y++)
		{
			int ya = y + yp;
			for(int x = 0; x < tile.getSprite().getWidth(); x++)
			{
				int xa = x + xp;
				if(xa < -tile.getSprite().getWidth() || xa >= getWidth() || ya < 0 || ya >= getHeight()) break;
				if(xa < 0) xa = 0;
				int col = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
				if(col != 0xffff00ff) getPixels()[xa + ya * getWidth()] = col;
			}
		}
	}
	
	void renderPlayer(int xp, int yp, Mob player, int flip)
	{
		xp -= xOffset;
		yp -= yOffset;
		
		for(int y = 0; y < player.getSprite().getHeight(); y++)
		{
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3)
			{
				ys = player.getSprite().getHeight() - (y + 1);
			}
			for(int x = 0; x < player.getSprite().getWidth(); x++)
			{
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3)
				{
					xs = player.getSprite().getWidth() - (x + 1);
				}
				if(xa < -player.getSprite().getWidth() || xa >= getWidth() || ya < 0 || ya >= getHeight()) break;
				if(xa < 0) xa = 0;
				int col = player.getSprite().getPixels()[xs + ys * player.getSprite().getWidth()];
				if(col != 0xffff00ff && col != 0xff000000) 
				{
					if(player.getSprite().getSize() != -1)
					{
						col = colours(col, player);
					}
					getPixels()[xa + ya * getWidth()] = col;
				}
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
	private int colours(int col, Mob player)
	{
		if(player.getSprite().getSize() == 2)
		{
			//All black is always the hidden background of the player and should never be colorized 
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[1];
		}
		if(player.getSprite().getSize() == 3)
		{
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xff808080) col = player.getSprite().getColourize()[1];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[2];
		}
		if(player.getSprite().getSize() == 4)
		{
			//if(col == 0xff000000) //col = player.getSprite().getColourize()[0];
			if(col == 0xff555555) col = player.getSprite().getColourize()[1];
			if(col == 0xffaaaaaa) col = player.getSprite().getColourize()[2];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[3];
		}
		if(player.getSprite().getSize() == 5)
		{
			//if(col == 0xff000000)
			if(col == 0xff404040) col = player.getSprite().getColourize()[1];
			if(col == 0xff808080) col = player.getSprite().getColourize()[2];
			if(col == 0xffC0C0C0) col = player.getSprite().getColourize()[3];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[4];
			
		}
		if(player.getSprite().getSize() == 6)
		{
			//if(col == 0xff000000); //col = player.getSprite().getColourize()[0];						
			if(col == 0xff333333) col = player.getSprite().getColourize()[1];
			if(col == 0xff666666) col = player.getSprite().getColourize()[2];
			if(col == 0xff999999) col = player.getSprite().getColourize()[3];
			if(col == 0xffCCCCCC) col = player.getSprite().getColourize()[4];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[5];
		}
		if(player.getSprite().getSize() == 7)
		{
			//if(col == 0xff000000);
			if(col == 0xff2b2b2b) col = player.getSprite().getColourize()[1];
			if(col == 0xff565656) col = player.getSprite().getColourize()[2];
			if(col == 0xff818181) col = player.getSprite().getColourize()[3];
			if(col == 0xffacacac) col = player.getSprite().getColourize()[4];
			if(col == 0xffd7d7d7) col = player.getSprite().getColourize()[5];
			if(col == 0xffffffff) col = player.getSprite().getColourize()[6];
		}
		return col;
	}
}