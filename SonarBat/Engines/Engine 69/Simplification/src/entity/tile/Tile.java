package entity.tile;

import entity.Entity;
import entity.Screen;
import entity.Sprite;

public class Tile extends Entity
{
	Tile(Sprite sprite){getImage().setSprite(sprite);}
	public void render(int x, int y, Screen screen)
	{
		getPosition().setX(x);
		getPosition().setY(y);
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){return false;}
	public boolean climb(){return false;}
}