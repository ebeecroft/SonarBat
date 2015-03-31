package sonar;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas
{
	//The window box of the actual frame
	private static final long serialVersionUID = 1L;
	private int width, height, scale;
	private JFrame frame;
	private String title = "SonarBat V3";
	
	//Variables for the running loop
	private boolean running;
	private BufferStrategy bs;
	private Mobile mobile;
	
	Game(int width, int height, int scale)
	{
		this.width = width;
		this.height = height;
		this.scale = scale;
		frame = new JFrame();
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
				mobile.update();
				updates++;
				delta--;
			}
			mobile.render(bs);
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
			//System.out.println("I am running successfully");
		}
	}
	
	//Getters for the game class
	public int getWindowWidth(){return width;}
	public int getWindowHeight(){return height;}
	int getWindowScale(){return scale;}
	String getTitle(){return title;}
	JFrame getFrame(){return frame;}
}