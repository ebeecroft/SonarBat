package sonar.gamestates;

class DisplayBoss extends SingleState
{
	/*The DisplayBossState is a very special type of class to handle the rendering
	 * of the different bosses that are available in the game before displaying
	 * them to the screen. Examples of this are: WaterBoss, FireBoss,
	 * ElectricBoss. Only a Sprite is needed to be defined at this level as only
	 * the correct sprite will be rendered. This ends the Single state as nothing
	 * else will be extending this state other then subclasses. No new
	 * functionality will be added after this one.
	 */
	//private Sprite sprite;
	DisplayBoss() {
		//super(gsm);
	}
}