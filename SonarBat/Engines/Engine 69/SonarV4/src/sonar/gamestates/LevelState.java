package sonar.gamestates;

class LevelState extends DualState
{
	/*The level state class is the currently functioning level that we are loading
	 * right now. It is active under the dualstate category and is running in
	 * tadem with the inventory state. Normaly there would be level that is being
	 * rendered but right now it is currently empty.
	 */
	
	LevelState(GSM gsm)
	{
		setGsm(gsm);
		//super(gsm);
	}

	void update()
	{
		System.out.println("I am currently loading the given level");
		//getGsm().getLoader().stateSwitcher(getGsm().getLoader().getPast(), getGsm().getLoader().getCurrent());
	}
}