package sonar.gamestates;

import java.awt.Graphics;

public class GameState
{
	private GameStateManager gsm;
	
	GameState(GameStateManager gsm){this.gsm = gsm;}
	void update(){}
	void render(Graphics g){}
	GameStateManager getGsm(){return gsm;}
}