package sonar.sprite;

public class Holder
{
	public ParticleSprite particle;
	public PlayerSprite player;
	public ProjectileSprite projectile;
	public TileSprite tile;
	
	public Holder()
	{
		particle = new ParticleSprite();
		player = new PlayerSprite();
		projectile = new ProjectileSprite();
		tile = new TileSprite();
	}
}