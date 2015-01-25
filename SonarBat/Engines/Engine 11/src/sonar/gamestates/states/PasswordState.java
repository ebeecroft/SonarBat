package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;

public class PasswordState extends GameState
{
	//Allows the user to enter passwords to access stages.
	public PasswordState(StateBuilder buildState, GSM gsm){super(buildState, gsm);}
}