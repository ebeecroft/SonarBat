package sonar.gamestates.states.levels.stages.entities.animations.energies;

import sonar.gamestates.Screen;
import sonar.gamestates.states.levels.stages.entities.Entity;
import sonar.gamestates.states.levels.stages.entities.Sprite;
import sonar.gamestates.states.levels.stages.entities.animations.DynamicAnimation;

public class Energy extends Entity
{
	private EnergyBuilder buildEnergy;
	private DynamicAnimation curAnim;
	Energy(EnergyBuilder buildEnergy)
	{
		super("Energy");
		this.buildEnergy = buildEnergy;
	}
	
	void update()
	{
		
	}
	
	void render(Screen screen){screen.renderEnergy(this);}
	int getX(){return buildEnergy.getX();}
	int getY(){return buildEnergy.getY();}
	Sprite getSprite(){return curAnim.getSprite();}
	int getWidth(){return curAnim.getSprite().getWidth();}
	int getHeight(){return curAnim.getSprite().getHeight();}
	String getEnergyType(){return buildEnergy.getType();}
	void setCurAnim(DynamicAnimation curAnim){this.curAnim = curAnim;}
}