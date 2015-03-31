package sonar.entities;

public abstract class Entity
{
	private int x, y;
	private Sprite sprite;
	
	void setSprite(Sprite sprite){this.sprite = sprite;}
	public Sprite getSprite(){return sprite;}
	public int getX(){return x;}
	protected void setX(int value){x = value;}
	public int getY(){return y;}
	protected void setY(int value){y = value;}
	boolean light(){return false;}
}