package sonar.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sonar.Game;

public class Keyboard implements KeyListener
{
	private boolean[] keys;
	public boolean up, down, left, right, jump, attack;
	public Keyboard(Game game)
	{
		keys = new boolean[120];
		game.addKeyListener(this);
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		attack = keys[KeyEvent.VK_K];
	}

	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e)
	{
		
	}	
}