package sonar.gamestates.states;

import sonar.GSM;
import sonar.GameState;
import sonar.StateBuilder;
import sonar.StateHolder;

public class PasswordState extends GameState
{
	//Allows the user to enter passwords to access stages.
	public PasswordState(StateBuilder buildState, String path, String identity, GSM gsm){super(buildState, path, identity, gsm);}
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