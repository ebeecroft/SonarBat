package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import sonar.gamestates.levels.LevelManager;
import sonar.gamestates.levels.entities.Screen;

abstract class StageState extends GameState
{
	private LevelManager lm;
	private Screen screen;
//	private Player player;
	private BufferedImage image;
	//private int[] pixels;
	
	StageState(GameStateManager gsm)
	{
		super(gsm);
		//initScreen();
//		initPlayer();
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g)
	{
		/*
		 * 
		 * BufferedImage image = new BufferedImage(gsm.getGame().getWindowWidth(), gsm.getGame().getWindowHeight(), BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		int xScroll = player.getX() - screen.getWidth() / 2;
		int yScroll = player.getY() - screen.getHeight() / 2;
		levels[currentLevel].render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.getPixels()[i];
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 50, 50));
		g.drawString("X: " + player.getX() + ", Y: " + player.getY(), 50, 60);
		System.out.println("Player X: " + player.getX());
		System.out.println("Player Y: " + player.getY());
		g.drawImage(image, 0, 0, gsm.getGame().getWidth(), gsm.getGame().getHeight(), null);
	}
	
	GameStateManager getGsm(){return gsm;}
		 */
	}	
	
	Screen getScreen(){return screen;}
	void initScreen(int width, int height){screen = new Screen(getGsm().getGame().getWindowWidth(), getGsm().getGame().getWindowHeight());}
	void setImage(int width, int height){image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);}
	BufferedImage getImage(){return image;}
	
	//int[] getPixels() {return pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();}
//	void initPlayer(){player = new Player();}
//	Player getPlayer(){return player;}
	
	//LevelManager setters and getters
	void loadLm(Keyboard key){lm = new LevelManager(key);}
	void unloadLm(){lm = null;}
	LevelManager getLm(){return lm;}
}