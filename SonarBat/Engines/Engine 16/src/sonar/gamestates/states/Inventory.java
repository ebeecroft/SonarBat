package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;

public class Inventory extends GameState
{
	//A class that will hold all energy for the player.
	public Inventory(StateBuilder buildState, GSM gsm){super(buildState, gsm);}
	protected void update()
	{
		if(getKey() == null) initKey();
		getKey().update();
		if(getKey().a)
		{
			resetKeyboard();
			getGsm().switchStates(getGsm().getPastState(), getGsm().getCurrentState());
			System.out.println("Entered StarterStage!");
		}
	}
}