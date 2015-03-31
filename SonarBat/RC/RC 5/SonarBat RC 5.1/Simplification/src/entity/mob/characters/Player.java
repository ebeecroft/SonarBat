package entity.mob.characters;

import start.gamestate.Keyboard;

public class Player extends Character
{
	private PlayerControls controls; //Only useful for the player
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
		controls = new PlayerControls();
	}
	
	public void update()
	{
		//getChange().setXa(0);
		//getChange().setYa(0);
		int xa = 0, ya = 0;
		getPlay().playScene(getAnimate());
		//if(input.up) setY(getY() + ya--);
		//if(input.down) setY(getY() + ya++);
		//int xa = 0;//ya = 0;
		if(input.left) getCollide().getForce().setVelX(xa--);
		{
			System.out.println("Xa is" + xa);
			//change.setXa(xa--);
			//System.out.println("My xa in change is set to: " + change.getXa());
		}
		if(input.right) getCollide().getForce().setVelX(xa++);
		if(input.jump && getCollide().getForce().getDownForce().getGravity() == 0)
		{
			getCollide().getForce().setVelY(-2);
			getCollide().getForce().getDownForce().setGravity(0.05);
		}
		//System.out.println("My xa position is: " + xa);
		//force.setVelX(xa);
		//controls.keys(input, getCollide().getForce(), getChange(), xa); //Works to here
		getSetup().getMove().move(xa, ya); //This is the most simple
		
		getCollide().collision(getPosition(), getImage(), getChange().getXa());
		/*if(xa != 0 || ya != 0)
		{
			move(xa, ya);
			setWalking(true); //VelX = something
		}
		else
			setWalking(false);
		*/
		
		//System.out.println("My current xa is: " + getChange().getXa());
		//System.out.println("My velocity of x is: " + getCollide().getForce().getVelX()); //Velocity is zero
		getPosition().setX(getPosition().getX() + (int) getCollide().getForce().getVelX());
		getFall().fall(getCollide().getForce(), getPosition());
		getMove().mobMove(getChange(), getStroll(), getSetup().getMove());
	}
}


/*private Keyboard input;

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
//	if(input.up) setY(getY() + ya--);
//	if(input.down) setY(getY() + ya++);
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
}*/