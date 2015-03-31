package sonar.level;

public class LevelHolder
{
	public Level zapStage;
	public Level waterStage;
	public LevelHolder()
	{
		zapStage = new ZapLevel("/textures/levels/levelmap.png");
		waterStage = new WaterLevel("/textures/levels/waterlevel.png");
	}
}