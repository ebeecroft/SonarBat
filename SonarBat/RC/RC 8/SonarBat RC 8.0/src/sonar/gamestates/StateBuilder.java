package sonar.gamestates;

//Builds the actual states for the game depending on the type.
public interface StateBuilder
{
	String stateType();
}

class SingleStateBuilder implements StateBuilder
{
	public String stateType(){return "Single";}
}

class DualStateBuilder implements StateBuilder
{
	public String stateType(){return "Dual";}
}