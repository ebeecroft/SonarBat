package sonar;

//Builds the actual states for the game depending on the type.
public interface StateBuilder
{
	String stateType();
	String getIdentity();
}

class SingleStateBuilder implements StateBuilder
{
	private String identity, path;
	SingleStateBuilder(String identity, String path)
	{
		this.identity = identity;
		this.path = path;
	}
	public String stateType(){return "Single";}
	public String getIdentity(){return identity;}
	public String getPath(){return path;}
}

class DualStateBuilder implements StateBuilder
{
	private String identity, path;
	DualStateBuilder(String identity){this.identity = identity;}
	public String stateType(){return "Dual";}
	public String getIdentity(){return identity;}
	void setPath(String path){this.path = path;}
	public String getPath(){return path;}
}