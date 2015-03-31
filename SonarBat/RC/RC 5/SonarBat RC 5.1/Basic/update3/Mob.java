package entity;


public class Mob extends Platformer
{
	private PlayerHolder holder;
	private int animate;
	private boolean walking;
	private int dir;
	private boolean gravityRun = false;
	private boolean onLadder = false;
	private LifeBar playerlife;
	private float locationY;
	private boolean jumpRun = false;
	private boolean collide = false;
	
	
	//private List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Mob(int x, int y)
	{
		//Gravity Attributes
		setX(x);
		setY(y);
		isFalling(true);// = true;
		isJumping(false);//jumping = false;
		
		//Movement attributes
		walking = false;
		holder = new PlayerHolder();
		dir = 0;
		animate = 0;
		playerlife = new LifeBar(0, 400, holder.plife);
	}
	
	void move(int xa, int ya)
	{
		System.out.println("YA is: " + ya);
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		
		//Only for ladder
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
		
		//-1, 0, 1
		if(xa != 0 && ya != 0)
		{
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		/*if(collision(xa, ya))
		{
			//if(getLevel().getTile(xa, ya))
			setX(getX() + xa);
			setY(getY() + ya); //Only on ladder			
		}*/
		
		if(!collision(xa, ya))
		{
			setX(getX() + xa);
			//setY(getY() + ya); //Only on ladder
			//isFalling(true);
		}
		else
		{
			if(onLadder)
			{
				setY(getY() + ya);
				setVelY(0);
				isFalling(false);
			}
		}
	}
	
	//Perfect Gravity collision
	
	void collisionHolder()
	{
		if(!jumpRun) //If jump has already run don't run again
		{
			if(jumpCollision())
			{
				collide = true; //I have collided with a brick above me
				setY((int) getLocationY() +1);
				jumpRun = true;
				setVelY(0);
			}
		}
		
		if(!collide) //If jump has collided shutdown gravity
		{
			if(gravityCollision())
			{
				//Sets to the correct stuff for gravity
				if(!gravityRun)
				{
					gravityRun = true;
					jumpRun = false; //Never true till gravity collision
					setVelY(0);
					setY((int) getLocationY());
				}
			}
			else
			{
				gravityRun = false;
			}
		}
		else
		{
			collide = false;
		}
	}
	
	private boolean jumpCollision()
	{
		boolean solid = false;
		int playerYblock = (int)(getY() /16);
		int nextPblock = playerYblock - 1;
		int currentBlockX = (int) (getX() / 16);
		Tile object = getLevel().getTile(currentBlockX, nextPblock);
		if(object.solid())
		{
			int truePixelBlock = nextPblock * 16;
			int playerLocation = truePixelBlock + getSprite().getHeight();
			locationY = playerLocation;
			solid = true;
		}
		return solid;
	}
	
	private boolean gravityCollision()
	{
		//Checks for the next tile below the players current one
		boolean solid = false;
		int nextBlock = (int) ((getY()/16) + 1); //464
		int blockPixels = nextBlock * 16;
		int playerLocation = blockPixels - getSprite().getHeight();
		locationY = playerLocation; //Sets the players Y location 		
		int currentBlockX = (int) (getX() / 16); 
		Tile object = getLevel().getTile((int) currentBlockX, (int) nextBlock);
		if(object.solid())
		{
			solid = true;
			isFalling(false);
			isJumping(false);
		}
		else
		{
			isFalling(true);
		}
		return solid;
	}
	
	private boolean collision(int xa, int ya)
	{
		boolean solid = false;
		onLadder = false;
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
					//setVelY(0);
				}
			}
			if(ya > 0)
			{
				//This works well for walls and void tiles
				yct = (int)(getY() + 11 + ya) / 16;
			}
			
			System.out.println("What tile: " + getLevel().getTile(xct,  yct));
			if(getLevel().getTile(xct, yct).getType() == "Ladder")
			{
				onLadder = true;
				solid = true;
			}
			/*if(getLevel().getTile(xct, yct) == holder2.ladderTile)
			{
				solid = false;
				onLadder = true;
				System.out.println("I am hitting a ladder");
			}*/
			if(getLevel().getTile(xct, yct).solid())
			{
				solid = true;
			}
		}
		return solid;	
	}
	
	void shoot(int x, int y, double dir)
	{
		if(dir == 1 || dir == 3)
		{
			//Projectile p = new EchoProjectile((int) x, (int) y, (int) dir, 5);
			//projectiles.add(p);
			//level.add(p);
		}
	}
	
	void update() //Mob is the base update class for all mobs
	{
		
	}
	
	public void render(Screen screen, String mob) //Only one Render should ever exist
	{
		if(mob == "Player")
		{
			int flip = 0;
			if(dir == 0)
			{
				setSprite(holder.trial);
				if(walking)
					if(animate % 20 > 10)
						setSprite(holder.trial);
					else
						setSprite(holder.trial);
			}
			if(dir == 1)
			{
				setSprite(holder.trial);
				if(walking)
					if(animate % 20 > 10)
						setSprite(holder.trial);
					else
						setSprite(holder.trial);
			}
			if(dir == 2)
			{
				setSprite(holder.trial);
				if(walking)
					if(animate % 20 > 10)
						setSprite(holder.trial);
					else
						setSprite(holder.trial);
			}
			if(dir == 3)
			{
				flip = 1;
				setSprite(holder.trial);
				if(walking)
					if(animate % 20 > 10)
						setSprite(holder.trial);
					else
						setSprite(holder.trial);
			}
			screen.renderPlayer((int) getX(), (int) getY(), this, flip);
			//playerlife.render(screen);
		}
		if(mob == "Projectile");
		if(mob == "Npc");
	}
	
	int getAnimate(){return animate;}
	void setAnimate(int frame){animate = frame;}
	boolean getWalking(){return walking;}
	void isWalking(boolean walking){this.walking = walking;}
	public LifeBar getLife(){return playerlife;}
	public float getLocationY(){return locationY;}
}