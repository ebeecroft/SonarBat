package sonar.gamestates;

import java.awt.Graphics;

class GameOverScreen extends BackgroundState
{
	GameOverScreen(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Gameover screen");
	}
}