package sonar.gamestates.levels.entities;

public abstract class Tile extends Entity
{	
	Tile(Sprite sprite)
	{
		setSprite(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		setX(x);
		setY(y);
		//6:13
		//sprite.getWidth();
		//sprite.getHeight();
		screen.renderTile(x << 4, y << 4, this);
	}
	
	boolean solid()
	{
		return false;
	}
}