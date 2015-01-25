package sonar.gamestates;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter
{
	//Keyboard is what the user uses to navigate the gameworld.
	private boolean[] keys = new boolean[120];
	private boolean up, down, left, right;
	private boolean start, a, b;
	
	Keyboard(GSM gsm)
	{
		gsm.getGame().addKeyListener(this);
	}
	
	void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		start = keys[KeyEvent.VK_SPACE];
		a = keys[KeyEvent.VK_A];
		b = keys[KeyEvent.VK_S];
		if(up && down)
		{
			up = false;
			down = false;
		}
		
		if(left && right)
		{
			left = false;
			right = false;
		}
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