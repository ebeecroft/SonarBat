package start.gamestate.level;

import start.gamestate.Keyboard;
import entity.Screen;
import entity.mob.characters.Player;

public class LevelManager
{
	private Level[] levels;
	private int currentLevel;
	int trialLevel1 = 0;
	int trialLevel2 = 1;
	int trialLevel3 = 2;
	int trialLevel4 = 3;
	int trialLevel5 = 4;
	int trialLevel6 = 5;
	int trialLevel7 = 6;
	int trialLevel8 = 7;
	int trialLevel9 = 8;
	int trialLevel10 = 9;
	int trialLevel11 = 10;
	int trialLevel12 = 11;
	int trialLevel13 = 12;
	int trialLevel14= 13;
	int trialLevel15 = 14;
	int trialLevel16= 15;
	int trialLevel17 = 16;
	int trialLevel18 = 17;
	int trialLevel19 = 18;
	int trialLevel20 = 19;
	int grassWorld = 20;
	int grassTest = 21;
	
	private int amount = 22;
	private Player player;
	
	public LevelManager(String stage, Keyboard key)
	{
		player = new Player(60, 20, key);
		levels = new Level[amount];
		currentLevel = grassTest; //grassWorld;
		if(stage == "Trial") loadLevel(currentLevel); //loadLevel(grassWorld); 
		//loadLevel(trialLevel1);
	}
	
	private void loadLevel(int level)
	{
		if(level == trialLevel1)
		{
			//levels[level] = new TrialLevel1("/textures/Slevel1.png", this); //new RandomLevel(64, 64);//WaterLevel(this, "/hello");
			levels[level] = new TrialLevel1("/textures/levels/ladderlevel.png", this);
		}
		if(level == grassTest)
		{
			levels[level] = new GrassTest("/textures/levels/tests/grassLevel.png", this);
		}
		/*
		if(level == trialLevel2)
		{
			levels[level] = new TrialLevel2("/textures/Slevel2.png", this);
		}
		if(level == trialLevel3)
		{
			levels[level] = new TrialLevel3("/textures/Slevel3.png", this);
		}
		if(level == trialLevel4)
		{
			levels[level] = new TrialLevel4("/textures/Slevel4.png", this);
		}
		if(level == trialLevel5)
		{
			levels[level] = new TrialLevel5("/textures/Slevel5.png", this);
		}
		if(level == trialLevel6)
		{
			levels[level] = new TrialLevel6("/textures/Slevel6.png", this);
		}
		if(level == trialLevel7)
		{
			levels[level] = new TrialLevel7("/textures/Slevel7.png", this);
		}
		if(level == trialLevel8)
		{
			levels[level] = new TrialLevel8("/textures/Slevel8.png", this);
		}
		if(level == trialLevel9)
		{
			levels[level] = new TrialLevel9("/textures/Slevel9.png", this);
		}
		if(level == trialLevel10)
		{
			levels[level] = new TrialLevel10("/textures/Slevel10.png", this);
		}
		if(level == trialLevel11)
		{
			levels[level] = new TrialLevel11("/textures/Slevel11.png", this);
		}
		if(level == trialLevel12)
		{
			levels[level] = new TrialLevel12("/textures/Slevel12.png", this);
		}
		if(level == trialLevel13)
		{
			levels[level] = new TrialLevel13("/textures/Slevel13.png", this);
		}
		if(level == trialLevel14)
		{
			levels[level] = new TrialLevel14("/textures/Slevel14.png", this);
		}
		if(level == trialLevel15)
		{
			levels[level] = new TrialLevel15("/textures/Slevel15.png", this);
		}
		if(level == trialLevel16)
		{
			levels[level] = new TrialLevel16("/textures/Slevel16.png", this);
		}
		if(level == trialLevel17)
		{
			levels[level] = new TrialLevel17("/textures/Slevel17.png", this);
		}
		if(level == trialLevel18)
		{
			levels[level] = new TrialLevel18("/textures/Slevel18.png", this);
		}
		if(level == trialLevel19)
		{
			levels[level] = new TrialLevel19("/textures/Slevel19.png", this);
		}
		if(level == trialLevel20)
		{
			levels[level] = new TrialLevel20("/textures/Slevel20.png", this);
		}
		if(level == grassWorld)
		{
			levels[level] = new GrassLevel("/textures/grassworld.png", this);
		}*/
		player.getCollide().getMap().setLevel(levels[level]);
	}
	
	private void unloadLevel(int level)
	{
		levels[level] = null;
	}
	
	void setLevel(int level)
	{
		unloadLevel(currentLevel);
		currentLevel = level;
		loadLevel(currentLevel);
	}
	
	public void update()
	{
		levels[currentLevel].update();
		player.update();
		//if(currentLevel == 0 || currentLevel == 1 || currentLevel == 19 || currentLevel == 20) player.update();
	}
	
	public void render(Screen screen)
	{
		int xScroll = (int) player.getPosition().getX() - screen.getPhold().getDimension().getWidth() / 2;
		int yScroll = (int) player.getPosition().getY() - screen.getPhold().getDimension().getHeight() / 2;
		//System.out.println("Player X is: " + player.getX());
		//System.out.println("Player Y is: " + player.getY());
		levels[currentLevel].render(xScroll, yScroll, screen);
		player.render(screen, "Player");
		//System.out.println("Players X is: " + (int) player.getX() / 16);
		//System.out.println("Players Y is: " + (int) player.getY() / 16);
	}
	
	Player getPlayer()
	{
		return player;
	}
}