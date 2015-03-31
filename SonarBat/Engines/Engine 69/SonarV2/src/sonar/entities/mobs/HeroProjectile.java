package sonar.entities.mobs;

import sonar.entities.Sprite;

public class HeroProjectile extends Projectile
{
	public static final int FIRERATE = 15; //Higher is slower
	protected HeroProjectile(Sprite sprite, int x, int y, double dir, double speed, double range, double damage)
	{
		super(sprite, x, y, dir, speed, range, damage);
	}
}