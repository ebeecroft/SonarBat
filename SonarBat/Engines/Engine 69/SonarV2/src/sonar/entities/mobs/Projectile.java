package sonar.entities.mobs;

import sonar.entities.Mob;
import sonar.entities.Sprite;

public class Projectile extends Mob
{
	//Specified
	private double angle;
	
	//Specified
	private double nx, ny;
	
	
	private double range, damage;
	
	//Specified
	protected int xOrigin, yOrigin;
	
	protected Projectile(Sprite sprite, int x, int y, double dir, double speed, double range, double damage)
	{
		setX(x);
		setY(y);
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.damage = damage;
		this.range = range;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update()
	{//18:26
		//if(level.tileCollision((int) (x + nx), (int) (y + ny), 7, 5, 4))
		//{
			//level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			//remove();
		//}
		move();
	}
	
	//Projectile only
	protected void move()
	{
		//setX(nx);
		//setY(ny);
		if(distance() > range) dead();
	}
	
	//Only exists in Projectile
	private double distance()
	{
		double dist = 0;
		//dist = Math.sqrt((xOrigin - getX())*(xOrigin - getX()) + (yOrigin - getY())*(yOrigin - getY()));
		return dist;
	}
}