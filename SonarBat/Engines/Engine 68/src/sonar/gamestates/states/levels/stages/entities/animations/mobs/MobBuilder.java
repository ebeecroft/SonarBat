package sonar.gamestates.states.levels.stages.entities.animations.mobs;

public interface MobBuilder
{
	int getX();
	int getY();
	String getType();
}

class CharacterMobBuilder implements MobBuilder
{
	private int x, y;
	CharacterMobBuilder(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX(){return x;}
	public int getY(){return y;}
	public String getType(){return "Character";}
}