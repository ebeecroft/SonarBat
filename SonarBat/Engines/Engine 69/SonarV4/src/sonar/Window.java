package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

class Window
{
	/*The Window class is where the actual pop-up screen for our game will
	 * be created. The window class needs to do a variety of different
	 * things. One of the things that the window class needs to do is to
	 * create the Dimensions of our screen. The dimensions of the screen
	 * are composed of our screen's width times our scale and then our
	 * screen's height times our scale. These two parameters is what
	 * sets our screen's size. In order to apply this size we need to tell
	 * our game to set a size. To do that we call screen.setPreferredSize()
	 * and pass in the dimension's size variable. The other thing that we
	 * need to do is to pass in the game into the constructor in order to
	 * accomplish that goal.
	 * 
	 * Be sure to use new when dealing with Dimensions. The other eight
	 * actions that we now must perform is make sure that we add the game
	 * into the component class. To do this we need to use
	 * game.jframe.add(game) command in order to do this. The next step after
	 * that one is we need to call game.jframe.pack() which will now pack the
	 * jframe with the necessary data we need. The next task we need to do is
	 * make certain that we do not resize the screen. To do this we call
	 * game.jframe.setResizable(false) which will prevent the game from being
	 * resized. Next we need to make certain the pop-up is actually visable
	 * to the actual user. To do this we need to call
	 * game.jframe.setVisible(true) which sets the game to display to the screen.
	 * 
	 * One of the important features we need to do is to set the location of
	 * our pop-up to be at the center of the screen. In order to do this we
	 * need to call game.jframe.setLocationRelativeTo(null), this will center
	 * the pop-up on the screen. The next thing we need to do is setup what
	 * we want to do when we close the pop-up window. To do this we need to
	 * call game.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE). What this
	 * tells the frame to do is close immediately and kill the running
	 * application.
	 * 
	 * The final thing we need to do in the window class to finish it up is to
	 * call the game.start() method to start our actual game.
	 */
	
	Window(Game game)
	{
		Dimension size = new Dimension(game.getWindowWidth() * game.getWindowScale(), game.getWindowHeight() * game.getWindowScale());
		game.setPreferredSize(size);
		game.getFrame().add(game);
		game.getFrame().pack();
		game.getFrame().setResizable(false);
		game.getFrame().setVisible(true);
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.start();
	}
}