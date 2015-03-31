package sonar.entities.mobs;

import sonar.entities.Mob;
import sonar.gamestates.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	private int anim = 0;
	private boolean walking;
	private double gravity = 0.05;
	private double velY;
	
	//2:25 page 48
	public Player(Keyboard input)
	{
		setX(0);
		setY(0);
		this.input = input;
	}
	
	public Player(Keyboard input, int x, int y)
	{
		setX(x);
		setY(y);
		this.input = input;
	}
	
	//43 stopped/finished
	public void update()
	{
		int xa = 0, ya = 0;
		velY += gravity;
		if(anim < 7500) anim++;
		else anim = 0;
		setAnimation(anim);
		
		
		//ya += velY;
		//Up and down are restricted to ladders only
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
	
	public Keyboard getKeyboard(){return input;}
}