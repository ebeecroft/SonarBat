package sonar.gamestates.levels.entities;

import sonar.gamestates.Keyboard;

public class Player extends Mob
{
	private Keyboard input;
	
	public Player(Keyboard input)
	{
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input)
	{
		setX(x);
		setY(y);
		this.input = input;
	}
	
	public void update()
	{
		int xa = 0, ya = 0;
		if(getAnimate() < 7500) setAnimate(getAnimate() + 1);
		else setAnimate(0);
		//up and down only useful for ladders
//		if(input.up) setY(getY() + ya--);
//		if(input.down) setY(getY() + ya++);
		if(input.left) xa--;//setX(getX() + xa--);
		if(input.right) xa++; //setX(getX() + xa++);
		if(input.jump && getGravity() == 0)
		{
			setVelY(-2);
			setGravity(0.05);
		}
		
		System.out.println("Velocity Y is: " + getVelY());
		if(getGravity() != 0)
		{
			setY((int) (getY() + getVelY()));
			setVelY(getVelY() + getGravity());
			if(getVelY() > getMaxSpeed())
				setVelY(getMaxSpeed());			
		}
		
		System.out.println("Player X is: " + (int) getX() / 16);
		collisionCollection(xa);
		//wall hit and player falls through ground
		if(xa != 0 || ya != 0)
		{
			move(xa, ya);
			setWalking(true); //VelX = something
		}
		else
			setWalking(false);
		
		updateShooting();
	}
	
	private void updateShooting()
	{
		if(input.attack) shoot((int) getX(), (int) getY(), getDir());		
	}
}