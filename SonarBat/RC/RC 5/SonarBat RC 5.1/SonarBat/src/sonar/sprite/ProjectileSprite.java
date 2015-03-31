package sonar.sprite;

import sonar.graphics.Sprite;
import sonar.graphics.SpriteSheet;

public class ProjectileSprite
{
	Sprite projectile_hero;
	ProjectileSprite()
	{
		SpriteSheet projectileHero = new SpriteSheet("/textures/sheets/projectiles/h_projectile.png");
		projectile_hero = new Sprite(0, 0, 16 , 16, projectileHero);
	}
}