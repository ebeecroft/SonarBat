package sonar.entities.tiles;

import sonar.entities.Sprite;
import sonar.entities.Tile;

public class WallTile extends Tile
{
	public WallTile(Sprite sprite)
	{
		super(sprite);
	}
	
	public boolean solid()
	{
		return true;
	}
}