package sonar.gamestates.levels.entities;

public class PlayerHolder
{
	//Sprite player, player2, player_1, player_2, player2_1, player2_2;
	Sprite playerBack, playerSide, playerForward , playerSide1, playerSide2, playerForward1, playerBackward1;
	Sprite trial;
	//Sprite trial;
	public PlayerHolder()
	{
		SpriteSheet player = new SpriteSheet("/textures/sheets/players/player.png");
		SpriteSheet playerside = new SpriteSheet("/textures/sheets/players/playerside.png");
		SpriteSheet trialSheet = new SpriteSheet("/textures/sheets/players/trialSprite.png");
		playerBack = new Sprite(0, 0, 20, 32, player);
		playerBackward1 = new Sprite(0, 1, 20, 32, player); //Wings blue, Face and Neck is 102 cyanish, Players frame is 153, Player claws is 204, player face and body 255
		playerForward = new Sprite(1, 0, 20, 32, player, 0xff00ff00, 0xff0000ff, 0xff69dcd9, 0xffc92125, 0xff26d30e, 0xffb89a32); //0xff00ff00, 0xffff0000, 0xff0000ff, 0xffff00ff);
		playerForward1 = new Sprite(1, 1, 20, 32, player);
		playerSide = new Sprite(0,0, 20, 32, playerside);
		playerSide1 = new Sprite(1, 0, 20, 32, playerside);
		playerSide2 = new Sprite(2, 0, 20, 32, playerside);
		trial = new Sprite(0, 0, 12, 12, trialSheet);
		
		/*SpriteSheet trial2 = new SpriteSheet("/textures/sixcolours.png");
		SpriteSheet sheet = new SpriteSheet("/textures/triangle.png");
		//player = new Sprite(0, 0, 16, 16, sheet);
		SpriteSheet sheet2 = new SpriteSheet("/textures/grayscale.png");
		player2 = new Sprite(0, 0, 16, 16, sheet2);
		trial = new Sprite(0,0,12,12, trial2, 0xff00ff00, 0xffff0000, 0xff0000ff, 0xffff00ff, 0xff00ffff, 0xff000000);*/
	}
}