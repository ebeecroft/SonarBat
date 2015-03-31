package sonar.gamestates.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import sonar.Game;
import sonar.gamestates.levels.entities.Screen;

public class LevelManager
{
	/*The LevelManager class is what handles the rendering and updating of levels.
	 * The Level manager should only ever render and update the currentLevel and
	 * nothing else. It should only know about that and nothing else. It should
	 * also utilize a levelLoader functionality to handle the switching of
	 * levels. The LevelManager will need to only use the levels that make sense
	 * for the given StageState. 
	 */
	private LevelLoader loader;
	private Screen screen;
	private Game game;
	
	public LevelManager(String levelType, int width, int height, Game game)
	{
		//System.out.println("Width is: " + width);
		loader = new LevelLoader(this, levelType);
		screen = new Screen(width, height);
		this.game = game;
	}
	
	public void update()
	{
		loader.getCurrent().update();
	}
	
	public void render(Graphics g)
	{
		int xScroll = 0;//(int) player.getX() - screen.getWidth() / 2;
		int yScroll = 0;//(int) player.getY() - screen.getHeight() / 2;
		BufferedImage image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		loader.getCurrent().render(xScroll, yScroll, screen);
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.getPixels()[i];
		}
		g.drawImage(image, 0, 0, game.getWidth(), game.getHeight(), null);
		image = null;
	}
}