package sonar.tiles;

import sonar.entities.Tile;
import sonar.sprite.Holder;

public class TileHolder
{
	public Tile grass;
	public Tile wall;
	public Tile voidTile;
	
	public TileHolder()
	{
		Holder hold = new Holder();
		grass = new GrassTile(hold.tile.grass);
		wall = new WallTile(hold.tile.wall);
		voidTile = new VoidTile(hold.tile.voidSprite);
	}
}