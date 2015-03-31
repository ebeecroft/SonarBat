package sonar.gamestates;

import java.awt.Graphics;

public class LevelSelectState extends GameState
{
	private Background bg;
	
	private int choice =1;
	private boolean backgroundset = false;
	
	LevelSelectState(GameStateManager gsm)
	{
		setGameStateManager(gsm);
		bg = new Background("/textures/background/lselect.png", 1);
	}

	void update()
	{
		if(choice == 1)
		{
			//Call Display Boss1
			
			if(backgroundset == false)
			{
				bg = null;
				bg = new Background("/textures/background/bview.png", 1);
				backgroundset = true;
				getGameStateManager().setState(0);
			}
		}
		if(choice == 2)
		{
			
		}
	}
	
	void render(Graphics g)
	{
		//Render the current background image
		if(backgroundset) bg.render(g, getGameStateManager().getGame());
	}
}