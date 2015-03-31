package sonar.level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import sonar.entities.Screen;
import sonar.entities.mobs.Player;
import sonar.gamestates.GameStateManager;

public class LevelManager
{	
	private GameStateManager gsm;
	private int currentLevel;
	private Level[] levels;
	int zap1 = 0;
	private Screen screen;
	private Player player;
	
	public LevelManager(GameStateManager gsm)
	{
		this.gsm = gsm;
		screen = new Screen(gsm.getGame().getWindowWidth(), gsm.getGame().getWindowHeight());
		player = new Player(gsm.getKey(), 0, 0);
		levels = new Level[12];
		currentLevel = zap1;
		loadLevel(currentLevel);
	}
	
	private void loadLevel(int level)
	{
		if(level == zap1)
		{
			levels[level] = new ZapLevel(this, "/textures/levels/levelmap.png");
		}
	}
	
	private void unloadLevel(int level)
	{
		levels[level] = null;
	}
	
	void setLevel(int level)
	{
		unloadLevel(currentLevel);
		currentLevel = level;
		loadLevel(currentLevel);
	}
	
	public void update()
	{
		levels[currentLevel].update();
		player.update();
		player.setLevel(levels[currentLevel]);
	}
	
	public void render(Graphics g)
	{
		BufferedImage image = new BufferedImage(gsm.getGame().getWindowWidth(), gsm.getGame().getWindowHeight(), BufferedImage.TYPE_INT_RGB);
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
}