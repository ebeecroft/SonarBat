package sonar.gamestates.states.levels;

import sonar.gamestates.GSM;
import sonar.gamestates.states.levels.stages.StarterStage1;
import sonar.gamestates.states.levels.stages.StarterStage2;
import sonar.gamestates.states.levels.stages.StarterStage3;

public class LM
{
	//LevelManager allows us to switch between different levels.
	private Level currentLevel;
	private GSM gsm;
	
	public LM(String stageType, GSM gsm)
	{
		this.gsm = gsm;
		if(stageType.equals("Starter")){setLevel(LevelHolder.starterStage1);}
	}
	
	private void loadLevel(int level)
	{
		currentLevel = null;
		if(level == LevelHolder.starterStage1) currentLevel = new StarterStage1(new DynamicLevelBuilder("/textures/stages/starter/Starter1.png"), this);
		if(level == LevelHolder.starterStage2) currentLevel = new StarterStage2(new DynamicLevelBuilder("/textures/stages/starter/Starter2.png"), this);
		if(level == LevelHolder.starterStage3) currentLevel = new StarterStage3(new DynamicLevelBuilder("/textures/stages/starter/Starter3.png"), this);
	}
	
	void setLevel(int level){loadLevel(level);}
	public void update()
	{
		currentLevel.update();
	}
	
	public void render(int xScroll, int yScroll, Screen screen)
	{
		int xLocation =  xScroll;///-screen.getWidth();
		int yLocation =  yScroll; //-screen.getHeight();
		currentLevel.render(xLocation, yLocation, screen);
	}
}