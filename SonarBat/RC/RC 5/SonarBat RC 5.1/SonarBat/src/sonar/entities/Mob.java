package sonar.entities;

import sonar.graphics.Sprite;
import sonar.screen.Screen;
import sonar.sprite.Holder;

public class Mob extends Entity
{
	//Mob specifics
	private double x, y;
	private boolean dead = false;
	private int dir = 0;
	private boolean walking;
	private Holder hold;
	private int animation = 0;
	
	protected Mob(Sprite sprite, int x, int y)
	{
		super(sprite);
		hold = new Holder();
		this.x = x;
		this.y = y;
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
			x += xa;
			y += ya;
		}
	}
	
	//Tthis should only exist in the mob class
	private boolean collision(int xa, int ya)
	{
		boolean solid = false;
		for(int c = 0; c <4; c++)
		{
			int xlt = (((int)x + xa) + c % 2 * 4 + 2) / 16;
			int xrt = (((int)x + xa) + c % 2 * 4 + 13) / 16;
			int ydt = (((int)y + ya)+ c / 2 * 12 + 19) / 16;
			int yut = (((int)y + ya)+ c / 2 * 12 - 5) / 16;
			if(getLevel() == null) System.out.println("My level is null");
			if(c == 0) if(getLevel().getTile(xlt, ydt).solid()) solid = true;
			if(c == 1) if(getLevel().getTile(xrt, ydt).solid()) solid = true;
			if(c == 2) if(getLevel().getTile(xrt, ydt).solid()) solid = true;
			if(c == 3) if(getLevel().getTile(xrt, yut).solid()) solid = true;
		}
		
		//System.out.println((x+xa)/16 + ", " + (y+ya)/16);
		return solid;
	}
	
	//This one should be universal to all mobs
	public void render(Screen screen)
	{
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
		
		screen.renderMob((int) x, (int) y, this, flip);
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
	
	public void dead()
	{
		dead = true;
	}
	
	public boolean isDead()
	{
		return dead;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getDir()
	{
		return dir;
	}
	
	protected void setX(double value)
	{
		x += value;
	}
	
	protected void setY(double value)
	{
		y += value;
	}
	
	protected void setAnimation()
	{
		animation++;
	}
	
	protected void setAnimation(int value)
	{
		animation = value;
	}
	
	protected int getAnimation()
	{
		return animation;
	}
	
	protected boolean getWalking()
	{
		return walking;
	}
	
	protected void setWalking(boolean value)
	{
		walking = value;
	}
}