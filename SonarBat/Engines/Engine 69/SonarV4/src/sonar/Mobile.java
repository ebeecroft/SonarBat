package sonar;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import sonar.gamestates.GSM;

class Mobile
{
	/*The Mobile class is what we utilize to update and render different
	 * objects. In the Mobile constructor we need to pass in the width,
	 * height and Game object into the constructor. Mobile is the main
	 * render and update methods for the entire game. In the mobile
	 * class we need to define a GameStateManager so that we can
	 * utilize different GameStates. The render function utilizes the
	 * Graphics class by making use of a bufferStrategy in order to
	 * display objects to the screen.
	 * 
	 * GameState Manager is the last thing needed to finish up the
	 * 4 sonar package.
	 */
	private GSM gsm;
	
	Mobile(int width, int height, Game game)
	{
		gsm = new GSM(width, height, game);
	}
	
	void update()
	{
		gsm.update();
	}
	
	void render(BufferStrategy bs)
	{
		if(bs == null) return;
		Graphics g = bs.getDrawGraphics();
		//Place to call the GSM
		gsm.render(g);
		g.dispose();
		bs.show();
	}
}