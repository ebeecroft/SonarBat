package entity.mob.characters;

import entity.Location;
import entity.mob.Force;

public class Falling
{
	void fall(Force force, Location position)
	{
		if(force.getDownForce().getGravity() != 0)
		{
			position.setY(position.getY() + (int) force.getVelY());
			force.setVelY(force.getVelY() + force.getDownForce().getGravity());
			if(force.getVelY() > force.getMax().getMaxSpeed())
				force.setVelY(force.getMax().getMaxSpeed());			
		}		
	}
}