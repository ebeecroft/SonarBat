package sonar.gamestates.states.levels.stages.entities.animations.weapons;

public abstract class WeaponBuilder
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