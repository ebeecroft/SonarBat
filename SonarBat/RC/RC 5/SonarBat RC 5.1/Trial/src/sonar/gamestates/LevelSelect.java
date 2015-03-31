package sonar.gamestates;

import java.awt.Graphics;

class LevelSelect extends BackgroundState
{
	LevelSelect(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Levelselect screen");
	}
}