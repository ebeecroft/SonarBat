package sonar;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game extends Canvas
{
	/*The Game class is where all the main action will be performed. The
	 * game class is where we start the main game loop. The main game
	 * loop is what allows the game to function and build images, words
	 * and levels to the screen. In the game class we need three main
	 * functions. The first function is start, what start does is
	 * initialize running and the mobile class right before sending off
	 * the necessary information to the run method. The run method is
	 * where the main game loop is and will always be run since the loop
	 * there will never end. All game related input will occur there and
	 * will be either an update or a render that will take place. The
	 * stop function is not necessary but most of the time is included
	 * for completeness but will never be run as it is always after the
	 * endless loop. Therefore I am choosing to ignore that function
	 * unless of course there is a way to utilize it in the main game
	 * running loop.
	 * 
	 * Any variables that I create here will be set to private since that
	 * is good coding practice and to prevent the code from being abused
	 * by other functions it shouldn't be seen by. Any getters here will
	 * be set to default to prevent them from being used by other packages.
	 * The first variables I will need in the constructor of the game class
	 * are width, height, scale and title. This will be all the constructor
	 * needs to utilize to function.
	 * 
	 * The JFrame variable needs to be defined here and set to new in the
	 * constructor in order for it to be utilized by the Window class. In
	 * it I will pass in the title so that way I don't have to call
	 * setTitle in the window class since it will be defined by default
	 * with the title variable.
	 * 
	 * The Game also needs to extend Canvas in order for us to fully make use
	 * of the jframe and game class. Also we need to implement the serial
	 * version id. The mobile class needs to be created for us to utilize
	 * update and render functionality. It will take in width, height and
	 * the game class in the constructor for mobile.
	 */
	
	private static final long serialVersionUID = 1L;
	private int width, height, scale;
	private String title;
	
	private JFrame frame;
	private boolean running;
	private Mobile mobile;
	
	private BufferStrategy bs;
	
	Game(int width, int height, int scale, String title)
	{
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.title = title;
		frame = new JFrame(title);
	}
	
	//This method is pretty small as it will only contain a few simple variables
	void start()
	{
		if(running) return;
		running = true;
		mobile = new Mobile(width, height, this);
		run();
	}
	
	//Very large and has many different variables to be utilized
	private void run()
	{
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		requestFocus();
		
		while(running)
		{
			long now = System.nanoTime();
			delta += ((now - lastTime) / ns);
			lastTime = now;
			
			while(delta >= 1)
			{
				delta--;
				mobile.update();
				updates++;
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
	}
	
	//These getters only purpose is to be utilized by the Window  class
	public int getWindowWidth(){return width;}
	public int getWindowHeight(){return height;}
	int getWindowScale(){return scale;}
	JFrame getFrame(){return frame;}
}