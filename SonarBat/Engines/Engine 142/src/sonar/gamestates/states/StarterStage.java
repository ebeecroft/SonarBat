package sonar.gamestates.states;

import java.awt.Graphics;
import sonar.GSM;
import sonar.GameState;
import sonar.Screen;
import sonar.StateBuilder;
import sonar.gamestates.states.levels.LM;
import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.tiles.TileManager;

public class StarterStage extends GameState
{
	//This is where the player first starts.
	private LM lm;
	public StarterStage(StateBuilder buildState)
	{
		GameState.createGameState(buildState);
		lm = LM.createLM(this);
	}
	
	protected void update()
	{
		if(getKey() == null)
		{
			initKey();
			setSmanage(new SpriteManager(getBuildState().getIdentity()));
			setTmanage(new TileManager(getSmanage()));
		}
		getKey().update();
		lm.update();
		if(getKey().start)
		{
			resetKeyboard();
			resetSmanage();
			resetTmanage();
			//Reset the player input method here
			lm.getCurrentLevel().getMmanager().starterMob.setPlayerInput(null);
			GSM.switchStates(GSM.getPastState(), GSM.getCurrentState());
		}
	}
	
	protected void render(int xScroll, int yScroll, Screen screen, Graphics g)
	{
		lm.render(xScroll, yScroll, screen);
	}
}