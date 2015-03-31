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