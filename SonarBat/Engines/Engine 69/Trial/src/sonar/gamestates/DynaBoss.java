package sonar.gamestates;

import java.awt.Graphics;

class DynaBoss extends DisplayBossState
{
	DynaBoss(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		getGsm().setState(getGsm().dynaStage);
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Dyna Boss");
	}
}