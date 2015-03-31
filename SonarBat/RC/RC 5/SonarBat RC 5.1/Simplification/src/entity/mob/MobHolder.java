package entity.mob;


public class MobHolder
{
	//Holds all of the Mobs available
	private PlayerHolder phold;
	MobHolder()
	{
		phold = new PlayerHolder();
	}
	
	PlayerHolder getPhold(){return phold;}
}