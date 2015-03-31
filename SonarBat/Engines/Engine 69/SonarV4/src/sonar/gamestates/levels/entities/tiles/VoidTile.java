package sonar.gamestates.levels.entities.tiles;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.Tile;

public class VoidTile extends Tile
{
	/*The VoidTile class is a group of tiles that are only rendered when we either
	 * don't have a tile that matches a given colour or two we are outside the
	 * bounds of the map. This is to prevent the Level from crashing since we need
	 * to return at least something to the getTile method other than null. Every
	 * void tile is not solid and allows the player to pass through them.
	 */
	public VoidTile(Sprite sprite){super(sprite);}
}