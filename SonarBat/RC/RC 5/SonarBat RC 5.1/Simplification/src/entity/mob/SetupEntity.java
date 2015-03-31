package entity.mob;

import entity.Image;
import entity.Sprite;

public class SetupEntity
{	
	private Movement move;
	private MobHolder hold;
	
	SetupEntity()
	{
		move = new Movement();
		hold = new MobHolder();
	}
	
	void setupObject(String entity, Image image, Animation animate, Strolling stroll){getWalking(entity, image, animate, stroll);}
	private void getWalking(String entity, Image image, Animation animate, Strolling stroll)
	{
		if(stroll.getWalking()) drawImage(entity, image, animate);//getAnimation();
		else drawImage(entity, image);
	}
	
	private void drawImage(String entity, Image image){drawImage(entity, image, null);}
	private void drawImage(String entity, Image image, Animation animate)
	{
		if(animate == null)
		{
			if(move.getDir() == 0 && entity == "Player") putImage(image, hold.getPhold().playerBack);
			if(move.getDir() == 1 && entity == "Player") putImage(image, hold.getPhold().playerSide);
			if(move.getDir() == 2 && entity == "Player") putImage(image, hold.getPhold().playerForward);
			if(move.getDir() == 3 && entity == "Player") putImage(image, hold.getPhold().playerSide);
		}
		else if(animate.getAnimate() % 20 > 10)
		{
			if(move.getDir() == 0 && entity == "Player") putImage(image, hold.getPhold().playerBack1);
			if(move.getDir() == 1 && entity == "Player") putImage(image, hold.getPhold().playerSide1);
			if(move.getDir() == 2 && entity == "Player") putImage(image, hold.getPhold().playerForward1);
			if(move.getDir() == 3 && entity == "Player") putImage(image, hold.getPhold().playerSide1);
		}
		else
		{
			if(move.getDir() == 0 && entity == "Player") putImage(image, hold.getPhold().playerBack2);
			if(move.getDir() == 1 && entity == "Player") putImage(image, hold.getPhold().playerSide2);
			if(move.getDir() == 2 && entity == "Player") putImage(image, hold.getPhold().playerForward2);
			if(move.getDir() == 3 && entity == "Player") putImage(image, hold.getPhold().playerSide2);
		}
	}
	
	private void putImage(Image image, Sprite sprite){image.setSprite(sprite);}
	public Movement getMove(){return move;}
}