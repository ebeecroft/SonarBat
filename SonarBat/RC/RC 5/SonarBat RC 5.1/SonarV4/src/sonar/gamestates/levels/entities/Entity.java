package sonar.gamestates.levels.entities;

class Entity
{
	/*The Entity class is the basic class for all tiles and mobs. All this
	 * class needs is a Basic class which will take in a sprite and a
	 * position as these will be necessary whenever we create a character,
	 * npc, or projectiles.
	 */
	private Basic basic;
	Entity(){basic = new Basic();}
	Basic getBasic(){return basic;}
}