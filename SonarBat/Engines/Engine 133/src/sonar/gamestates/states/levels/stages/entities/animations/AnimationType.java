package sonar.gamestates.states.levels.stages.entities.animations;

import sonar.gamestates.states.levels.stages.entities.Sprite;

public interface AnimationType
{
	//Basic Animation class that is used with sprites.
	Sprite getSprite();
	String animType();
}