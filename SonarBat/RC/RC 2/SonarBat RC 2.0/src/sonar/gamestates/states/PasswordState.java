package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;
import sonar.gamestates.StateHolder;

public class PasswordState extends GameState
{
	//Allows the user to enter passwords to access stages.
	public PasswordState(StateBuilder buildState, GSM gsm){super(buildState, gsm);}
	protected void update()
	{
		getKey().update();
		if(getKey().a)
		{
			resetKeyboard();
			initKey();
			getGsm().setState(StateHolder.starterStage);
			System.out.println("Entered StarterStage!");
		}
	}
}