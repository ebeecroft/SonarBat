package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.BackgroundTile;
import sonar.gamestates.levels.entities.GrassTile;
import sonar.gamestates.levels.entities.LadderTile;
import sonar.gamestates.levels.entities.Sprite;
import sonar.gamestates.levels.entities.SpriteSheet;
import sonar.gamestates.levels.entities.Tile;
import sonar.gamestates.levels.entities.VoidTile;
import sonar.gamestates.levels.entities.WallTile;

public class TileHolder
{
	public Tile grassTile, voidTile, warpTile, wallTile, backgroundTile, ladderTile;
	int grassColour =0xff22aa10, wallColour = 0xff808080, backgroundColour = 0xffff00ff, ladderColour  = 0xff9e661b;
	//ffff7f27, ff22b14c, ffff00ff
	//tiles[x+y*width] == 0xffff7f27) return holder.wallTile;
	//if(tiles[x+y*width] == 0xff22b14c) return holder.grassTile;
	//if(tiles[x+y*width] == 0xffff00ff) return holder.backgroundTile;
	
	public TileHolder()
	{
		//grassColour = 0xff22aa10;
		//wallColour = 0xff808080;
		//backgroundColour = 0xffff00ff;
		//ladderColour = 0xff9e661b;
		SpriteSheet tiles = new SpriteSheet("/textures/sheets/tiles/spritesheet16.png");
		SpriteSheet wall = new SpriteSheet("/textures/wall.png");
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