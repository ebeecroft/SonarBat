package sonar.gamestates.states;

import java.awt.Graphics;
import sonar.gamestates.GSM;
import sonar.gamestates.GameState;
import sonar.gamestates.StateBuilder;
import sonar.gamestates.states.levels.LM;

public class StarterStage extends GameState
{
	//This is where the player first starts.
	private LM lm;
	public StarterStage(StateBuilder buildState, GSM gsm)
	{
		super(buildState, gsm);
		lm = new LM("Starter", gsm);
	}
	
	protected void update()
	{
		lm.update();
	}
	
	protected void render(Graphics g)
	{
		lm.render(g);
	}
}