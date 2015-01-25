package sonar.gamestates.states.levels;

import java.awt.Graphics;
import sonar.gamestates.GSM;

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
		if(level == LevelHolder.starterStage1) currentLevel = new StarterStage1();
		if(level == LevelHolder.starterStage2) currentLevel = new StarterStage2();
		if(level == LevelHolder.starterStage3) currentLevel = new StarterStage3();
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