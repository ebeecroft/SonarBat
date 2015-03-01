package sonar.gamestates.states.levels.stages.entities.animations.tiles;

import sonar.gamestates.states.levels.Screen;
import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.Sprite;

public class Tile extends Entity
{
	//Tile class is the building blocks that mobs stand on top of.
	private TileBuilder buildTile;
	private int x, y;
	Tile(TileBuilder buildTile)
	{
		super("Tile");
		this.buildTile = buildTile;
	}
	public Sprite getSprite(){return buildTile.getSprite();}
	void update(){buildTile.update();}
	public void render(int x, int y, Screen screen)
	{
		this.x = x * buildTile.getWidth();
		this.y = y * buildTile.getHeight();
		screen.renderTile(this);
	}
	public int getWidth(){return buildTile.getWidth();}
	public int getHeight(){return buildTile.getHeight();}
	public int getX(){return x;}
	public int getY(){return y;}
	boolean solid(){return buildTile.solid();}
	boolean light(){return buildTile.light();}
	String attribute(){return buildTile.attribute();}
}