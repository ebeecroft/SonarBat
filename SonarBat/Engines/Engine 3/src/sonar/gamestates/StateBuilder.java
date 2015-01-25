package sonar.gamestates;

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