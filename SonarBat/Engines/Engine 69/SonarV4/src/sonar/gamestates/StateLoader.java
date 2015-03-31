package sonar.gamestates;

class StateLoader
{
	/*The StateLoader class is responsible for being able to switch between the
	 * various different states. To do this we need three different functions.
	 * The first one is an unload function which will unload the current state
	 * we are in by setting the current state to null. The next one is the load
	 * state which initializes the state we now are requesting by creating a
	 * new instance of it. The final method is the set function which calls the
	 * two other functions and takes in the current state. Another function we
	 * need to create is the one that returns the current state so that it will
	 * get rendered and updated back to the GSM. To do this we need an array of
	 * gamestates and a currentState which is an int. At this point in the
	 * process we don't know how many game states we will need so for the first
	 * time we will set it to just one.
	 * 
	 * In order for gameState to function we will need to create the gameState
	 * class first. The currentState class will keep track of the currentState
	 * we currently are in. The stateHolder will be called from here. The
	 * stateHolder is what holds the various game states.
	 * 
	 * The pastState is only utilized by dual states and has no purpose in
	 * single states. Inventory is only created in dual state mode. The
	 * checkstate function is used to determine if we are in a single
	 * state or dual state. If we are in a single state then we don't do
	 * anything special, however if we are in a dual state then we set up
	 * a past state and initialize the inventory state. Also stateSwitcher
	 * becomes useful at that junction because now we can switch between
	 * the two different states.
	 * 
	 * The gsm is used for setting the gamestates since it utilized in all
	 * gamestates anyway. Without it we can't switch states.
	 * New changes here
	 * Added Music here
	 */

	private GameState currentState = null;
	private GameState pastState = null;
	private StateHolder shold;
	private GSM gsm;
	private AudioPlayer bgm;
	
	StateLoader(GSM gsm)
	{
		this.gsm = gsm;
		shold = new StateHolder();
		//Set the initial state
		setState(shold.waterStage);
	}
	
	private void loadState(int state)
	{
		/*Unloads the currentState and uses the nextState to set the
		 *currentState depending on the state given. 
		 */
		GameState nextState = null;
		currentState = null;
		if(bgm != null) bgm.close();
		bgm = null;
		if(state == shold.menuState);//nextState = gameStates[state];
		if(state == shold.levelState) nextState = new LevelState(gsm);
		if(state == shold.zapStage)
		{
			bgm = new AudioPlayer("/audio/music/level1-1.mp3");
			nextState = new ZapStage(gsm);
		}
		if(state == shold.waterStage)
		{
			bgm = new AudioPlayer("/audio/music/DynaTheme.mp3");
			nextState = new WaterStage(gsm);
		}
		
		currentState = nextState;
		checkState();
		bgm.play(true);
	}
	
	private void checkState()
	{
		if(currentState.isDual())
		{
			System.out.println("I am running a dual state");
			pastState = new InventoryState(gsm);
		}
		if(currentState.isSingle())
		{
			System.out.println("I am running a single state");
			if(pastState != null){pastState = null;}
		}
	}
	
	void setState(int state){loadState(state);}
	void stateSwitcher(GameState active, GameState passive)
	{
		if(pastState != null)
		{
			currentState = active;
			pastState = passive;
		}
	}
	
	GameState getCurrent(){return currentState;}
	GameState getPast(){return pastState;}
	StateHolder getShold(){return shold;}
}