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
	
	public void render(Screen screen){screen.render(this, getX(), getY(), getWidth(), getHeight());}
	public int getX(){return buildEnergy.getX();}
	public int getY(){return buildEnergy.getY();}
	public Sprite getSprite(){return curAnim.getSprite();}
	public int getWidth(){return curAnim.getSprite().getWidth();}
	public int getHeight(){return curAnim.getSprite().getHeight();}
	String getEnergyType(){return buildEnergy.getType();}
	void setCurAnim(DynamicAnimation curAnim){this.curAnim = curAnim;}
}