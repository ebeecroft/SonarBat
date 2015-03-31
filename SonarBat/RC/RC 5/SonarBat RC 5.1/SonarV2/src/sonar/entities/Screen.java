package sonar.entities;

public class Screen extends PixelHolder //extends PixelDS
{
	private int xOffset, yOffset;
	
	public Screen(int width, int height)
	{
		initPixels(width, height);
		setWidth(width);
		setHeight(height);
	}
	
	void clear()
	{
		//Clears off dead pixels
		for(int i = 0; i < getPixels().length; i++)
		{
			getPixels()[i] = 0;
		}
	}
	
	void renderTile(int xp, int yp, Entity tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.getSprite().getHeight(); y++)
		{
			int ya = y + yp;
			for (int x = 0; x < tile.getSprite().getWidth(); x++)
			{
				int xa = x + xp;
				if (xa < -tile.getSprite().getWidth() || xa >= getWidth() || ya < 0 || ya >= getHeight()) break;
				if (xa < 0) xa = 0;
				//pixels[xa + ya * getWidth()] = array2[x + y * awidth];
				getPixels()[xa + ya * getWidth()] = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
				//setPixels(tile.getSprite().getPixels(), x, y, tile.getSprite().getWidth(), xa, ya, getWidth());
			}
		}
	}
	
	void renderMob(int xp, int yp, Entity mob, int flip)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < mob.getSprite().getHeight(); y++)
		{
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3)
			{
				ys = (mob.getSprite().getHeight() - 1) - y;
			}
			for (int x = 0; x < mob.getSprite().getWidth(); x++)
			{
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) 
				{
					xs = (mob.getSprite().getWidth() - 1) - x;
				}
				if (xa < -mob.getSprite().getWidth() || xa >= getWidth() || ya < 0 || ya >= getHeight()) break;
				if (xa < 0) xa = 0;
				int col = mob.getSprite().getPixels()[xs + ys * mob.getSprite().getWidth()];
				//pixels[x + y * width] = value;
				if (col != 0xff000000) getPixels()[x + y * getWidth()] = col; //setPixels(col, xa, ya, getWidth());
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}