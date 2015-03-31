package sonar.gamestates;

import java.awt.Graphics;

class StarterStage extends StageState
{
	StarterStage(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		//getGsm().setState(getGsm().levelSelect);
	}
	
	void render(Graphics g)
	{
		System.out.println("I am running the Intro stage");
	}
}