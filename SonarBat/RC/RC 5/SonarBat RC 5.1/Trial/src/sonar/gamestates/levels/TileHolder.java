package sonar.gamestates.levels;

import sonar.gamestates.levels.entities.GrassTile;
import sonar.gamestates.levels.entities.Tile;
import sonar.gamestates.levels.entities.VoidTile;
import sonar.gamestates.levels.entities.WallTile;

class TileHolder
{
	Tile grass;
	Tile wall;
	Tile voidTile;
	private TileSprite sprite;
	
	TileHolder()
	{
		//Holder hold = new Holder();
		sprite = new TileSprite();
		grass = new GrassTile(sprite.grass);//tile.grass);
		wall = new WallTile(sprite.wall);
		voidTile = new VoidTile(sprite.voidSprite);
	}
}