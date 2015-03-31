package entity.mob.characters;

import start.gamestate.Keyboard;
import entity.mob.Force;
import entity.mob.MobChange;

public class PlayerControls
{
	void keys(Keyboard input, Force force, MobChange change, int xa)
	{
		//if(input.up) setY(getY() + ya--);
		//if(input.down) setY(getY() + ya++);
		//int xa = 0;//ya = 0;
		if(input.left)
		{
			change.setXa(xa--);
			System.out.println("My xa in change is set to: " + change.getXa());
		}
		if(input.right) change.setXa(xa++);
		if(input.jump && force.getDownForce().getGravity() == 0)
		{
			force.setVelY(-2);
			force.getDownForce().setGravity(0.05);
		}
		//System.out.println("My xa position is: " + xa);
		force.setVelX(xa);
		
		//getMove().mobMove(change, getStroll(), getSetup().getMove());
	}
}