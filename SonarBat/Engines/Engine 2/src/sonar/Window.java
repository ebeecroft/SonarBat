package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window
{
	//After a lot of different thoughts I have come up with a new way to make games.
	//Its a method that is not obvious at first but after several iterations I
	//stumbled on this. I decided it is best to combine the window with main method.
	//What this class does is builds our window.
	
	Window(Game game)
	{
		Dimension size = new Dimension(game.getGameWindow()[0] * game.getGameWindow()[2], game.getGameWindow()[1] * game.getGameWindow()[2]);
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
		Game game = new Game((short) 300, (short) 169, (short) 2);
		new Window(game);
	}
}