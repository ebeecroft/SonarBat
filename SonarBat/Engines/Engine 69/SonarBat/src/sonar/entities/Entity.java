package sonar.entities;

import sonar.graphics.Sprite;
import sonar.level.Level;

public abstract class Entity
{
	private Sprite sprite;
	private Level level;
	
	Entity(Sprite sprite)
	{
		this.sprite = sprite;
	}
	
	void setSprite(Sprite sprite)
	{
		this.sprite = sprite;
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	boolean light()
	{
		return false;
	}
	
	public void setLevel(Level level)
	{
		this.level = level;
	}
	
	public Level getLevel()
	{
		return level;
	}
}