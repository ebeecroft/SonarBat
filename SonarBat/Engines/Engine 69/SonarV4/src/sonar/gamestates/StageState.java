package sonar.gamestates;

import sonar.Game;
import sonar.gamestates.levels.LevelManager;

class StageState extends DualState
{
	/*StageState is a very special class that allows the creation of the actual levels
	 * by being the only state that can utilize the LevelManager. The LevelManager
	 * manages the different levels and is able to switch between them. StageStates
	 * can be swapped out for the inventory at a moments notice and swapped back in
	 * again by using the switcher function. FireStage, WaterStage, and ElectricStage
	 * would be examples of states that would extend this class. This is the final
	 * class of the DualState as there will be nothing that extends it any further.
	 * This is the peek class and will gives us the games we want. :) The lm will
	 * need a couple of getters and setters. Only one lm may be created at a time,
	 * and will need to reset at the end of the level when it is completely done.
	 * Each LevelManager will need to take in the levelType parameter to determine
	 * which correct levels to load for the game.
	 * 
	 */
	private LevelManager lm;
	StageState(){}
	LevelManager getLm(){return lm;}
	void setLm(String levelType, int width, int height, Game game){lm = new LevelManager(levelType, width, height, game);}
	void clearLm(){lm = null;}
}