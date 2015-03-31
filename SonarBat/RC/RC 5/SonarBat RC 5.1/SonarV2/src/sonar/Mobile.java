package sonar;

import java.awt.image.BufferStrategy;

import sonar.gamestates.GameStateManager;

public class Mobile
{
	private GameStateManager gsm;
	
	public Mobile(Game game)
	{
		gsm = new GameStateManager(game);
	}
	
	public void update()
	{
		gsm.update();
	}
	
	public void render(BufferStrategy bs)
	{
		if(bs == null) return;
		gsm.render(bs);
	}
}