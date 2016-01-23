package sonar.gamestates.states;

import sonar.GSM;
import sonar.GameState;
import sonar.StateBuilder;
import sonar.StateHolder;

public class PasswordState extends GameState
{
	//Allows the user to enter passwords to access stages.
	public PasswordState(StateBuilder buildState)
	{
		super(buildState);
	}
	protected void update()
	{
		getKey().update();
		if(getKey().a)
		{
			resetKeyboard();
			resetSmanage();
			resetTmanage();
			getGsm().setState(StateHolder.starterStage);
			System.out.println("Entered StarterStage!");
		}
	}
}