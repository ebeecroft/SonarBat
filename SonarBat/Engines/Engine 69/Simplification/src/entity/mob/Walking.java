package entity.mob;

public class Walking
{
	private int dir;
	private boolean walking;
	public void walk(int xa, int ya)
	{
		//wall hit and player falls through ground
		if(xa != 0 || ya != 0)
		{
			move(xa, ya);
			walking = true;
		}
		else walking = false;
	}
	
	private void move(int xa, int ya)
	{
		//-1, 0, 1
		if(xa != 0 && ya != 0)
		{
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(xa > 0){dir = 1;}
		if(xa < 0){dir = 3;}
		//Only for ladder
		if(ya > 0) dir = 2;
		if(ya < 0) dir = 0;
	}
	
	int getDir(){return dir;}
	boolean getWalking(){return walking;}
}