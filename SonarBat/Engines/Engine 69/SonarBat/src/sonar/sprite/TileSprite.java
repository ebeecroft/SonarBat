package sonar.sprite;

import sonar.graphics.Sprite;
import sonar.graphics.SpriteSheet;

public class TileSprite
{
	public Sprite grass;
	public Sprite voidSprite;
	public Sprite wall;
	TileSprite()
	{
		SpriteSheet tiles = new SpriteSheet("/textures/sheets/tiles/spritesheet16.png");
		voidSprite = new Sprite(16, 0x000099);
		grass = new Sprite(0, 0, 16, 16, tiles);
		wall = new Sprite(1, 0, 16, 16, tiles);
	}
}