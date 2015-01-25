package sonar.gamestates.states.levels.stages.entities.animations.tiles;

import sonar.gamestates.states.levels.stages.entities.Sprite;

class Tile
{
	private TileBuilder buildTile;
	Tile(TileBuilder buildTile){this.buildTile = buildTile;}
	Sprite getSprite(){return buildTile.getSprite();}
	void update(){buildTile.update();}
	int getWidth(){return buildTile.getWidth();}
	int getHeight(){return buildTile.getHeight();}
	boolean solid(){return buildTile.solid();}
	boolean light(){return buildTile.light();}
	String attribute(){return buildTile.attribute();}
}