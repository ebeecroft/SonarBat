package entity.tile;

import entity.Sprite;

public class GrassTile extends Tile
{
	public GrassTile(Sprite sprite){super(sprite);}
	public boolean solid(){return true;}
}