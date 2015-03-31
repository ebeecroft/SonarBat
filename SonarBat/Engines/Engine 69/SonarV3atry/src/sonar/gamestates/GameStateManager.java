package sonar.gamestates;

import java.awt.Graphics;

import sonar.Game;

public class GameStateManager
{
	private GameState[] gameStates;
	private int currentState;
	
	int titleScreen = 0;
	int passwordScreen = 1;
	int starterStage = 2;
	int levelSelect = 3;
	int zapBoss = 4;
	int dynaBoss = 5;
	int waterBoss = 6;
	int zapStage = 7;
	int dynaStage = 8;
	int waterStage = 9;
	int gameoverScreen = 10;
	
	//private int LevelSelect = 0;
	//private int TrialStageGo = 1;
	private int amount = 11;
	
	private Keyboard key;
	private Game game;
	
	public GameStateManager(Game game)
	{
		gameStates = new GameState[amount];
		this.game = game;
		key = new Keyboard(this);
		game.addKeyListener(key);
		currentState = starterStage; //LevelSelect;
		loadState(currentState);
	}
	
	private void loadState(int state)
	{
		if(state == starterStage)
		{
			gameStates[state] = new TrialStageState(this);
		}
		/*if(state == TrialStageGo)
		{
			gameStates[state] = new TrialStageState(this);
		}
		if(state == LevelSelect)
			gameStates[state] = new LevelSelectState(this);*/
	}
	
	private void unloadState(int state)
	{
		gameStates[state] = null;
	}
	
	void setState(int state)
	{
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void update()
	{
		gameStates[currentState].update();
		key.update();
	}
	
	public void render(Graphics g)
	{
		gameStates[currentState].render(g);
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public Keyboard getKey()
	{
		return key;
	}
}