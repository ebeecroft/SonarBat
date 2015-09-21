package sonar.gamestates.states.levels.stages.entities.animations.mobs;

public class SonarBat extends Mob
{
	SonarBat(MobBuilder buildMob){super(buildMob);}
	void update()
	{
		int xa = 0, ya = 0;
		byte[] movement = new byte[2];
		if(getWalking()) getCurAnim().update();
		else getCurAnim().reset();
		movement = playerControls(xa, ya, false);
		updateMovement(movement[0], movement[1]);
		setX(getX() + movement[0]);
		setY(getY() + movement[1]);
		updateAnimation(getMobDirection());
	}
}