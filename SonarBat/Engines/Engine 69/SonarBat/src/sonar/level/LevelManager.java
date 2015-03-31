package sonar.level;

import sonar.screen.Screen;

public class LevelManager
{
	private Level currentLevel;
	private LevelHolder hold;

	public LevelManager()
	{
		hold = new LevelHolder();
		//currentLevel = hold.zapStage;
		loadLevel(hold.zapStage);
	}

	private void loadLevel(Level level)
	{
		if(level == hold.zapStage)
		{
			currentLevel = level;
		}
		if(level == hold.waterStage)
		{
			currentLevel = level;
		}
	}
	
	private void unloadLevel()
	{
		currentLevel = null;
	}
	
	public void setLevel(Level level)
	{
		unloadLevel();
		loadLevel(level);
	}
	
	public void render(int xScroll, int yScroll, Screen screen)
	{
		currentLevel.render(xScroll, yScroll, screen);
	}
	
	public LevelHolder getLevelHolder()
	{
		return hold;
	}
}