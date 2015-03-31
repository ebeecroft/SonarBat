package sonar;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private boolean running;
	private int width;
	private int height;
	private int scale;
	private String title = "SonarBat v3a";
	private BufferStrategy bs;
	private Mobile mobile;
	
	Game(int width, int height, int scale)
	{
		frame = new JFrame();
		this.width = width;
		this.height = height;
		this.scale = scale;
	}
	
	void start()
	{
		if(running) return;
		running = true;
		mobile = new Mobile(this);
		run();
	}
	
	private void run()
	{
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		//setFocusable(true);
		requestFocus();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += ((now - lastTime) / ns);
			lastTime = now;
			//boolean shouldRender = false;
			
			//long start = System.currentTimeMillis();
			while(delta >= 1)
			{
				delta--;
				mobile.update();
				updates++;
				//shouldRender = true;
			}
				mobile.render(bs);
				frames++;
			
			if((System.currentTimeMillis() - timer) >= 1000)
			{
				frame.setTitle(title + " | " + "ups: " + updates + " fps: " + frames);
				frames = 0;
				updates = 0;
				timer += 1000;
			}
			
			if(bs == null) createBufferStrategy(3);
			bs = getBufferStrategy();
		}
		
		stop();
	}
	
	private void stop()
	{
		
	}
	
	JFrame getJFrame() {return frame;}
	public int getWindowWidth() {return width;}
	public int getWindowHeight() {return height;}
	int getWindowScale() {return scale;}
}