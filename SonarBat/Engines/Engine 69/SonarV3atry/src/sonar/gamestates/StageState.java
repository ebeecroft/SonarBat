package sonar.gamestates;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import sonar.gamestates.levels.LevelManager;
import sonar.gamestates.levels.entities.Screen;

class StageState extends GameState
{
	private LevelManager lm;
	private Screen screen;
	private BufferedImage image;
	private int[] pixels;
	
	void setScreen(int width, int height){screen = new Screen(width, height);}
	Screen getScreen(){return screen;}
	void setImage(){image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);}
	BufferedImage getImage(){return image;}
	void initPixels(){pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();}
	int[] getPixels(){return pixels;}
	void setLm(String stage, Keyboard key){lm = new LevelManager(stage, key);}
	LevelManager getLm(){return lm;}
	void clearAll()
	{
		lm = null;
		screen = null;
		pixels = null;
		image = null;
	}
}