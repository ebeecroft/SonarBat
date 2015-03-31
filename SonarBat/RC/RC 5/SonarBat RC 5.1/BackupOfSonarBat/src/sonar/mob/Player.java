package sonar.mob;

import sonar.entities.Mob;
import sonar.graphics.Sprite;
import sonar.input.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	private int anim = 0;
	private boolean walking;
	//2:25 page 48
	public Player(Sprite sprite, Keyboard input)
	{
		super(sprite, 0, 0);
		this.input = input;
	}
	
	public Player(Sprite sprite, Keyboard input, int x, int y)
	{
		super(sprite, x, y);
		this.input = input;
	}
	
	//43 stopped/finished
	public void update()
	{
		int xa = 0, ya = 0;
		if(anim < 7500) anim++;
		else anim = 0;
		setAnimation(anim);
		
		
		
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0)
		{
			move(xa, ya);
			walking = true;
		}
		else
		{
			walking = false;
		}
		setWalking(walking);
	}
	
	public Keyboard getKeyboard()
	{
		return input;
	}
}