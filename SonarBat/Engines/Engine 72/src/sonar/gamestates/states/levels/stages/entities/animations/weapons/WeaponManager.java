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
		sonarWave = new Weapon(new SonarWaveWeaponBuilder(41, 63));
		sonarWave.setCurAnim(new StaticAnimation(manage.grass));
		
		//Weapons that are acquired after beating bosses
		fire = new Weapon(new FireWeaponBuilder(51, 63));
		fire.setCurAnim(new StaticAnimation(manage.grass));
		grass = new Weapon(new GrassWeaponBuilder(41, 73));
		grass.setCurAnim(new StaticAnimation(manage.grass));
		electric = new Weapon(new ElectricWeaponBuilder(51, 73));
		electric.setCurAnim(new StaticAnimation(manage.grass));
		water = new Weapon(new WaterWeaponBuilder(41, 83));
		water.setCurAnim(new StaticAnimation(manage.grass));
		weapons = new Weapon[5];
		
		//Weapons list
		weapons[0] = sonarWave;
		weapons[1] = fire;
		weapons[2] = grass;
		weapons[3] = electric;
		weapons[4] = water;
	}
}