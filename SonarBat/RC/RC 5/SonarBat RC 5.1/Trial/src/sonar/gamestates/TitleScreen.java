package sonar.gamestates;

import java.awt.Graphics;

class TitleScreen extends BackgroundState
{
	TitleScreen(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		getGsm().setState(getGsm().starterStage);
		//getGsm().setState(getGsm().levelSelect);
		//getGsm().setState(getGsm().passwordScreen);
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Title screen");
	}
}