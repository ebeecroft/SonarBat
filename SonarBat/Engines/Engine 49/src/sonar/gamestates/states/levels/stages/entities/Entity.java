package sonar.gamestates.states.levels.stages.entities;

public abstract class Entity
{
	//Any object that exist in the game.
	private String type;
	protected Entity(String type){this.type = type;}
	public String getType(){return type;}
}