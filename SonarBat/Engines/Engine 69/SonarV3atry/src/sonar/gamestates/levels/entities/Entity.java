package sonar.gamestates.levels.entities;

public abstract class Entity
{
	private double x, y;
	private Sprite sprite;
	
	public void setX(double x){this.x = x;}
	public double getX(){return x;}
	public void setY(double y){this.y = y;}
	public double getY(){return y;}
	void setSprite(Sprite sprite){this.sprite = sprite;}
	Sprite getSprite(){return sprite;}
}