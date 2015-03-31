package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.Tile;
import sonar.gamestates.levels.entities.tiles.BackgroundTile;
import sonar.gamestates.levels.entities.tiles.GrassTile;
import sonar.gamestates.levels.entities.tiles.LadderTile;
import sonar.gamestates.levels.entities.tiles.VoidTile;
import sonar.gamestates.levels.entities.tiles.WallTile;

public class TileHolder
{
	/*The TileHolder class is what allows us to hold the different tiles that
	 * we can use in our game. These tiles are what builds our actual level
	 * and are different from level to level as some of them may not be used
	 * in every single level. A color is needed to determine which one of
	 * these tiles to place on the screen. If a tile can't be found that
	 * fits a given color then the VoidTile will be used instead. The two
	 * classes we need to make TileHolder usable is the TileSprite class
	 * and the TileColour class. The TileSprite class is what will give us
	 * the correct sprite to our tile as Sprites and Tiles are a one to one
	 * match. So for every tile you create you need to have a sprite that
	 * matches the one you are using. The TileColour class holds the
	 * different colours that we use to differentiate the different tiles
	 * in our game. The colours determine which tile we need to place.
	 */
	private TileSprite tsprite;
	private TileColour tcolour;
	Tile grassTile, wallTile, ladderTile;	
	Tile voidTile, backgroundTile; 
	
	TileHolder()
	{
		tsprite = new TileSprite();
		tcolour = new TileColour();
		ladderTile = new LadderTile(tsprite.ladderSprite);
		grassTile = new GrassTile(tsprite.grassSprite);
		voidTile = new VoidTile(tsprite.voidSprite);
		wallTile = new WallTile(tsprite.wallSprite);
		backgroundTile = new BackgroundTile(tsprite.backgroundSprite);
	}
	
	TileColour getTcolour(){return tcolour;}
}