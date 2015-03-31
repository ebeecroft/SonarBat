package sonar.gamestates;

import java.awt.Graphics;

class PasswordState extends GameState
{
	//private Keyboard key;
	private Background bg;
	
	PasswordState(GameStateManager gsm)
	{
		super(gsm);
		//key = new Keyboard(gsm);
		bg = new Background("/textures/backgrounds/passwordScreen.png");
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		bg.render(g);
	}
}