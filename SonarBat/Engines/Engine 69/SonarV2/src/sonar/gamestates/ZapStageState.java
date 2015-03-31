package sonar.gamestates;

import java.awt.Graphics;
import sonar.level.LevelManager;

class ZapStageState extends GameState
{
	private LevelManager lm;
	
	ZapStageState(GameStateManager gsm)
	{
		super(gsm);
		lm = new LevelManager(gsm);
	}
	
	void update()
	{
		//Updates the given level
		lm.update();
	}
	
	void render(Graphics g)
	{
		lm.render(g);
	}
}