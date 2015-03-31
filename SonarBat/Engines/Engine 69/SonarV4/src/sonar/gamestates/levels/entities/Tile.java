package sonar.gamestates.levels.entities;

public abstract class Tile extends Entity
{
	/*The Tile class is the basic Tile for which tiles of the level extend.
	 * This Tile class is what tells the other tiles to render themselves.
	 * Also every tile is given a sprite of which it uses and sets up
	 * whether a tile is solid or not.
	 */
	protected Tile(Sprite sprite){getBasic().setSprite(sprite);}
	public void render(int x, int y, Screen screen)
	{
		getBasic().setX(x);
		getBasic().setY(y);
		screen.renderTile(x << 4, y << 4, this);
	}
	
	protected boolean solid(){return false;}
}