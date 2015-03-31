package sonar.level;

import sonar.entities.Tile;
import sonar.entities.tiles.GrassTile;
import sonar.entities.tiles.VoidTile;
import sonar.entities.tiles.WallTile;

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