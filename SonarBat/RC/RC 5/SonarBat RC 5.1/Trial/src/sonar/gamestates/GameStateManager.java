package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import sonar.Game;

public class GameStateManager
{
	//State related data
	private int currentState;
	private GameState[] gameStates;
	int zapBoss = 0;
	int dynaBoss = 1;
	int waterBoss = 2;
	int zapStage = 3;
	int dynaStage = 4;
	int waterStage = 5;
	int titleScreen = 6;
	int levelSelect = 7;
	int passwordScreen = 8;
	int gameoverScreen = 9;
	int starterStage = 10;
	private int amount = 11;
	
	//Player related data
	private int lives;
	private boolean zapDead;
	private boolean dynaDead;
	private boolean waterDead;
	//private int bossesBeaten;
	
	private Game game;
	private Keyboard key;
	
	public GameStateManager(Game game)
	{
		this.game = game;
		key = new Keyboard(this);
		gameStates = new GameState[amount];
		currentState = zapBoss; //zapStage;//titleScreen;
		loadState(currentState);
	}
	
	private void loadState(int state)
	{
		if(state == zapBoss){gameStates[state] = new ZapBoss(this);}
		if(state == dynaBoss){gameStates[state] = new DynaBoss(this);}
		if(state == waterBoss){gameStates[state] = new WaterBoss(this);}
		if(state == zapStage){gameStates[state] = new ZapStage(this);}
		if(state == dynaStage){gameStates[state] = new DynaStage(this);}
		if(state == waterStage){gameStates[state] = new WaterStage(this);}
		if(state == titleScreen){gameStates[state] = new TitleScreen(this); lives = 3;}
		if(state == levelSelect){gameStates[state] = new LevelSelect(this);}
		if(state == passwordScreen){gameStates[state] = new PasswordScreen(this);}
		if(state == gameoverScreen){gameStates[state] = new GameOverScreen(this); lives = 3;}
		if(state == starterStage){gameStates[state] = new StarterStage(this);}
	}
	
	private void unloadState(int state){gameStates[state] = null;}
	void setState(int state)
	{
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void update()
	{
		key.update();
		gameStates[currentState].update();
	}
	
	public void render(BufferStrategy bs)
	{
		Graphics g = bs.getDrawGraphics();
		gameStates[currentState].render(g);
		//System.out.println("Game State Manager is working");
		g.dispose();
		bs.show();
	}
	
	Game getGame(){return game;}
	int getLives(){return lives;}
	void setLives(int lives){this.lives = lives;}
	boolean getZapDead(){return zapDead;}
	boolean getDynaDead(){return dynaDead;}
	boolean getWaterDead(){return waterDead;}
	Keyboard getKey(){return key;}
	//public Keyboard getKey()
	//{
	//	return key;
	//}
}