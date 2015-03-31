package sonar.gamestates;

class StateHolder
{
	/*This class is what holds all the various gameStates we could ever need in the
	 * entire game. All the gamestates here are specified as integers and given a
	 * number. Also we use a first and last to figure out how many game states we
	 * have currently and to automatically fill in the GameStatesArray with the
	 * necessary states needed. For each additional state added the array can then
	 * hold one more state that it couldn't hold before. We will also have an
	 * amount specified here that will be used later. All normal states will be
	 * packaged. Last refers to the last state we have currently available.
	 * 
	 * The inventory state is only active in the dual state mode only and is not
	 * needed at any other time.
	 * 
	 * Made improvements here
	 */
	
	int menuState = 0;
	int inventoryState = 1;
	int levelState = 2;
	int zapStage = 3;
	int waterStage = 4;
}