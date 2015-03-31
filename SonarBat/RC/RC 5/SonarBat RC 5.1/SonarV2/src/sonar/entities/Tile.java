package sonar.entities;

public class Tile extends Entity
{	
	//Level colours
	public static final int col_grass = 0xff00ff00;
	public static final int col_wall = 0xffb97a57;	
	
	public Tile(Sprite sprite){setSprite(sprite);}
	public void render(int x, int y, Screen screen)
	{
		setX(x);
		setY(y);
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean solid(){return false;}
}