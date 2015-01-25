package sonar.gamestates;

import java.awt.Graphics;

class GameState
{
	private StateBuilder buildState;
	private GSM gsm;
	
	GameState(StateBuilder buildState, GSM gsm)
	{
		this.buildState = buildState;
		this.gsm = gsm;
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		
	}
	
	StateBuilder getBuildState(){return buildState;}
	GSM getGsm(){return gsm;}
}