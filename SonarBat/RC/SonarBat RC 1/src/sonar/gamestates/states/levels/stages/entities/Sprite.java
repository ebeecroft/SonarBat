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
	public int[] getPixels(){return buildSprite.getPixels();}
	public int getHiddenColour(){return buildSprite.hiddenColour();}
	
	public int[] getColours()
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
	
	public int getColourSize()
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