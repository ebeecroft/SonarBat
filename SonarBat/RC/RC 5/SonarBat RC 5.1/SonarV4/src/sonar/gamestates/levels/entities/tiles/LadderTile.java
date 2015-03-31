package sonar.gamestates.levels.entities.tiles;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.Tile;

public class LadderTile extends Tile
{
	/*The LadderTile class is a special group of tiles that a player or npc can
	 * climb. Unlike other tiles these act like they are solid when the player
	 * is standing above them or is on the lowest end of the ladder preventing
	 * the player from falling off.
	 */
	public LadderTile(Sprite sprite){super(sprite);}
}