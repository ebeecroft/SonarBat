package sonar.entities;

public class Holder
{
	public ParticleSprite particle;
	public PlayerSprite player;
	public ProjectileSprite projectile;
	
	public Holder()
	{
		particle = new ParticleSprite();
		player = new PlayerSprite();
		projectile = new ProjectileSprite();
	}
}