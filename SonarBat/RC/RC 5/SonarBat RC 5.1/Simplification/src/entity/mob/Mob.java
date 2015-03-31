package entity.mob;

import entity.Entity;
import entity.Screen;

public class Mob extends Entity
{
	private SetupEntity setup;
	private PlaceEntity place;
	private Animation animate;
	private Strolling stroll;
	private Collision collide; //Only used in inherited classes
	private PlayAnimation play; //Good for all mobs
	private MobMove move; //Good for all mobs
	private MobChange change; //Good for all mobs
	private MobBasic mbasic;
	
	protected Mob(int x, int y)
	{
		getPosition().setX(x);
		getPosition().setY(y);
		setup = new SetupEntity(); //check
		collide = new Collision(); //check
		play = new PlayAnimation();
		change = new MobChange();
	}
	
	protected void update()
	{
		
	}
	
	public void render(Screen screen, String entity)
	{
		setup.setupObject(entity, getImage(), animate, stroll); //Animate needs to be placed in
		place.placeObject(screen, getPosition(), this, entity);
	}
	
	protected SetupEntity getSetup(){return setup;} //Needed for subclasses
	public Collision getCollide(){return collide;} //Only exists to be called for subclasses
	protected PlayAnimation getPlay(){return play;} //Only exists to be called for subclasses
	protected MobChange getChange(){return change;} //Only exists to be called for subclasses
}