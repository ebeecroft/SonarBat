package sonar.gamestates;

class InventoryState extends DualState
{
	/*The inventory state holds all of the items that the player can possibly need.
	 * This includes weapons, health, and amount energy remaining in each weapon.
	 * It is only intended to be use in conjunction with the level.
	 * 
	 * Changed this one to switch back to the current state
	 */
	
	InventoryState(GSM gsm)
	{
		setGsm(gsm);
		//super(gsm);
	}

	void update()
	{
		if(getGsm().getKey().start)
		{
			System.out.println("I am currently loading the Inventory of the player.");
			getGsm().getLoader().stateSwitcher(getGsm().getLoader().getPast(), getGsm().getLoader().getCurrent());
			System.out.println("Switched to the current Stage");
			getGsm().getKey().start = false;
		}
	}
}