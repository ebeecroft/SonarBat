package sonar.gamestates;

import sonar.gamestates.levels.entities.Sprite;

abstract class DisplayBossState extends BackgroundState
{
	private Sprite sprite;
	
	DisplayBossState(GameStateManager gsm){super(gsm);}	
	Sprite getSprite(){return sprite;}
	void setSprite(Sprite sprite){this.sprite = sprite;}
}