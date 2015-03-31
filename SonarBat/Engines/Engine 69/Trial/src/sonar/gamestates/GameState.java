package sonar.gamestates;

import java.awt.Graphics;

abstract class GameState
{
	private GameStateManager gsm;
	private AudioPlayer bgm;

	GameState(GameStateManager gsm){this.gsm = gsm;}
	void update(){}
	void render(Graphics g){}
	GameStateManager getGsm(){return gsm;}
	private void loadBGM(String path){bgm = new AudioPlayer(path);}
	private void unloadBGM()
	{
		if(bgm != null) bgm.close();
	}
	void playBGM(){bgm.play(true);}
	void setBGM(String path)
	{
		unloadBGM();
		loadBGM(path);
	}
	
	//bgm = new AudioPlayer("/audio/music/DynaTheme.mp3");
}
