package sonar.gamestates;

import java.awt.Graphics;

abstract class BackgroundState extends GameState
{
	private Background bg;
	
	BackgroundState(GameStateManager gsm){super();}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		
	}
	
	Background getBg(){return bg;}
	private void unloadBg(){bg = null;}
	private void loadBg(String path){bg = new Background(path, 0);}	
	void setBg(String path)
	{
		unloadBg();
		loadBg(path);
	}
}