package sonar.gamestates.states.levels.stages.entities.animations.mobs;

import sonar.gamestates.Screen;
import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.Sprite;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public class Mob extends Entity
{
	private MobBuilder buildMob;
	private DynamicAnimation curAnim;
	Mob(MobBuilder buildMob)
	{
		super("Mob");
		this.buildMob = buildMob;
	}
	
	void update()
	{
		
	}
	
	public void render(Screen screen)
	{
		screen.renderMob(this);
	}
	
	public int getX(){return buildMob.getX();}
	public int getY(){return buildMob.getY();}
	public Sprite getSprite(){return curAnim.getSprite();}
	public int getWidth(){return curAnim.getSprite().getWidth();}
	public int getHeight(){return curAnim.getSprite().getHeight();}
	String getMobType(){return buildMob.getType();}
	void setCurAnim(DynamicAnimation curAnim){this.curAnim = curAnim;}
	DynamicAnimation getCurAnim(){return curAnim;}
	MobBuilder getBuildMob(){return buildMob;}
}