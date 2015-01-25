package sonar.gamestates.states.levels.stages.entities;

public class Sprite
{
	private SpriteBuilder buildSprite;
	Sprite(SpriteBuilder buildSprite)
	{
		this.buildSprite = buildSprite;
	}
	
	public int getWidth(){return buildSprite.getWidth();}
	public int getHeight(){return buildSprite.getHeight();}
	int[] getPixels(){return buildSprite.getPixels();}
	int getHiddenColour(){return buildSprite.hiddenColour();}
	
	int[] getColours()
	{
		int[] colours = null;
		if(buildSprite.spriteType().equals("Grey"))
		{
			GreySpriteBuilder sprite = (GreySpriteBuilder) buildSprite;
			colours = sprite.getColours();
			buildSprite = sprite;
		}
		return colours;
	}
	
	int getColourSize()
	{
		int size = 0;
		if(buildSprite.spriteType().equals("Grey"))
		{
			GreySpriteBuilder sprite = (GreySpriteBuilder) buildSprite;
			size = sprite.colourSize();
			buildSprite = sprite;
		}
		return size;
	}
}