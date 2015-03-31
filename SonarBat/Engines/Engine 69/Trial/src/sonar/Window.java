package sonar;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window
{
	Window(Game game)
	{
		Dimension size = new Dimension(game.getWindowWidth() * game.getWindowScale(), game.getWindowHeight() * game.getWindowScale());
		game.setPreferredSize(size);
		game.getFrame().setResizable(false);
		game.getFrame().setTitle(game.getTitle());
		game.getFrame().add(game);
		game.getFrame().pack();
		game.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setVisible(true);
		game.start();		
	}
}