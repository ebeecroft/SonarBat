package entity.tile;

import entity.Sprite;

public class LadderTile extends Tile
{
	public LadderTile(Sprite sprite){super(sprite);}
	public boolean climb(){return true;}
}