package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;

public class MenuState extends GameState
{
	//The very first screen the user sees when starting the game up.
	public MenuState(StateBuilder buildState, GSM gsm){super(buildState, gsm);}
}