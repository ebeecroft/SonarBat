package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

class Window
{
	//RealTuts portion
	Window(Game game)
	{
		Dimension size = new Dimension(game.getWindowWidth() * game.getScale(), game.getWindowHeight() * game.getScale());
		game.setPreferredSize(size);
		game.getJFrame().setResizable(false);
		game.getJFrame().setTitle(game.getTitle());
		game.getJFrame().add(game);
		game.getJFrame().pack();
		game.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getJFrame().setLocationRelativeTo(null);
		game.getJFrame().setVisible(true);
		game.start();
	}
}