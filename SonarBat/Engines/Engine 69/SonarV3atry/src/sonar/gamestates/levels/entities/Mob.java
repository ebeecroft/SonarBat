package sonar.gamestates.levels.entities;

import sonar.gamestates.levels.Level;

public abstract class Mob extends Platform
{
	private int dir = 0;
	//private boolean moving = false;
	//private boolean removed = false;
	private Level level;
	private PlayerHolder holder;
	private int animate = 0;
	private boolean walking = false;
	private double playerLocationY;
	private boolean gravityRun = false;
	private boolean jumpRun = false;
	private boolean collide = false;
	//private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	Mob()
	{
		holder = new PlayerHolder();
	}
	
	/*private void remove()
	{
		removed = true;
	}
	
	private boolean isRemoved()
	{
		return removed;
	}*/
	
	void move(int xa, int ya)
	{
		//System.out.println("YA is: " + ya);
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		
		//Only for ladder
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		//-1, 0, 1
		if(xa != 0 && ya != 0)
		{
			//System.out.println("Moving on two axis");
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(!collision(xa, ya))
		{
			//setX(getX() + xa);
			setY(getY() + ya); //Only on ladder			
		}
	}
	
	void tick()
	{
		
	}
	
	public void update()
	{
		tick();
	}
	
	void shoot(int x, int y, double dir)
	{
		//Projectile p = new EchoProjectile((int) x, (int) y, (int) dir);
		//projectiles.add(p);
		//level.add(p);
		
	}
	
	void collisionCollection(int xa)
	{
		//if(isJumping())
		//{
			if(!jumpRun) //If jump has already run don't run again
			{
				if(jumpCollision())
				{
					//collide = true; //I have collided with a brick above me
					setY((int) playerLocationY); //+1
					jumpRun = true;
					//setVelY(0);
					collide = true;
				}
				//setGravity(0.05);
				System.out.println("My graivity is: " + getGravity());
			}
		//}
		
			if(xa < 0)
			{
				if(leftCollision())
				{
					setX((int) playerLocationY);
				}
				else
				{
					setX((int) getX() + xa);
				}
			}
			
			if(xa > 0)
			{
				if(rightCollision())
				{
					setX((int) playerLocationY);
				}
				else
				{
					setX((int) getX() + xa);
				}
			}
		System.out.println("After running jump collision my velocity is: " + getVelY());
		if(!collide) //If jump has collided shutdown gravity
		{
			
			if(gravityCollision())
			{
				//setFalling(false);
				if(!gravityRun)
				{
					//Only do these commands once
					gravityRun = true;
					jumpRun = false;
					setY((int) playerLocationY);
					//setJumping(false);
					setVelY(0);
					setGravity(0);
				}
			}
			else
			{
				//setFalling(true);
				gravityRun = false;
				setGravity(0.05);
			}
		}
		else
		{
			collide = false;
		}
	}
	
	private boolean rightCollision()
	{
		boolean collision = false;
		int currentBlockY = (int) (getY() / 16);
		int feetBlockY = (int) ((getY() / 16) + 1);
		int nextBlock = (int) ((getX() / 16) + 1);
		Tile object =  getLevel().getTile(nextBlock, feetBlockY);
		Tile object2 = getLevel().getTile(nextBlock, currentBlockY);
		if(object.solid() || object2.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			int spriteCorrection = getSprite().getWidth() - object.getSprite().getWidth();
			int offset = spriteCorrection;
			int playerLocation = pixelBlock - getSprite().getWidth() + offset; //+ offset; //+10
			//setVelX(0.0);
			playerLocationY = playerLocation;
		}
		return collision;
	}
	
	private boolean leftCollision()
	{
		boolean collision = false;
		int currentBlockY = (int) (getY() / 16);
		int feetBlockY = (int) ((getY() / 16) + 1);
		int nextBlock = (int) ((getX() / 16) - 1);
		Tile object =  getLevel().getTile(nextBlock, feetBlockY);
		Tile object2 = getLevel().getTile(nextBlock, currentBlockY);
		if(object.solid() || object2.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			int spriteCorrection = getSprite().getWidth() - object.getSprite().getWidth();
			int offset = spriteCorrection + 1;
			int playerLocation = pixelBlock + getSprite().getWidth() - offset; //+10
			//setVelX(0.0);
			playerLocationY = playerLocation;
		}
		return collision;
	}
	
	private boolean jumpCollision()
	{
		boolean collision = false;
		int currentBlockX = (int) (getX() / 16);
//		int currentBlockY = (int) (getY() / 16);
		int nextBlock = (int) ((getY() / 16) - 1);
		int rightBlock = (int)((getX() / 16) + 1);
		Tile object = getLevel().getTile(currentBlockX, nextBlock);
		Tile object2 = getLevel().getTile(rightBlock, nextBlock);
		if(object.solid() || object2.solid())
		{
			collision = true;
			int pixelBlock;
			int playerLocation;
			pixelBlock = nextBlock * 16;
			playerLocation = pixelBlock + 16; //+10
			setVelY(0.0);
			playerLocationY = playerLocation;
		}
		return collision;
	}
	
	private boolean gravityCollision()
	{
		boolean collision = false;
		int currentBlockX = (int) (getX() / 16);
		/*int resizer = 1;
		if(getSprite().getHeight() > 16){resizer = getSprite().getHeight() / 16;}*/
		int nextBlock = (int) ((getY() / 16) + 2); //Works for 32 height sprites
		Tile object = level.getTile(currentBlockX, nextBlock);
		if(object.solid())
		{
			collision = true;
			int pixelBlock = nextBlock * 16;
			int playerLocation = pixelBlock - getSprite().getHeight();
			playerLocationY = playerLocation;
		}
		return collision;
	}
	
	
	private boolean collision(int xa, int ya)
	{
		//System.out.println("Player X is: " + getX());
		//System.out.println("Player Y is: " + getY());
		//System.out.println("XA is: " + xa);
		//System.out.println("YA is: " + ya);
		boolean solid = false;
		for(int c = 0; c < 4; c++)
		{
			int xct = (int)(getX()) / 16;
			int yct = (int)(getY()) / 16;
			if(xa < 0)
			{
				if(getX() == 0)
				{
						//This works well for void tiles
						xct = (int)(getX() - 15 + xa) / 16;
				}
				else
				{
						//This works well for walls
						xct = (int)(getX() + xa) / 16;
				}
				//halfway between tiles and grass has issues when left is pressed
			}//up and left has issues, down and left functions perfectly, right and up has issues, right and down functions perfectly 
			if(xa > 0)
			{
					//This works well for both walls and void tiles
					xct = (int)(getX() + 11 + xa) / 16;
			}
			if(ya < 0)
			{
				if(getY() == 0)
				{
					//This works well for void tiles
					yct = (int)(getY() - 15 + ya) / 16;
				}
				else
				{
					//This works well for walls
					yct = (int)(getY() + ya) / 16;
				}
			}
			if(ya > 0)
			{
				//This works well for walls and void tiles
				yct = (int)(getY() + 11 + ya) / 16;
			}
			if(level.getTile(xct, yct).solid()) solid = true;
		}
		return solid;	
	}
	
	public void render(Screen screen, String entity)
	{
		//System.out.println("Player current X is: " + getX());
		//String entity = "Player";
		//setSprite(holder.player2);
		if(entity == "Player")
		{
			//holder = new PlayerHolder();
			int flip = 0;
			if(dir == 0) //Player goes up
			{
				setSprite(holder.playerBack);
				if(getWalking())
					if(getAnimate() % 20 > 10)
						setSprite(holder.playerBackward1);
					else
					{
						flip = 1;
						setSprite(holder.playerBackward1);
					}
			}
			if(dir == 1) //Player goes left
			{
				setSprite(holder.playerSide);
				if(getWalking())
					if(getAnimate() % 20 > 10)
						setSprite(holder.playerSide2);
					else
						setSprite(holder.playerSide1);
			}
			if(dir == 2) //Player goes down
			{
				setSprite(holder.playerForward);
				if(getWalking())
					if(getAnimate() % 20 > 10)
						setSprite(holder.playerForward1);
					else
					{
						flip = 1;
						setSprite(holder.playerForward1);
					}
			}
			if(dir == 3) //Player goes right
			{
				flip = 1;
				setSprite(holder.playerSide);
				if(getWalking())
					if(getAnimate() % 20 > 10)
						setSprite(holder.playerSide1);
					else
						setSprite(holder.playerSide2);
			}
			screen.renderPlayer((int) getX(), (int) getY(), this, flip);
		}
	}
	
	public void setLevel(Level level){this.level = level;}
	Level getLevel() {return level;}
	void setAnimate(int value){animate = value;}
	int getAnimate(){return animate;}
	void setWalking(boolean walking){this.walking = walking;}
	boolean getWalking(){return walking;}
	int getDir(){return dir;}
}