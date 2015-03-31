package sonar.gamestates;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Keyboard extends KeyAdapter
{
	/*The Keyboard class  is a special type of class that allows the player to be able
	 * to utilize keys so that they can perform movement, attacking, or jumping. By
	 * reading in a specific key we can determine what action that we need to perform
	 * at that specific stage. If the key is released then we stop performing that
	 * given action. By adding the KeyListener to the keyboard class we don't need to
	 * have the game class implement the keyboard since it is not needed outside of
	 * the GSM for right now. The other thing we need to check is if we are pressing
	 * opposite keys and if we are then we need to set both keys to false to prevent
	 * unpredictable behavior from happening.
	 * 
	 */
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public boolean attack, jump, start;
	
	Keyboard(GSM gsm)
	{
		gsm.getGame().addKeyListener(this);
	}
	
	void update()
	{
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		if(up && down)
		{
			up = false;
			down = false;
		}
		
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		if(left && right)
		{
			left = false;
			right = false;
		}
		
		attack = keys[KeyEvent.VK_J];
		jump = keys[KeyEvent.VK_F];
		start = keys[KeyEvent.VK_S];
	}
	
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}
}