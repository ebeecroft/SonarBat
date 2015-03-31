package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

class Window
{
	Window(Game game)
	{
		Dimension size = new Dimension(game.getWindowWidth() * game.getWindowScale(), game.getWindowHeight() * game.getWindowScale());
		game.setPreferredSize(size);
		game.getJFrame().setResizable(false);
		game.getJFrame().setTitle("SonarBat");
		game.getJFrame().add(game);
		game.getJFrame().pack();
		game.getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getJFrame().setLocationRelativeTo(null);
		game.getJFrame().setVisible(true);
		game.start();
	}
}