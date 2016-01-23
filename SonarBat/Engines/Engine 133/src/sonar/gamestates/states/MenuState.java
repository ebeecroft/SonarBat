package sonar.gamestates.states;

import sonar.GSM;
import sonar.GameState;
import sonar.StateBuilder;
import sonar.StateHolder;

public class MenuState extends GameState
{
	//The very first screen the user sees when starting the game up.
	private byte index = 0;
	private byte limit = 1;
	public MenuState(StateBuilder buildState)
	{
		GameState.createGameState(buildState);
	}
	
	protected void update()
	{
		getKey().update();
		if(getKey().up)
		{
			if(index != 0) index--;
			else index = limit;
		}
		
		if(getKey().down)
		{
			if(index == limit) index = 0;
			else index++;
		}
		
		if(getKey().a)
		{
			resetKeyboard();
			resetSmanage();
			resetTmanage();
			choice();
		}
	}
	
	private void choice()
	{
		if(index == 0)
		{
			GSM.setState(StateHolder.starterStage);
			System.out.println("Entered StarterStage!");
		}
		if(index == 1)
		{
			GSM.setState(StateHolder.passwordState);
			System.out.println("Entered PasswordState!");
		}
	}
}