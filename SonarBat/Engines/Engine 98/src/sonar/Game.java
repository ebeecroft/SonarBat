/****************************************************************
 ***Name: SonarBat
 ***Version: 1.0(Alpha)
 ***Description: SonarBat a young bat decides to take on the fox
 *** in order to save the world. To do this he must defeat other
 *** bats who have been programmed to take over the world. Sonar's
 *** main weapon is his sonarWave that creates a projectile of
 *** sound to defeat his enemies similar to the sound a bat emits
 *** to track an insect.
 ***Features: Single Level, State switching, Mob, Weapons, 
 *** and Energy.
 ***Bugs: Keys might be a bit too sensitive.
 ***Programmed by: Eric Beecroft
 ***Date: 4/17/2015
 ***Skills: C++, and Ruby on Rails.
 ***Learning: Java
 *****************************************************************/

package sonar;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import sonar.gamestates.GSM;

public class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	private short width, height;
	private byte scale;
	private JFrame frame;
	private boolean running;
	private GSM gsm;
	
	Game(short width, short height, byte scale)
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
		gsm = new GSM(this);
		run("SonarBat");
	}
	
	private void run(String title)
	{
		//Initialize the variables necessary for the gameWorld
		double delta = 0;
		byte updates = 0;
		short frames = 0;
		byte ticks = 60;
		double ns = 1000000000 / ticks;
		BufferStrategy bs = null;
		long renderTime = System.currentTimeMillis();
		long updateTime = System.nanoTime();
		
		do
		{
			//Perform the gameWorld world functions
			long now = System.nanoTime();
			delta += (now - updateTime) / ns;
			updateTime = now;
			
			if(delta >= 1)
			{
				update();
				delta--;
				updates++;
			}
			render(bs);
			frames++;
			
			//Display the game's title every 1 second.
			if(System.currentTimeMillis() - renderTime >= 1000)
			{
				frame.setTitle(title + " | ups: " + updates + " fps: " + frames);
				updates = 0;
				frames = 0;
				renderTime += 1000;
			}
			
			if(bs == null) createBufferStrategy(2);
			bs = getBufferStrategy();
		}
		while(running);
	}
	
	private void update()
	{
		gsm.update();
	}
	
	private void render(BufferStrategy bs)
	{
		if(bs == null) return;
		Graphics g = bs.getDrawGraphics();
		gsm.render(g);
		g.dispose();
		bs.show();
	}
	
	//Observers
	JFrame getFrame(){return frame;}
	public short getWindowWidth(){return width;}
	public short getWindowHeight(){return height;}
	byte getWindowScale(){return scale;}
}