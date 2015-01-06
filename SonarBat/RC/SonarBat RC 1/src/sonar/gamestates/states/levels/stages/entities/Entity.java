package sonar.gamestates.states.levels.stages.entities;

public abstract class Entity
{
	private String type;
	protected Entity(String type){this.type = type;}
	public String getType(){return type;}
}