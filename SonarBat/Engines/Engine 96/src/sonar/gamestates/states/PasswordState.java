package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;
import sonar.gamestates.StateHolder;

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