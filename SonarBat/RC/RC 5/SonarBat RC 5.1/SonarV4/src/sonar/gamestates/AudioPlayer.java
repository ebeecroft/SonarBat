package sonar.gamestates;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

class AudioPlayer
{
	/*The AudioPlayer class is what allows us to have music in our game. To utilize
	 * this functionality we need javazoom 1.1 functionality which is implemented
	 * using the jlayer jar files. The first thing we need to do is get the string
	 * path to our audio directory. Once we have gotten that we then break it down
	 * into something that is readable by the processor for the play code and then
	 * utilize it by calling the play method so we can play the physical music.
	 * If this is going to be a background music then we need to set the loop
	 * variable to true for our music to never stop. To prevent the player from
	 * playing two songs at once we need to close the first one before we open the
	 * second one.
	 * 
	 */
	private Player player;
	private String path;
	
	public AudioPlayer(String path){this.path = path;}
	public void close(){if(player != null) player.close();}
	public void play(final boolean loop)
	{
		InputStream fis = this.getClass().getResourceAsStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		try{player = new Player(bis);}
		catch (Exception e){e.printStackTrace();}
		
		new Thread()
		{
			public void run()
			{
				try
				{
					player.play();
					if(player.isComplete() && loop == true){play(loop);}
				}
				catch (Exception e){e.printStackTrace();}
			}
		}.start();
	}
}