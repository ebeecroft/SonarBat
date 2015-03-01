package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;
import sonar.gamestates.StateHolder;

public class MenuState extends GameState
{
	//The very first screen the user sees when starting the game up.
	private byte index = 0;
	private byte limit = 1;
	public MenuState(StateBuilder buildState, String path, String identity, GSM gsm){super(buildState, path, identity, gsm);}
	
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
			getGsm().setState(StateHolder.starterStage);
			System.out.println("Entered StarterStage!");
		}
		if(index == 1)
		{
			getGsm().setState(StateHolder.passwordState);
			System.out.println("Entered PasswordState!");
		}
	}
}