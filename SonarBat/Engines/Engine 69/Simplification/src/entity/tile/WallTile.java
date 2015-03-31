package entity.tile;

import entity.Sprite;

public class WallTile extends Tile
{
	public WallTile(Sprite sprite){super(sprite);}
	public boolean solid(){return true;}
}