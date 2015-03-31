package sonar.gamestates.levels.entities.tiles;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.Tile;

public class WallTile extends Tile
{
	/*The WallTile class is a group of tiles that resemble a set of walls.
	 * These walls prevent the player from moving passed them because they
	 * are solid. Like the grass they stop player movement in any
	 * direction. Normally the wall are only used for the sides since the
	 * left and right collision normally are wall like not the ground.
	 */
	public WallTile(Sprite sprite){super(sprite);}
	protected boolean solid(){return true;}
}