package sonar.level;

import sonar.entities.Sprite;
import sonar.entities.SpriteSheet;

class TileSprite
{
	Sprite grass;
	Sprite voidSprite;
	Sprite wall;
	TileSprite()
	{
		SpriteSheet tiles = new SpriteSheet("/textures/sheets/tiles/spritesheet16.png");
		voidSprite = new Sprite(16, 0x000099);
		grass = new Sprite(0, 0, 16, 16, tiles);
		wall = new Sprite(1, 0, 16, 16, tiles);
	}
}