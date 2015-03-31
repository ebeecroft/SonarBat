package sonar.projectile;

import sonar.graphics.Sprite;
import sonar.mob.Projectile;

public class HeroProjectile extends Projectile
{
	public static final int FIRERATE = 15; //Higher is slower
	protected HeroProjectile(Sprite sprite, int x, int y, double dir, double speed, double range, double damage)
	{
		super(sprite, x, y, dir, speed, range, damage);
	}
}