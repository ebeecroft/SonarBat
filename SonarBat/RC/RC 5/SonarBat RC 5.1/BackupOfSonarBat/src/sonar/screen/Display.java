package sonar.screen;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import sonar.audio.AudioPlayer;
import sonar.level.Level;
import sonar.mob.Player;

public class Display extends PixelDS
{
	private Screen screen;
	private Level level;
	private AudioPlayer bgm;
	private boolean bgmGo;
	
	public Display(int width, int height)
	{
		super(width, height, "Display");
		screen = new Screen(width, height);
		level = new Level("/textures/levels/levelmap.png");
		bgm = new AudioPlayer("/audio/music/DynaTheme.mp3");
		bgmGo = false;
	}
	
	public void render(BufferStrategy bs, int scale, Player player)
	{
		if(bs == null) return;
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		initPixels(((DataBufferInt) image.getRaster().getDataBuffer()).getData());
		screen.clear();
		int xScroll = (int) player.getX() - screen.getWidth() / 2;
		int yScroll = (int) player.getY() - screen.getHeight() / 2;
		level.render(xScroll, yScroll, screen);
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