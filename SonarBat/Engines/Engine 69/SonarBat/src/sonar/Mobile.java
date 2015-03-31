package sonar;

import sonar.input.Keyboard;
import sonar.level.LevelHolder;
import sonar.mob.Player;
import sonar.sprite.Holder;

public class Mobile
{
	private Keyboard key;
	private Player player;
	private Holder hold;
	private LevelHolder levelHold;
	
	Mobile(Game game)
	{
		levelHold = new LevelHolder();
		hold = new Holder();
		key = new Keyboard(game);
		player = new Player(hold.player.player_forward, key, 50, 60); //50, 60
		player.setLevel(levelHold.zapStage);
	}
	
	public Player getPlayer()
	{
		return player;
	}
}