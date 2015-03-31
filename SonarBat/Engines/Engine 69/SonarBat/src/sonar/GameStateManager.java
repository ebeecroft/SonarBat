package sonar;

public class GameStateManager
{
	private int currentState;
	
	public static int titleState;
	public static int levelSelectState;
	public static int zapState;
	public static int gameOverState;
	
	public GameStateManager()
	{
		currentState = titleState;
		loadState(currentState);
	}

	private void loadState(int state)
	{
		if(state == titleState)
		{
			//Display the title screen
		}
		
		if(state == levelSelectState)
		{
			//Display the available bosses
		}
		
		if(state == zapState)
		{
			//Load up Zaps level and the characters
		}
		
		if(state == gameOverState)
		{
			//Display the ending screen and destroy the previous level, and player
		}
	}
	
	private void unloadState()
	{
		currentState = -1;
	}
	
	public void setState(int state)
	{
		unloadState();
		currentState = state;
		loadState(currentState);
	}
}