package sonar.gamestates.states.levels.stages.entities.animations.mobs;

import sonar.gamestates.Screen;
import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.Sprite;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public abstract class Mob extends Entity
{
	private MobBuilder buildMob;
	private DynamicAnimation curAnim;
	Mob(MobBuilder buildMob)
	{
		super("Mob");
		this.buildMob = buildMob;
	}
	
	abstract void update();
	public void render(Screen screen){screen.render(this, getX(), getY(), getWidth(), getHeight());}
	public int getX(){return buildMob.getX();}
	public int getY(){return buildMob.getY();}
	public Sprite getSprite(){return curAnim.getSprite();}
	public int getWidth(){return curAnim.getSprite().getWidth();}
	public int getHeight(){return curAnim.getSprite().getHeight();}
	String getMobType(){return buildMob.getType();}
	void setCurAnim(DynamicAnimation curAnim){this.curAnim = curAnim;}
	DynamicAnimation getCurAnim(){return curAnim;}
	MobBuilder getBuildMob(){return buildMob;}
	void setUp(DynamicAnimation animation)
	{
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			character.setUp(animation);
		}
	}
	void setDown(DynamicAnimation animation)
	{
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			character.setDown(animation);
		}
	}
	void setLeft(DynamicAnimation animation)
	{
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			character.setLeft(animation);
		}
	}
	void setRight(DynamicAnimation animation)
	{
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			character.setRight(animation);
		}
	}
	void setPlayer(boolean value)
	{
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			character.setPlayer(value);
		}
	}
	DynamicAnimation getUp()
	{
		DynamicAnimation animation = null;
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			animation = character.getUp();
		}
		return animation;
	}
	DynamicAnimation getDown()
	{
		DynamicAnimation animation = null;
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			animation = character.getDown();
		}
		return animation;
	}
	DynamicAnimation getLeft()
	{
		DynamicAnimation animation = null;
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			animation = character.getLeft();
		}
		return animation;
	}
	DynamicAnimation getRight()
	{
		DynamicAnimation animation = null;
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			animation = character.getRight();
		}
		return animation;
	}
	boolean getPlayer()
	{
		boolean value = false;
		if(buildMob.getType().equals("Character"))
		{
			CharacterMobBuilder character = (CharacterMobBuilder) buildMob;
			value = character.getPlayer();
		}
		return value;
	}
}