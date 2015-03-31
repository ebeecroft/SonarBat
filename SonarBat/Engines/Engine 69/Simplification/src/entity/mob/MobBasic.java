package entity.mob;

import entity.Basic;
import entity.Screen;

public class MobBasic
{
	private Walking walk;
	private int animate;
	
	public void play()
	{
		if(animate < 7500) animate++;
		else animate = 0;		
	}
	
	void placeObject(Screen screen, Basic basic, Mob mob)
	{
		//flip
		if(entity == "Player") screen.renderPlayer(basic.getX(), basic.getY(), mob, -1);
	}
}