package sonar;

import java.awt.Dimension;
import javax.swing.JFrame;

final class Window
{
	private Window(){} //Prevents multiple windows from being created
	private final static void createWindow(final Game game, final byte scale)
	{
		Dimension size = new Dimension(Game.getWindowWidth() * scale, Game.getWindowHeight() * scale);
		game.setPreferredSize(size);
		Game.getFrame().add(game);
		Game.getFrame().pack();
		Game.getFrame().setResizable(false);
		Game.getFrame().setVisible(true);
		Game.getFrame().setLocationRelativeTo(null);
		Game.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		short width = 300;
		short height = 169;
		byte scale = 3;
		Game game = Game.createGame(width, height);
		Window.createWindow(game, scale);
		game.start(game);
	}
}