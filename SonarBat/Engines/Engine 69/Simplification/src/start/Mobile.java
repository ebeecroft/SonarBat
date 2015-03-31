package start;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import start.gamestate.GameStateManager;

class Mobile
{
	private GameStateManager gsm;
	Mobile(Game game){gsm = new GameStateManager(game);}
	void update(){gsm.update();}
	void render(BufferStrategy bs)
	{
		if(bs == null) return;
		Graphics g = bs.getDrawGraphics();
		gsm.render(g);
		g.dispose();
		bs.show();
	}
}