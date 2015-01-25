package sonar.gamestates.states.levels.stages.entities.animations;

import sonar.gamestates.states.levels.stages.entities.Sprite;

public class StaticAnimation implements AnimationType
{
	private Sprite sprite;
	public StaticAnimation(Sprite sprite){this.sprite = sprite;}
	public Sprite getSprite(){return sprite;}
	public String animType(){return "Static";}
}