package sonar;

import sonar.input.Keyboard;
import sonar.level.Level;
import sonar.mob.Player;
import sonar.sprite.Holder;

public class Mobile
{
	private Keyboard key;
	private Player player;
	private Holder hold;
	
	Mobile(Game game)
	{
		hold = new Holder();
		key = new Keyboard(game);
		player = new Player(hold.player.player_forward, key, 50, 60);
		player.setLevel(Level.zapStage);
	}
	
	public Player getPlayer()
	{
		return player;
	}
}