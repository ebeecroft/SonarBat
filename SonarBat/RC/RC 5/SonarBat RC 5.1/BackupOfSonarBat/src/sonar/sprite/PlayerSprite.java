package sonar.sprite;

import sonar.graphics.Sprite;
import sonar.graphics.SpriteSheet;

public class PlayerSprite
{
	public Sprite player_backward;
	public Sprite player_backward_1;
	public Sprite player_forward;
	public Sprite player_forward_1;
	public Sprite player_side;
	public Sprite player_side_1;
	public Sprite player_side_2;
	
	PlayerSprite()
	{
		SpriteSheet player2 = new SpriteSheet("/textures/sheets/players/player.png");
		SpriteSheet playerside = new SpriteSheet("/textures/sheets/players/playerside.png");
		
		player_backward = new Sprite(1, 0, 20, 32, player2);
		player_backward_1 = new Sprite(1, 1, 20, 32, player2);
		player_forward = new Sprite(0, 0, 20, 32, player2);
		player_forward_1 = new Sprite(0, 1, 20, 32, player2);
		player_side = new Sprite(0, 0, 20, 32, playerside);
		player_side_1 = new Sprite(1, 0, 20, 32, playerside);
		player_side_2 = new Sprite(2, 0, 20, 32, playerside);
	}
}