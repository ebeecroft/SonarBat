package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sonar.Game;

class Background
{
	private BufferedImage image;
	private double x, y, dx, dy;
	//private double moveScale;
	
	Background(String path, double ms)
	{
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream(path));
		//	moveScale = ms;
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*private void setPosition(double x, double y, Game game)
	{
		this.x = (x * moveScale) % game.getWindowWidth();
		this.y = (y * moveScale) % game.getWindowHeight();
	}*/
	
	void setVector(double dx, double dy)
	{
		this.dx = dx;
		this.dy = dy;
	}
	
	void update()
	{
		x += dx;
		y += dy;
	}
	
	void render(Graphics g, Game game)
	{
		g.drawImage(image, (int) x, (int) y, null);
		if(x < 0)
		{
			g.drawImage(image, (int) x + game.getWindowWidth() , (int) y, null);
		}
		if(x > 0)
		{
			g.drawImage(image, (int) x - game.getWindowWidth(), (int) y, null);
		}
	}
}