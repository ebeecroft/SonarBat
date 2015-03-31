package entity.mob.characters;

import entity.mob.Mob;

public class Character extends Mob
{
	private Falling fall; //Only players and Npcs can fall not projectiles
	Character(int x, int y)
	{
		super(x, y);
		fall = new Falling();
	}
	Falling getFall(){return fall;}
}