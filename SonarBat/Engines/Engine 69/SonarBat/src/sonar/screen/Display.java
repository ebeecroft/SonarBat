package sonar.screen;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import sonar.audio.AudioPlayer;
import sonar.level.LevelManager;
import sonar.mob.Player;

public class Display extends PixelDS
{
	private Screen screen;
	//private Level level;
	private AudioPlayer bgm;
	private boolean bgmGo;
	private LevelManager manage;
	private int counter = 0;
	private boolean night = false;
	private boolean day = true;
	
	public Display(int width, int height)
	{
		super(width, height, "Display");
		screen = new Screen(width, height);
		manage = new LevelManager();
		//level = new Level("/textures/levels/levelmap.png");
		bgm = new AudioPlayer("/audio/music/DynaTheme.mp3");
		bgmGo = false;
	}
	
	public void render(BufferStrategy bs, int scale, Player player)
	{
		if(bs == null) return;
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		initPixels(((DataBufferInt) image.getRaster().getDataBuffer()).getData());
		if(counter > 4000)
		{
			night = true;
			day = false;
		}
		if(counter < 0)
		{
			night = false;
			day = true;
		}
		
		//if(!day || !night) counter++;
		if(night) counter--;
		if(day) counter++;
		
		screen.clear();
		System.out.println("Player X" + player.getX());
		int xScroll = (int) player.getX() - screen.getWidth() / 2;
		int yScroll = (int) player.getY() - screen.getHeight() / 2;
		manage.render(xScroll, yScroll, screen);
		if(counter > 4000)
		{
			manage.setLevel(manage.getLevelHolder().waterStage);
			player.setLevel(manage.getLevelHolder().waterStage);
		}
		if(counter < 0)
		{
			manage.setLevel(manage.getLevelHolder().zapStage);
			player.setLevel(manage.getLevelHolder().zapStage);
		}
		//level.render(xScroll, yScroll, screen);
		player.render(screen);
		if(bgmGo == false)
		{
			bgm.play(true);
			bgmGo = true;
		}
		//int xSroll = playerX - screen.getWidth() / 2;
		//int yScroll = playerY - screen.getHeight() / 2;
		//level.render(xScroll, yScroll, screen);
		for(int i = 0; i < getPixels().length; i++)
		{
			setPixels(screen.getPixels(), i); 
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth() * scale, getHeight() * scale, null);
		g.dispose();
		bs.show();
	}
}