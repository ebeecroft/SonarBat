package sonar;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import sonar.screen.Display;
import sonar.screen.Input;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	private int width = 300;
	private int tileSize = 12;
	private int numLines = 7;
	private int height = (int) (((double) width / (double) tileSize) * (double) numLines);
	private int scale = 2;
	private JFrame frame;
	private String title = "SonarBat v0.1a";
	private boolean running = false;
	private Display display;
	private Input input;
	private BufferStrategy bs;
	private Mobile mobile;
	
	Game(){ frame = new JFrame(); }

	void start()
	{
		if(running) return;
		running = true;
		input = new Input();
		display = new Display(width, height);
		mobile = new Mobile(this);
		//setFocusable(true);
		run();
	}
	
	private void run()
	{
		long updateTimer = System.nanoTime();
		double ns = 1000000000.0D / 60.0D;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long renderTimer = System.currentTimeMillis();
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - updateTimer) / ns;
			updateTimer = now;
			while(delta >= 1)
			{
				input.update(mobile);
				updates++;
				delta--;
			}
			display.render(bs, scale, mobile.getPlayer());
			frames++;
			
			if((System.currentTimeMillis() - renderTimer) > 1000)
			{
				renderTimer += 1000;
				System.out.println("ups: " + updates + ", frames: " + frames);
				frame.setTitle(title + " | " + "ups: " + updates + ", frames: " + frames);
				updates = 0;
				frames = 0;
			}
			
			if(bs == null) createBufferStrategy(3);
			bs = getBufferStrategy();
		}
		stop();
	}
	private void stop()
	{
		if(!running) return;
		running = false;
	}
	
	int getWindowWidth() { return width; }
	int getWindowHeight() { return height; }
	int getScale() { return scale; }
	JFrame getJFrame() { return frame; }
	String getTitle() { return title; }
}