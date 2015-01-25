package sonar.gamestates.states.levels;

public class Level
{
	private LM lm;
	private LevelBuilder buildLevel;
	
	Level(LevelBuilder buildLevel, LM lm)
	{
		this.buildLevel = buildLevel;
		this.lm = lm;
	}
	
	void update()
	{
		
	}
	
	void render()
	{
		
	}
	
	LM getLm(){return lm;}
	LevelBuilder getBuildLevel(){return buildLevel;}
}