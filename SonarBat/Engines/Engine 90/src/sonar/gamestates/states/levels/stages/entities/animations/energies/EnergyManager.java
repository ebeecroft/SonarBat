package sonar.gamestates.states.levels.stages.entities.animations.energies;

import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public class EnergyManager
{
	private Energy sonarWave, fire, grass, electric, water;
	private Energy[] energies;
	public EnergyManager(SpriteManager manage)
	{
		//Primary Energy for the sonarWave weapon
		sonarWave = new Energy(new WeaponEnergyBuilder(18, 16));
		sonarWave.setCurAnim(new DynamicAnimation(manage.sonarWave, manage.sonarWave));
		
		//Energies that are acquired after beating bosses
		fire = new Energy(new WeaponEnergyBuilder(72, 16));
		fire.setCurAnim(new DynamicAnimation(manage.fireBurn, manage.fireBurn));
		grass = new Energy(new WeaponEnergyBuilder(18, 55));
		grass.setCurAnim(new DynamicAnimation(manage.grassField, manage.grassField));
		electric = new Energy(new WeaponEnergyBuilder(72, 55));
		electric.setCurAnim(new DynamicAnimation(manage.zapDash, manage.zapDash));
		water = new Energy(new WeaponEnergyBuilder(18, 94));
		water.setCurAnim(new DynamicAnimation(manage.waterShot, manage.waterShot));
		energies = new Energy[5];
		
		//Energies list
		energies[0] = sonarWave;
		energies[1] = fire;
		energies[2] = grass;
		energies[3] = electric;
		energies[4] = water;
	}
	public Energy[] getEnergies(){return energies;}
}