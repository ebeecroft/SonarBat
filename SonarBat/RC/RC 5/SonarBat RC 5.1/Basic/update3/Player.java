package entity;

import gamestates.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	public Player(Keyboard input)
	{
		super(0, 0);
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input)
	{
		super(x, y);
		this.input = input;
	}
	
	public void update()
	{
		int xa = 0, ya = 0;
		if(getAnimate() < 7500) setAnimate(getAnimate() + 1);
		else setAnimate(0);
		//up and down only useful for ladders
		if(input.up) setY(getY() + ya--);
		if(input.down) setY(getY() + ya++);
		if(input.left) setX(getX() + xa--);
		if(input.right) setX(getX() + xa++);
		if(input.jumping && !getJumping()) 
		{
			isJumping(true);
			setVelY(-2);
		}
		
		if(getFalling() || getJumping())
		{
			setY((float) (getY() + getVelY()));				
			setVelY(getVelY() + getGravity());
						
			if(getVelY() > getMaxSpeed())
				setVelY(getMaxSpeed());
		}
		collisionHolder();
		
		if(xa != 0 || ya != 0)
		{
			move(xa, ya);
			isWalking(true);
		}
		else
			isWalking(false);
		
		updateShooting();
	}
	
	private void updateShooting()
	{
		//if(input.attack) shoot((int) getX(), (int) getY(), getDir());		
	}
}