package sonar.gamestates;

import java.awt.Graphics;

public abstract class GameState
{
	//The base class Template for all the gamestates in the game.
	private StateBuilder buildState;
	private GSM gsm;
	private Keyboard key;
	
	protected GameState(StateBuilder buildState, GSM gsm)
	{
		this.buildState = buildState;
		this.gsm = gsm;
		if(buildState.stateType().equals("Single")){key = new Keyboard(gsm);}
	}
	
	protected void update()
	{
		
	}
	
	protected void render(Graphics g)
	{
		
	}
	
	StateBuilder getBuildState(){return buildState;}
	protected GSM getGsm(){return gsm;}
	protected Keyboard getKey(){return key;}
	protected void resetKeyboard(){key = null;}
	protected void initKey(){key = new Keyboard(gsm);}
}