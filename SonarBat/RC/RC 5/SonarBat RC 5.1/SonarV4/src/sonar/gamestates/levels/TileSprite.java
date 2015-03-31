package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.SpriteSheet;

class TileSprite
{
	/*The TileSprite class is designed to hold all of the sprites to our tiles
	 * that we could possibly need. The reason for this is to make the
	 * TileHolder more simple and to abstract out this layer of detail from
	 * that class. In order for TileSprites to function we need a SpriteSheet
	 * to be read in to build the Sprite in the first place. The SpriteSheets
	 * will never be needed to be called again as they will be cleared off
	 * when we exit the constructor class. The constructor will be empty since
	 * we don't need any parameters for this since all it does is hold
	 * sprites.
	 */
	
	Sprite grassSprite, wallSprite, ladderSprite;
	Sprite voidSprite, backgroundSprite;
	
	TileSprite()
	{
		SpriteSheet tiles = new SpriteSheet("/textures/sheet/tiles/basic_tiles.png");
		ladderSprite = new Sprite(2, 0, 16, 16, tiles);
		grassSprite = new Sprite(0,0,16,16, tiles);
		voidSprite = new Sprite(16, 0x1B87E0);
		backgroundSprite = new Sprite(16, 0xffff00ff);
		wallSprite = new Sprite(1,0,16,16, tiles);
	}
}