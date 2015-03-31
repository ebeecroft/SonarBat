package sonar.gamestates;

import java.awt.Graphics;

class PasswordScreen extends BackgroundState
{
	PasswordScreen(GameStateManager gsm)
	{
		super(gsm);
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Password screen");
	}
}