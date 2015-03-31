package sonar.gamestates;

import java.awt.Graphics;

class WaterStage extends StageState
{
	WaterStage(GameStateManager gsm)
	{
		super(gsm);
		loadLm(gsm.getKey());
		setBGM("/audio/music/Sonic.mp3");
		playBGM();
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		System.out.println("I am running Water stage");
	}
}