package sonar.gamestates;

import java.awt.Graphics;

class ZapBoss extends DisplayBossState
{
	ZapBoss(GameStateManager gsm)
	{
		super(gsm);
		//setBg("/textures/backgrounds/ZapBackground.png");
		//setSprite(Sprite.BatSprite);
	}
	
	void update()
	{
		//getGsm().setState(getGsm().dynaBoss);
		getGsm().setState(getGsm().zapStage);
	}
	
	void render(Graphics g)
	{
		System.out.println("Displaying the Zap Boss");
	}
}