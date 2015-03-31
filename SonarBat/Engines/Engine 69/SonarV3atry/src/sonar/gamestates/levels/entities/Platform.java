package sonar.gamestates.levels.entities;

public class Platform extends Entity
{
	private double velX, velY;
	private boolean falling, jumping;
	private double gravity = 0.05;
	private int maxSpeed = 10;

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public boolean isFalling() {
		return falling;
	}
	
	double getGravity(){return gravity;}
	void setGravity(double value){gravity = value;}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	
	int getMaxSpeed(){return maxSpeed;}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}