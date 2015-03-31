package sonar.gamestates;

import java.awt.Graphics;

class DynaStage extends StageState
{
	DynaStage(GameStateManager gsm)
	{
		super(gsm);
		loadLm(gsm.getKey());
		setBGM("/audio/music/DynaTheme.mp3");
		playBGM();
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		System.out.println("I am running Dyna's stage");
	}
}