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
		sonarWave = new Energy(new WeaponEnergyBuilder(34, 20));
		sonarWave.setCurAnim(new DynamicAnimation(manage.sonarEnergy));
		
		//Energies that are acquired after beating bosses
		fire = new Energy(new WeaponEnergyBuilder(88, 20));
		fire.setCurAnim(new DynamicAnimation(manage.fireEnergy));
		grass = new Energy(new WeaponEnergyBuilder(34, 59));
		grass.setCurAnim(new DynamicAnimation(manage.grassEnergy));
		electric = new Energy(new WeaponEnergyBuilder(88, 59));
		electric.setCurAnim(new DynamicAnimation(manage.zapEnergy));
		water = new Energy(new WeaponEnergyBuilder(34, 98));
		water.setCurAnim(new DynamicAnimation(manage.waterEnergy));
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