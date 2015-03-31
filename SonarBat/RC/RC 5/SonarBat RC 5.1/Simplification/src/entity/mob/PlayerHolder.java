package entity.mob;

import entity.Sprite;
import entity.SpriteSheet;

public class PlayerHolder
{
	Sprite playerBack, playerForward, playerSide;
	Sprite playerBack1, playerForward1, playerSide1;
	Sprite playerBack2, playerForward2, playerSide2;
	
	public PlayerHolder()
	{
		SpriteSheet player = new SpriteSheet("/textures/sheets/players/player.png");
		SpriteSheet playerside = new SpriteSheet("/textures/sheets/players/playerside.png");
		playerBack = new Sprite(0, 0, 20, 32, player);
		playerBack1 = new Sprite(0, 1, 20, 32, player); //Wings blue, Face and Neck is 102 cyanish, Players frame is 153, Player claws is 204, player face and body 255
		playerForward = new Sprite(1, 0, 20, 32, player, 0xff00ff00, 0xff0000ff, 0xff69dcd9, 0xffc92125, 0xff26d30e, 0xffb89a32); //0xff00ff00, 0xffff0000, 0xff0000ff, 0xffff00ff);
		playerForward1 = new Sprite(1, 1, 20, 32, player);
		playerSide = new Sprite(0,0, 20, 32, playerside);
		playerSide1 = new Sprite(1, 0, 20, 32, playerside);
		playerSide2 = new Sprite(2, 0, 20, 32, playerside);
	}
}