package sonar.gamestates.levels;

import java.util.Random;

class StaticLevel extends Level
{
	/*The StaticLevel class is a subclass of Level and what is designed to do
	 * is to create a level from a set of statically defined width and height.
	 * By doing this the level will be created in a static way since it
	 * doesn't use a file to create its level. So each time it is created it
	 * will only stay the specified size it was defined as. The tiles array
	 * is set utilizing the width and height that are passed in as constructor
	 * arguments. The width and height are also set right here in the
	 * constructor as well. The last thing that is needed is to generate the
	 * level. The generateLevel is created by two for loops which use a
	 * random variable called random to generate a map at random each time
	 * it is created with a fixed width and height. Like the DynamicLevel
	 * class this one will also be abstract since it is never necessary to
	 * construct a new StaticLevel as this will serve as a template only.
	 */
	private Random random;
	
	StaticLevel(LevelManager lm, int width, int height)
	{
		setLm(lm);
		setWidth(width);
		setHeight(height);
		getDrawObject().setTiles(width, height);
		random = new Random();
		generateLevel();
	}
	
	private void generateLevel()
	{
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				getDrawObject().getTiles()[x + y * getWidth()] = random.nextInt(4);
			}
		}
	}
}