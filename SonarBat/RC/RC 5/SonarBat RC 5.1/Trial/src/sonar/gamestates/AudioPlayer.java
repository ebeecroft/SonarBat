package sonar.gamestates;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

class AudioPlayer
{
	private Player player;
	private String path;
	
	public AudioPlayer(String path){this.path = path;}
	public void close(){if(player != null) player.close();}
	public void play(final boolean loop)
	{
		InputStream fis = this.getClass().getResourceAsStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		try
		{
			player = new Player(bis);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		new Thread()
		{
			public void run()
			{
				try
				{
					player.play();
					if(player.isComplete() && loop == true)
					{
						play(loop);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
}