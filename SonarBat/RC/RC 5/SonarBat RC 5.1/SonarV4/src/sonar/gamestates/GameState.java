package sonar.gamestates;

import java.awt.Graphics;

class GameState
{
	/*This is the basic gameState class. Every gamestate needs a gsm to manage the
	 * various states. Also it needs a update and render function for the base
	 * class. The dual and single state flags keeps track of what type of state we
	 * are in. Dual state is if we are running two states at once. Single state is
	 * if we are only using one state at a time.
	 */
	private GSM gsm;
	private boolean dual = false;
	private boolean single = false;

	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		
	}
	
	//Getters that are only used by subclasses
	GSM getGsm(){return gsm;}
	void setGsm(GSM gsm){this.gsm = gsm;}
	void setSingle(boolean single){this.single = single;}
	boolean isSingle(){return single;}
	void setDual(boolean dual){this.dual = dual;}
	boolean isDual(){return dual;}
}