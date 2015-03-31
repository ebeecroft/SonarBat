package sonar.gamestates;

class SingleState extends BackgroundState
{
	/*Single states can only have one active state at a time and must set the current
	 * state to null first before switching to the next state. There will never be
	 * much active here other then the single state flag will be set to true and dual
	 * state will be set to false. We need to pass in the gsm parameter so that GSM
	 * can be utilized by the subclasses.
	 */
	SingleState()
	{
		//super(gsm);
		if(isSingle() != true) setSingle(true);
		if(isDual() != false) setDual(false);
	}
}