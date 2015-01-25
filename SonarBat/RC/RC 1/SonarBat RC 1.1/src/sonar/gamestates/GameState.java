package sonar.gamestates;

import java.awt.Graphics;

public class GameState
{
	//The base class Template for all the gamestates in the game.
	private StateBuilder buildState;
	private GSM gsm;
	
	protected GameState(StateBuilder buildState, GSM gsm)
	{
		this.buildState = buildState;
		this.gsm = gsm;
	}
	
	protected void update()
	{
		
	}
	
	protected void render(Graphics g)
	{
		
	}
	
	StateBuilder getBuildState(){return buildState;}
	GSM getGsm(){return gsm;}
}