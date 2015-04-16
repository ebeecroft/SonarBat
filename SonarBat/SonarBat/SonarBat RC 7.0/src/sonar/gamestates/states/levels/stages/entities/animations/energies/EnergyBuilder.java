package sonar.gamestates.states.levels.stages.entities.animations.energies;

public abstract class EnergyBuilder
{
	private int x, y;
	EnergyBuilder(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	int getX(){return x;}
	int getY(){return y;}
	abstract String getType();
}

class WeaponEnergyBuilder extends EnergyBuilder
{
	WeaponEnergyBuilder(int x, int y){super(x, y);}
	String getType(){return "Weapon";}
}