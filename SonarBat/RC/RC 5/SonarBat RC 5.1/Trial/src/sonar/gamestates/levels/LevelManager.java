package sonar.gamestates.levels;

import sonar.gamestates.Keyboard;
import sonar.gamestates.levels.entities.Screen;

public class LevelManager
{
	private int currentLevel;
	public Level[] levels;
	public int starterLevel1 = 0;
	private int amount = 1;
	public Level currentLevel2;
	
	public LevelManager(Keyboard key)
	{
		levels = new Level[amount];
		currentLevel = starterLevel1;
		loadLevel(currentLevel);
	}
	
	private void loadLevel(int level)
	{
		if(level == starterLevel1)
		{
			levels[level] = new StarterLevel1(this, "/textures/levels/levelmap.png");
			currentLevel2 = levels[level];
		}
	}
	
	private void unloadLevel(int level)
	{
		levels[level] = null;
	}
	
	void setLevel(int level)
	{
		unloadLevel(currentLevel);
		currentLevel = level;
		loadLevel(currentLevel);
	}
	
	public void update()
	{
		levels[currentLevel].update();
	}
	
	public void render(int xScroll, int yScroll, Screen screen)
	{
		levels[currentLevel].render(xScroll, yScroll, screen);
	}
}