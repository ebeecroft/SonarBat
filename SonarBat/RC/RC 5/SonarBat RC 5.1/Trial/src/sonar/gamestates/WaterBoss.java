package sonar.gamestates;

import java.awt.Graphics;

class WaterBoss extends DisplayBossState
{
	WaterBoss(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		getGsm().setState(getGsm().waterStage);
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Water Boss");
	}
}