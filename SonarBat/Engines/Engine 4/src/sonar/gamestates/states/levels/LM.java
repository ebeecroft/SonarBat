package sonar.gamestates.states.levels;

import java.awt.Graphics;

import sonar.gamestates.GSM;
import sonar.gamestates.states.levels.stages.StarterStage1;
import sonar.gamestates.states.levels.stages.StarterStage2;
import sonar.gamestates.states.levels.stages.StarterStage3;

public class LM
{
	private Level currentLevel;
	public LM(String stageType, GSM gsm)
	{
		if(stageType.equals("Starter")){setLevel(LevelHolder.starterStage1);}
	}
	
	private void loadLevel(int level)
	{
		currentLevel = null;
		if(level == LevelHolder.starterStage1) currentLevel = new StarterStage1(new DynamicLevelBuilder("Starter"), this);
		if(level == LevelHolder.starterStage2) currentLevel = new StarterStage2(new DynamicLevelBuilder("Starter"), this);
		if(level == LevelHolder.starterStage3) currentLevel = new StarterStage3(new DynamicLevelBuilder("Starter"), this);
	}
	
	void setLevel(int level){loadLevel(level);}
	public void update()
	{
		currentLevel.update();
	}
	
	public void render(Graphics g)
	{
		currentLevel.render();
	}
}