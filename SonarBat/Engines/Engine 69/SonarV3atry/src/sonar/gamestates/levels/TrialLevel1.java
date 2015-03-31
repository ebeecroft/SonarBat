package sonar.gamestates.levels;

public class TrialLevel1 extends Level
{
	TrialLevel1(String path, LevelManager lm)
	{
		super(path, lm);
	}
	
	void update()
	{
		/*if((int) (getLm().getPlayer().getX() /16) == 99 && (int) (getLm().getPlayer().getY() / 16) == 77)
		{
			getLm().setLevel(getLm().trialLevel2);
			getLm().getPlayer().setX(2 * 16);
			getLm().getPlayer().setY(73 * 16);
		}*/
	}
}