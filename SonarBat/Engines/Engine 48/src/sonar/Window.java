package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window
{	
	Window(Game game)
	{
		//Builds the gameworld screen for the SonarBat game.
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
	
	public static void main(String[] args)
	{
		Game game = new Game((short) 300, (short) 169, (byte) 2);
		new Window(game);
	}
}