package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import sonar.Game;

public class GameStateManager
{
	private int currentState;
	private GameState[] gameStates;
	int tstate = 0;
	int lsState = 1;
	int pstate = 2;
	int zstate = 3;
	private Game game;
	private Keyboard key;
	private AudioPlayer bgm, bgm2;
	
	public GameStateManager(Game game)
	{
		this.game = game;
		key = new Keyboard(this);
		gameStates = new GameState[12];
		currentState = tstate;
		loadState(currentState);
		bgm = new AudioPlayer("/audio/music/DynaTheme.mp3");
		bgm2 = new AudioPlayer("/audio/music/Zap theme.mp3");
	}
	
	private void loadState(int state)
	{
		if(state == tstate)
		{
			gameStates[state] = new TitleState(this);
		}
		if(state == lsState)
		{
			gameStates[state] = new LevelSelect(this);
			bgm2.play(true);
		}
		if(state == pstate)
		{
			gameStates[state] = new PasswordState(this);
		}
		if(state == zstate)
		{
			gameStates[state] = new ZapStageState(this);
			bgm.play(true);
		}
	}
	
	private void unloadState(int state)
	{
		bgm.close();
		bgm2.close();
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
		key.update();
		gameStates[currentState].update();
	}
	
	public void render(BufferStrategy bs)
	{
		Graphics g = bs.getDrawGraphics();
		gameStates[currentState].render(g);
		g.dispose();
		bs.show();
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