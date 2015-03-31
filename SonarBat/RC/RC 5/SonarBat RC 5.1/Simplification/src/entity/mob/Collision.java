package entity.mob;

import entity.Image;
import entity.Location;
import entity.tile.Tile;

public class Collision
{	
	private boolean jumpRun; //Maybe maynot
	private int mobPosition; //Players position
	private Map map;
	private Force force;
	
	Collision()
	{
		map = new Map();
		force = new Force();
	}
	
	public void collision(Location position, Image image, int xa)
	{
		boolean collide = false;
		if(force.getDownForce().getGravity() != 0) //Do not check for jumping collisions if we are on the ground
		{
			if(!jumpRun) //If jump has already collided don't keep checking jumping
			{
				collide = jumpCollision(position);
				if(collide)
				{
					jumpRun = true;
					position.setY(mobPosition);
					force.setVelY(0);
				}
				//System.out.println("My graivity is: " + getGravity());
			}			
		}
		
		if(!collide) //If jump has collided shutdown gravity
		{
			if(gravityCollision(position, image))
			{
				if(force.getDownForce().getGravity() != 0)
				{
					jumpRun = false;
					position.setY(mobPosition);
					force.getDownForce().setGravity(0);
					force.setVelY(0);
				}
			}
			else force.getDownForce().setGravity(0.05);
		}
		else
		{
			collide = false;
		}
		
		//Side Scrolling
		if(xa < 0) //Only do this if xa is not 0
		{
			if(leftCollision(position, image))
			{
				position.setX(mobPosition);
				force.setVelX(0);
			}
			else force.setVelX(xa);
		}
		
		//Side Scrolling
		if(xa > 0)
		{
			if(rightCollision(position, image))
			{
				position.setX(mobPosition);
				force.setVelX(0);
			}
			else force.setVelX(xa);
		}
	}
	
	private boolean jumpCollision(Location position)
	{
		boolean collision = false;

		//Different Blocks near the player
		int nextBlock = (position.getY() / 16) - 1; //(int) ((getY() / 16) - 1);
		int currentBlockX = position.getX() / 16; //(int) (getX() / 16);
		int rightBlockX = (position.getX() / 16) + 1; //(int)((getX() / 16) + 1);
		
		//Two different Tiles near player
		Tile overhead = map.getLevel().getTile(currentBlockX, nextBlock);//map.getLevel().getTile(currentBlockX, nextBlock);
		Tile right = map.getLevel().getTile(rightBlockX, nextBlock); //map.getLevel().getTile(rightBlockX, nextBlock);
		
		//Checks if player can pass through the object
		if(overhead.solid() || right.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16; 
			mobPosition = pixelBlock + 16; //Think about sprite decisions here;
		}
		return collision;
	}
	
	private boolean gravityCollision(Location position, Image image)
	{
		boolean collision = false;
		
		//Different Blocks near the player
		int nextBlock = (position.getY() / 16) + 2; //(int) ((getY() / 16) + 2); //Works for 32 height sprites
		int currentBlockX = position.getX() / 16;//(int) (getX() / 16);
		int leftBlockX = (position.getX() / 16) - 1; //Perhaps will fix left bug
		
		//Two different Tiles near player
		Tile below = map.getLevel().getTile(currentBlockX, nextBlock);
		Tile left = map.getLevel().getTile(leftBlockX, nextBlock);
		
		/*int resizer = 1;
		if(getSprite().getHeight() > 16){resizer = getSprite().getHeight() / 16;}*/
		
		//Checks if player can pass through the object
		if(below.solid() || left.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			mobPosition = pixelBlock - image.getSprite().getPhold().getDimension().getHeight();//getSprite().getHeight();
		}
		return collision;
	}
	
	private boolean leftCollision(Location position, Image image)
	{
		boolean collision = false;
		
		//Different Blocks near the player
		int nextBlock = (position.getX() / 16) - 1;//(int) ((getX() / 16) - 1);
		int currentBlockY = position.getY() / 16; //(int) (getY() / 16);
		int feetBlockY = (position.getY() / 16) + 1;//(int) ((getY() / 16) + 1);
		
		//Two different Tiles near player
		Tile head = map.getLevel().getTile(nextBlock, currentBlockY);
		Tile feet =  map.getLevel().getTile(nextBlock, feetBlockY);
		
		if(head.solid() || feet.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			int spriteCorrection = image.getSprite().getPhold().getDimension().getWidth() - feet.getImage().getSprite().getPhold().getDimension().getWidth(); //getSprite().getWidth() - object.getSprite().getWidth();
			int offset = spriteCorrection + 1;
			mobPosition = pixelBlock + image.getSprite().getPhold().getDimension().getWidth() - offset;
		}
		return collision;
	}
	
	private boolean rightCollision(Location position, Image image)
	{
		boolean collision = false;
		
		//Different Blocks near the player
		int nextBlock = (position.getX() / 16) + 1; //(int) ((getX() / 16) + 1);
		int currentBlockY = position.getY() / 16;//(int) (getY() / 16);
		int feetBlockY = (position.getY() / 16) + 1; //(int) ((getY() / 16) + 1);
		
		//Two different Tiles near player
		Tile feet =  map.getLevel().getTile(nextBlock, feetBlockY);
		Tile head = map.getLevel().getTile(nextBlock, currentBlockY);
		
		//Checks if player can pass through the object
		if(feet.solid() || head.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			int spriteCorrection = image.getSprite().getPhold().getDimension().getWidth() - feet.getImage().getSprite().getPhold().getDimension().getWidth();
			int offset = spriteCorrection;
			mobPosition = pixelBlock - image.getSprite().getPhold().getDimension().getWidth() + offset; //+ offset; //+10
		}
		return collision;
	}
	
	public Force getForce(){return force;}
	public Map getMap(){return map;}
}