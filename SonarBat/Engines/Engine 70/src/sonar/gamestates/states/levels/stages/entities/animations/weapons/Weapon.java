package sonar.gamestates.states.levels.stages.entities.animations.weapons;

import sonar.gamestates.Screen;
import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.Sprite;
import sonar.gamestates.states.levels.stages.entities.animations.StaticAnimation;

public class Weapon extends Entity
{
	private WeaponBuilder buildWeapon;
	private StaticAnimation curAnim;
	Weapon(WeaponBuilder buildWeapon)
	{
		super("Weapon");
		this.buildWeapon = buildWeapon;
	}
	
	void update()
	{
		
	}
	
	void render(Screen screen)
	{
		screen.renderWeapon(this);
	}
	
	int getX(){return buildWeapon.getX();}
	int getY(){return buildWeapon.getY();}
	Sprite getSprite(){return curAnim.getSprite();}
	int getWidth(){return curAnim.getSprite().getWidth();}
	int getHeight(){return curAnim.getSprite().getHeight();}
	String getWeaponType(){return buildWeapon.getType();}
	void setCurAnim(StaticAnimation curAnim){this.curAnim = curAnim;}
}