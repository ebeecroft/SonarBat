package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.DataBufferInt;

import sonar.gamestates.levels.entities.Player;

class ZapStage extends StageState
{
	private Player player;
	ZapStage(GameStateManager gsm)
	{
		super(gsm);
		initScreen(gsm.getGame().getWindowWidth(), gsm.getGame().getWindowHeight());
		setImage(getScreen().getWidth(), getScreen().getHeight());
		loadLm(gsm.getKey());
		setBGM("/audio/music/Zap theme.mp3");
		playBGM();
		player = new Player(gsm.getKey(), 0, 0);
		player.setLevel(getLm().currentLevel2);
	}
	
	void update()
	{
		getLm().update();
		player.update();
	}
	
	void render(Graphics g)
	{
		int[] pixels  = ((DataBufferInt) getImage().getRaster().getDataBuffer()).getData();
		int xScroll = (int) player.getX() - getScreen().getWidth() / 2;
		int yScroll = (int) player.getY() - getScreen().getHeight() / 2;
		getLm().render(xScroll, yScroll, getScreen());
		player.render(getScreen());
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = getScreen().getPixels()[i];
		}
		g.drawImage(getImage(), 0, 0, getGsm().getGame().getWidth(), getGsm().getGame().getHeight(), null);
		//System.out.println("I am runing Zap's stage");
	}
}