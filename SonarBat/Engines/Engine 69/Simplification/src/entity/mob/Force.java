package entity.mob;


public class Force
{
	private double velX, velY;
	private Gravity downForce;
	private MaxSpeed max;
	
	Force()
	{
		downForce = new Gravity();
		max = new MaxSpeed();
	}
	
	public double getVelX(){return velX;}
	public void setVelX(double velX){this.velX = velX;}
	public double getVelY(){return velY;}
	public void setVelY(double velY){this.velY = velY;}
	public Gravity getDownForce(){return downForce;}
	public MaxSpeed getMax(){return max;}
}