package start.gamestate;

import java.awt.Graphics;

abstract class GameState
{
	private GameStateManager gsm;
	
	void setGameStateManager(GameStateManager gsm)
	{
		this.gsm = gsm;
	}

	GameStateManager getGameStateManager() {
		return gsm;
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		
	}
}