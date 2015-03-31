package sonar.gamestates;

import java.awt.Graphics;

class ZapStage extends StageState
{
	/*ZapStage is a stage that will be rendered as one of the main bosses in the game.
	 * I will be putting a different attributes in here as I go on. This will contain
	 * a render and update functionality to draw the various objects to the screen.
	 * This will be one of the various stages in the game. It will not end till the
	 * player dies or the boss is beaten.
	 * 
	 * Changed with switcher for inventory
	 */
	ZapStage(GSM gsm)
	{
		setGsm(gsm);
		setLm("Zap", gsm.getWidth(), gsm.getHeight(), gsm.getGame());
	}
	
	void update()
	{
		//setBg("Some Background for Zap");
		getLm().update();
		if(getGsm().getKey().start)
		{
			System.out.println("I am currently loading the currentStage of the player.");
			getGsm().getLoader().stateSwitcher(getGsm().getLoader().getPast(), getGsm().getLoader().getCurrent());
			System.out.println("Switched to the Inventory of the player");
			getGsm().getKey().start = false;
		}
		
		if(getGsm().getKey().attack)
		{
			getGsm().getLoader().setState(getGsm().getLoader().getShold().waterStage);
		}
	}
	
	void render(Graphics g)
	{
		getLm().render(g);
	}
}