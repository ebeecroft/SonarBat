package sonar.gamestates.levels.entities.tiles;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.Tile;

public class BackgroundTile extends Tile
{
	/*The BackgroundTile class is for tiles of which will be rendered invisible.
	 * These invisible tiles is what will allow the background image to be
	 * displayed to the screen and by default are not solid since they are not
	 * solid.
	 */
	public BackgroundTile(Sprite sprite){super(sprite);}
}