package sonar.gamestates;

import java.awt.Graphics;
import sonar.Game;

public class GSM
{
	/*The GSM which is short for Game State Manager is used to manage the
	 * different game states. Only one game state can be active at a time
	 * and so if we want another one to be active we need to utilize some
	 * form of switching mechanism. Also we need to have some place to
	 * hold the various different game states otherwise the gsm will be
	 * flooded with too much unrelated data. Game states have a tendency
	 * to be very large so a StateHolder needs to be created to handle
	 * those states. We don't want the stateholder to be utilized outside
	 * of the gamestates class. The GSM will be made very small and
	 * basic and will allow our StateLoader to be changed at a moments
	 * notice without direct affect to the code in the gsm.
	 * 
	 * We will need a couple of things. First we need the constructor to
	 * take in the width, height and the game into it. After that we will
	 * need to define a StateLoader function and also the GameState class
	 * the StateLoader will be how we switch between the various different
	 * states. We also need to define a update and render function for
	 * the GSM to finish off the mobile class.
	 * 
	 * We need to pass in the gsm to the loader in order for it to
	 * function effectively.
	 * 
	 * Found bug here
	 * 
	 * Added in Keyboard to the GSM as part of the game engine 1 new
	 * feature. Keyboard will handle all of the players movement in any
	 * direction.
	 */
	
	private StateLoader loader;
	private int width, height;
	private Game game;
	private Keyboard key;
	
	public GSM(int width, int height, Game game)
	{
		//System.out.println("My width for GSM is: " + width);
		this.width = width;
		this.height = height;
		this.game = game;
		key = new Keyboard(this);
		//Loader has to be after width, height and game has been defined.
		loader = new StateLoader(this);
		//System.out.println("This width for GSM is: " + this.width);
	}
	
	public void update()
	{
		//I decided to change the key before the loader so that we read input first from
		//keyboard before updating things.
		key.update();
		loader.getCurrent().update();
	}
	
	public void render(Graphics g)
	{
		loader.getCurrent().render(g);
	}
	
	StateLoader getLoader(){return loader;}
	int getWidth(){return width;}
	int getHeight(){return height;}
	Game getGame(){return game;}
	Keyboard getKey(){return key;}
}