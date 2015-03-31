package sonar.sprite;

import sonar.graphics.Sprite;
import sonar.graphics.SpriteSheet;

public class ParticleSprite
{
	Sprite particle_normal;
	ParticleSprite()
	{
		SpriteSheet particles = new SpriteSheet("/textures/sheets/projectiles/h_projectile.png");
		particle_normal = new Sprite(0, 0, 16, 16, particles);
	}
}