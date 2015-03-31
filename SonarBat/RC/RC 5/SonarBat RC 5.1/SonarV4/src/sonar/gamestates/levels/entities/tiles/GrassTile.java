package sonar.gamestates.levels.entities.tiles;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.Tile;

public class GrassTile extends Tile
{
	/*The GrassTile class is a group of tiles that are made of grass. These
	 * specific tiles are solid and don't allow the player to pass through
	 * them.
	 */
	public GrassTile(Sprite sprite){super(sprite);}
	protected boolean solid(){return false;}
}