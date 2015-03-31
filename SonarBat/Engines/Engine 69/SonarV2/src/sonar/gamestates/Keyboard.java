package sonar.gamestates;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//RealTuts Version
public class Keyboard extends KeyAdapter
{
	private boolean[] keys;
	public boolean up, down, left, right;
	boolean jump, attack;
	
	//Foreign Guy Version
	Keyboard(GameStateManager gsm)
	{
		//VanZeben Version
		keys = new boolean[120];
		gsm.getGame().addKeyListener(this);
	}
	
	//Cherno Version
	void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		attack = keys[KeyEvent.VK_K];
		jump = keys[KeyEvent.VK_J];
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