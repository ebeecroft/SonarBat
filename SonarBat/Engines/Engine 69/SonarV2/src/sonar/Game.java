package sonar;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	
	//Size
	private int width = 300;
	private int height = width / 16 * 9;
	private int scale = 2;
	
	//Window setup only
	private JFrame frame;
	private String title = "SonarBat v0.2";
	
	//Running loop functionality
	private boolean running;
	private Mobile mobile;
	private BufferStrategy bs;
	
	Game() {frame = new JFrame();}
	
	void start()
	{	
		//Starts the actual loop of the game
		if(running) return;
		running = true;
		mobile = new Mobile(this);
		run();
	}
	
	private void run()
	{
		//Sets up the timing for the rendering and update methods
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
		}
		stop();
	}
	
	private void stop()
	{
		if(!running) return;
		running = false;
	}
	
	//Getters for use with window only
	JFrame getJFrame() {return frame;}
	String getTitle() {return title;}
	public int getWindowWidth() {return width;}
	public int getWindowHeight() {return height;}
	int getWindowScale() {return scale;}
}