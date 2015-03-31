package sonar.entities;

import sonar.level.Level;

public class Mob extends Entity
{
	//Mob specifics
	private boolean dead = false;
	private int dir = 0;
	private boolean walking;
	private Holder hold;
	private int animation = 0;
	private Level level;
	
	public Mob()
	{
		hold = new Holder();
	}
	
	//This is universal for all mobs
	protected void move(int xa, int ya)
	{
		if(xa != 0 && ya != 0)
		{
			//allows sliding
			move(xa, 0);
			move(0, ya);
			return;
		}
			
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		
		if (!collision(xa, ya))
		{
		    //x = -1, 0, 1
			setX(getX() + xa);
			setY(getY() + ya);
		}
	}
	
	//Tthis should only exist in the mob class
	private boolean collision(int xa, int ya)
	{
		boolean solid = false;
		for(int c = 0; c <4; c++)
		{
			int xlt = ((getX() + xa) + c % 2 * 4 + 2) / 16;
			int xrt = ((getX() + xa) + c % 2 * 4 + 13) / 16;
			int ydt = ((getY() + ya)+ c / 2 * 12 + 19) / 16;
			int yut = ((getY() + ya)+ c / 2 * 12 - 5) / 16;
			if(level == null) System.out.println("My level is null");
			if(c == 0) if(level.getTile(xlt, ydt).solid()) solid = true;
			if(c == 1) if(level.getTile(xrt, ydt).solid()) solid = true;
			if(c == 2) if(level.getTile(xrt, ydt).solid()) solid = true;
			if(c == 3) if(level.getTile(xrt, yut).solid()) solid = true;
		}
		
		//System.out.println((x+xa)/16 + ", " + (y+ya)/16);
		return solid;
	}
	
	//This one should be universal to all mobs
	public void render(Screen screen)
	{
		String entity = "Player";
		if(entity == "Player");
		//Should be used for players, npc, and projectiles
		int flip = 0;
		
		if(dir == 0) 
		{
			setSprite(hold.player.player_forward);
			//sprite = Sprite.player_forward;
			if(getWalking())
			{
				if (getAnimation() % 20 > 10)
				{
					setSprite(hold.player.player_forward_1);
				}
				else
				{
					flip = 1;
					setSprite(hold.player.player_forward_1);
				}
			}
		}
		if(dir == 1) 
		{
			setSprite(hold.player.player_side);
			if(walking)
			{
				if (animation % 20 > 10)
				{
					setSprite(hold.player.player_side_1);
				}
				else
				{
					setSprite(hold.player.player_side_2);
				}
			}
		}
		if(dir == 2) 
		{
			setSprite(hold.player.player_backward);
			if(walking)
			{
				if (animation % 20 > 10)
				{
					setSprite(hold.player.player_backward_1);
				}
				else
				{
					flip = 1;
					setSprite(hold.player.player_backward_1);
				}
			}
		}
		//if(dir == 3) sprite = Sprite.player_left;
		if (dir == 3)
		{
			setSprite(hold.player.player_side); //player sprite faces left
			if(walking)
			{
				if (animation % 20 > 10)
				{
					setSprite(hold.player.player_side_1);
				}
				else
				{
					flip = 1;
					setSprite(hold.player.player_side_2);
				}
			}
			flip = 1;
			
		}
		
		screen.renderMob(getX(), getY(), this, flip);
		//screen.renderProjectile((int) x + 8, (int) y + 2, this);
		//screen.renderNpc((int) x, (int) y, this, 0);
	}
	
	//This should also be universal to all mobs
	void shoot(int x, int y, double dir)
	{
		//dir = dir * (180 / Math.PI);
		//Projectile p = new HeroProjectile(x, y, dir);
		//level.add(p);
		//System.out.println("Angle: " + dir);
	}
	
	public void dead(){dead = true;}
	public boolean isDead(){return dead;}
	public int getDir(){return dir;}
	protected void setAnimation(){animation++;}
	protected void setAnimation(int value){animation = value;}
	protected int getAnimation(){return animation;}
	protected boolean getWalking(){return walking;}
	protected void setWalking(boolean value){walking = value;}
	public void setLevel(Level level){this.level = level;}
}