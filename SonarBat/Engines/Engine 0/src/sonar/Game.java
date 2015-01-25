package sonar;

import java.awt.Canvas;
import javax.swing.JFrame;

class Game extends Canvas
{
	private static final long serialVersionUID = 1L;
	private short[] gameWindow;
	private JFrame frame;
	private boolean running;
	private Mobile process;
	
	Game(short width, short height, short scale)
	{
		gameWindow = new short[3];
		gameWindow[0] = width;
		gameWindow[1] = height;
		gameWindow[2] = scale;
		frame = new JFrame();
	}
	
	void start()
	{
		if(running) return;
		running = true;
		process = new Mobile(this, "SonarBat");
		run();
	}
	
	//Observers
	private void run(){do{process.loop();}while(running);}
	JFrame getFrame(){return frame;}
	short[] getGameWindow(){return gameWindow;}
}