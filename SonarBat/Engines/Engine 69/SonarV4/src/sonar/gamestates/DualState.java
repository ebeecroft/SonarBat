package sonar.gamestates;

class DualState extends BackgroundState
{
	/*Dual states have two states running at the same time. However only one state is
	 * active at a given time. The active state is the one that is currently being
	 * rendered and updated. The other the passive state is in standby mode waiting
	 * to be be switched to but is not currently running. In order to change between
	 * the two different states is a switcher. The switcher takes in two states and
	 * sets the active state to the passive state and the passive state to the active
	 * state. This one also extends the Background state. We also need to pass in
	 * the gsm parameter two.
	 */
	
	DualState()
	{
		//super(gsm);
		if(isSingle() != false) setSingle(false);
		if(isDual() != true) setDual(true);
	}
}