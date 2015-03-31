package sonar;

import java.awt.image.BufferStrategy;
import sonar.gamestates.GameStateManager;

class Mobile
{
	private GameStateManager gsm;
	
	Mobile(Game game)
	{
		gsm = new GameStateManager(game);
	}
	
	void update()
	{
		gsm.update();
	}
	
	void render(BufferStrategy bs)
	{
		if(bs == null) return;
		gsm.render(bs);
	}
}