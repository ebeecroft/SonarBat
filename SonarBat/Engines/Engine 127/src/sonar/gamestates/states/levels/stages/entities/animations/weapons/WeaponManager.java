package sonar.gamestates.states.levels.stages.entities.animations.weapons;

import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.StaticAnimation;

public class WeaponManager
{
	private Weapon sonarWave, fire, grass, electric, water;
	private Weapon[] weapons;
	public WeaponManager(SpriteManager manage)
	{
		//Primary Weapon of SonarBat
		sonarWave = new Weapon(new SonarWaveWeaponBuilder(16, 16));
		sonarWave.setCurAnim(new StaticAnimation(manage.sonarWave));
		
		//Weapons that are acquired after beating bosses
		fire = new Weapon(new FireWeaponBuilder(70, 16));
		fire.setCurAnim(new StaticAnimation(manage.fireBurn));
		grass = new Weapon(new GrassWeaponBuilder(16, 55));
		grass.setCurAnim(new StaticAnimation(manage.grassField));
		electric = new Weapon(new ElectricWeaponBuilder(70, 55));
		electric.setCurAnim(new StaticAnimation(manage.zapDash));
		water = new Weapon(new WaterWeaponBuilder(16, 94));
		water.setCurAnim(new StaticAnimation(manage.waterShot));
		weapons = new Weapon[5];
		
		//Weapons list
		weapons[0] = sonarWave;
		weapons[1] = fire;
		weapons[2] = grass;
		weapons[3] = electric;
		weapons[4] = water;
	}
	
	public Weapon[] getWeapons(){return weapons;}
}

abstract class WeaponBuilder
{
	private int x, y;
	WeaponBuilder(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	int getX(){return x;}
	int getY(){return y;}
	abstract String getType();
}

class SonarWaveWeaponBuilder extends WeaponBuilder
{
	SonarWaveWeaponBuilder(int x, int y){super(x, y);}
	String getType(){return "SonarWave";}
}

class FireWeaponBuilder extends WeaponBuilder
{
	FireWeaponBuilder(int x, int y){super(x, y);}
	String getType(){return "Fire";}
}

class GrassWeaponBuilder extends WeaponBuilder
{
	GrassWeaponBuilder(int x, int y){super(x, y);}
	String getType(){return "Grass";}
}

class ElectricWeaponBuilder extends WeaponBuilder
{
	ElectricWeaponBuilder(int x, int y){super(x, y);}
	String getType(){return "Electric";}
}

class WaterWeaponBuilder extends WeaponBuilder
{
	WaterWeaponBuilder(int x, int y){super(x, y);}
	String getType(){return "Water";}
}