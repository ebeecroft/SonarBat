package sonar.gamestates.states.levels;

import sonar.gamestates.Screen;

public class Level
{
	//Level retrieves all the tiles that build our level.
	private LM lm;
	private LevelBuilder buildLevel;
	
	protected Level(LevelBuilder buildLevel, LM lm)
	{
		this.buildLevel = buildLevel;
		this.lm = lm;
		lm.getStage().setHeight(buildLevel.getHeight());
		lm.getStage().setWidth(buildLevel.getWidth());
		lm.getStage().setTiles(buildLevel.getTiles());
	}
	
	void update()
	{
		
	}
	
	void render(int xScroll, int yScroll, Screen screen)
	{
		screen.setOffset(xScroll, yScroll);
		lm.getStage().drawTiles(xScroll, yScroll, screen);
	}
	
	LM getLm(){return lm;}
	LevelBuilder getBuildLevel(){return buildLevel;}
}