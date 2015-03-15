package sonar.gamestates.states.levels.stages.entities.animations.mobs;

import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public class MobManager
{
	private Mob starterMob;
	
	MobManager(SpriteManager manage, String level)
	{
		if(level.equals("StarterLevel1")) buildStarterLevel1(manage);
		if(level.equals("StarterLevel2")) buildStarterLevel2(manage);
		if(level.equals("StarterLevel3")) buildStarterLevel3(manage);
		if(level.equals("StarterLevel4")) buildStarterLevel4(manage);
	}
	
	private void buildStarterLevel1(SpriteManager manage)
	{
		starterMob = new Mob(new CharacterMobBuilder(40, 40));
		starterMob.setCurAnim(new DynamicAnimation(manage.cornerDownLeft, manage.cornerDownRight, manage.cornerUpLeft, manage.cornerUpRight));
	}
	
	private void buildStarterLevel2(SpriteManager manage)
	{
		
	}
	
	private void buildStarterLevel3(SpriteManager manage)
	{
		
	}
	
	private void buildStarterLevel4(SpriteManager manage)
	{
		
	}
}