package sonar.gamestates.states;

import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;
import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.tiles.TileManager;

public class Inventory extends GameState
{
	//A class that will hold all energy for the player.
	public Inventory(StateBuilder buildState, String path, String identity, GSM gsm){super(buildState, path, identity, gsm);}
	protected void update()
	{
		if(getKey() == null)
		{
			initKey();
			setSmanage(new SpriteManager(getIdentity()));
			setTmanage(new TileManager(getSmanage()));
		}
		getKey().update();
		if(getKey().a)
		{
			resetKeyboard();
			resetSmanage();
			resetTmanage();
			getGsm().switchStates(getGsm().getPastState(), getGsm().getCurrentState());
			System.out.println("Entered StarterStage!");
		}
	}
}