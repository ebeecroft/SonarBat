package sonar.gamestates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Background
{
	/*The Background class is what gives us our actual image by taking in the path
	 * in the constructor. We then assign the image to what we retrieved from the
	 * IOstream and it then will be updated and rendered accordingly. Every
	 * background will also have its own render and update function so it can be
	 * changed on the fly but most times it will only render a fixed image. The
	 * image gets drawn to the screen by using the drawImage command.
	 */
	private BufferedImage image;
	
	Background(String path)
	{
		try {image = ImageIO.read(getClass().getResourceAsStream(path));}
		catch (Exception e){e.printStackTrace();}
	}
	
	void update()
	{
		
	}
	
	void render(Graphics g){g.drawImage(image, 0, 0, 300, 200, null);}
}