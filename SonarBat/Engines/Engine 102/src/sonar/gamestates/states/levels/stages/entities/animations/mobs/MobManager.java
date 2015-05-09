package sonar.gamestates.states.levels.stages.entities.animations.mobs;

import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public class MobManager
{
	public Mob starterMob;
	
	public MobManager(SpriteManager manage, String level)
	{
		if(level.equals("StarterLevel1")) buildStarterLevel1(manage);
		if(level.equals("StarterLevel2")) buildStarterLevel2(manage);
		if(level.equals("StarterLevel3")) buildStarterLevel3(manage);
		if(level.equals("StarterLevel4")) buildStarterLevel4(manage);
	}
	
	private void buildStarterLevel1(SpriteManager manage)
	{
		//SonarBat Mob
		starterMob = new SonarBat(new CharacterMobBuilder(40, 40));
		starterMob.setUp(new DynamicAnimation(manage.starterMobUp, manage.starterMobUp1, manage.starterMobUp2));
		starterMob.setDown(new DynamicAnimation(manage.starterMobUp, manage.starterMobUp1, manage.starterMobUp2));
		starterMob.setLeft(new DynamicAnimation(manage.starterMobUp, manage.starterMobUp1, manage.starterMobUp2));
		starterMob.setRight(new DynamicAnimation(manage.starterMobUp, manage.starterMobUp1, manage.starterMobUp2));
		starterMob.setCurAnim(starterMob.getUp());
		starterMob.setPlayer(true);
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

interface MobBuilder
{
	int getX();
	int getY();
	String getType();
}

class CharacterMobBuilder implements MobBuilder
{
	private int x, y;
	private boolean player;
	private DynamicAnimation up, down, left, right;
	CharacterMobBuilder(int x, int y)
	{
		this.x = x;
		this.y = y;
		player = false;
	}
	void setUp(DynamicAnimation animation){up = animation;}
	void setDown(DynamicAnimation animation){down = animation;}
	void setLeft(DynamicAnimation animation){left = animation;}
	void setRight(DynamicAnimation animation){right = animation;}
	void setPlayer(boolean value){player = value;}
	DynamicAnimation getUp(){return up;}
	DynamicAnimation getDown(){return down;}
	DynamicAnimation getLeft(){return left;}
	DynamicAnimation getRight(){return right;}
	boolean getPlayer(){return player;}
	public int getX(){return x;}
	public int getY(){return y;}
	public String getType(){return "Character";}
}