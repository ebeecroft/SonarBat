package sonar.gamestates.levels.entities;

import sonar.gamestates.levels.Level;

public abstract class Entity
{
	private Sprite sprite;
	private Level level;
	
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
