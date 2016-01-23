package sonar.gamestates.states.levels.stages.entities.animations.weapons;

import sonar.Screen;
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
	
	public void render(Screen screen){screen.render(this, getX(), getY(), getWidth(), getHeight());}
	public int getX(){return buildWeapon.getX();}
	public int getY(){return buildWeapon.getY();}
	public Sprite getSprite(){return curAnim.getSprite();}
	public int getWidth(){return curAnim.getSprite().getWidth();}
	public int getHeight(){return curAnim.getSprite().getHeight();}
	String getWeaponType(){return buildWeapon.getType();}
	void setCurAnim(StaticAnimation curAnim){this.curAnim = curAnim;}
}