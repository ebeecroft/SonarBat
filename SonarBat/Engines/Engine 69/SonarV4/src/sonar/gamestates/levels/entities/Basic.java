package sonar.gamestates.levels.entities;

class Basic
{
	/*The basic class handles the x, y coordiantes along with the sprites from
	 * an entity. This is basic to all mobs and tiles and will be used in the
	 * others. The getters and setters can only be utilized by subclasses of
	 * entity as we will never create a physical entity.
	 */
	private int x, y;
	private Sprite sprite;
	int getX(){return x;}
	void setX(int x){this.x = x;}
	int getY(){return y;}
	void setY(int y){this.y = y;}
	Sprite getSprite(){return sprite;}
	void setSprite(Sprite sprite){this.sprite = sprite;}
}