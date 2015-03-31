package sonar.gamestates;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter
{
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public boolean attack, jump;
	
	Keyboard(GameStateManager gsm)
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