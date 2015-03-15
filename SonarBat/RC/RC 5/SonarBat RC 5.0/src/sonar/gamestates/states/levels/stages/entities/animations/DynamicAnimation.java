package sonar.gamestates.states.levels.stages.entities.animations;

import sonar.gamestates.states.levels.stages.entities.Sprite;

public class DynamicAnimation implements AnimationType
{
	//Animation that changes itself automatically when run.
	private Sprite currentSprite;
	private int index = 0, frameSize;
	private Sprite[] animation;
	public DynamicAnimation(Sprite... sprites)
	{
		currentSprite = sprites[0];
		frameSize = sprites.length;
		animation = sprites;
	}
	
	public void update()
	{
		if(index == frameSize) index = 0;
		else index++;
		currentSprite = animation[index];
	}
	
	public void reset(){index = 0;}
	public Sprite getSprite(){return currentSprite;}
	public String animType(){return "Dynamic";}
}