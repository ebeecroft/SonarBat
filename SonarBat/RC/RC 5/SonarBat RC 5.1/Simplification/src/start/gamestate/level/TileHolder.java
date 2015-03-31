package start.gamestate.level;

import entity.Sprite;
import entity.SpriteSheet;
import entity.tile.BackgroundTile;
import entity.tile.GrassTile;
import entity.tile.LadderTile;
import entity.tile.Tile;
import entity.tile.VoidTile;
import entity.tile.WallTile;

public class TileHolder
{
	public Tile grassTile, voidTile, warpTile, wallTile, backgroundTile, ladderTile;
	int grassColour =0xff22aa10, wallColour = 0xff808080, backgroundColour = 0xffff00ff, ladderColour  = 0xff9e661b;
	
	public TileHolder()
	{
		SpriteSheet tiles = new SpriteSheet("/textures/sheets/tiles/spritesheet16.png");
		Sprite ladderSprite = new Sprite(2, 0, 16, 16, tiles);
		Sprite grassSprite = new Sprite(0,0,16,16, tiles);
		Sprite voidSprite = new Sprite(16, 0x1B87E0);
		Sprite backgroundSprite = new Sprite(16, 0xffff00ff);
		Sprite wallSprite = new Sprite(1,0,16,16, tiles);
		ladderTile = new LadderTile(ladderSprite);
		grassTile = new GrassTile(grassSprite);
		voidTile = new VoidTile(voidSprite);
		wallTile = new WallTile(wallSprite);
		backgroundTile = new BackgroundTile(backgroundSprite);
	}
}