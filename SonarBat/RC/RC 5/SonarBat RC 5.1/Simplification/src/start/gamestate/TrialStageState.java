package start.gamestate;

import java.awt.Graphics;

class TrialStageState extends StageState
{	
	TrialStageState(GameStateManager gsm)
	{
		clearAll();
		setGameStateManager(gsm);
		//initPlayer(); //= new Player(gsm.getKey());
		setLm("Trial", gsm.getKey());
		setScreen(gsm.getGame().getWindowWidth(), gsm.getGame().getWindowHeight());
		setImage();
		initPixels();
	}
	
	void update()
	{//58
		getLm().update();
	}
	
	void render(Graphics g)
	{
		//60
		getScreen().clear();
		getLm().render(getScreen());
		for(int i = 0; i < getPixels().length; i++)
		{
			getPixels()[i] = getScreen().getPhold().getPixel().getPixels()[i];
		}
		g.drawImage(getImage(), 0, 0, getGameStateManager().getGame().getWidth(), getGameStateManager().getGame().getHeight(), null);
		//g.setColor(Color.WHITE);
		//g.setFont(new Font("Verdana", 0, 20));
		//g.drawString("X: " + (int) player.getX() + ", Y: " + (int) player.getY(), 50, 50);
	}
}