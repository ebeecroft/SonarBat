package sonar.gamestates.states.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import sonar.Game;
import sonar.gamestates.GSM;
import sonar.gamestates.states.levels.stages.StarterStage1;
import sonar.gamestates.states.levels.stages.StarterStage2;
import sonar.gamestates.states.levels.stages.StarterStage3;
import sonar.gamestates.states.levels.stages.entities.SpriteManager;
import sonar.gamestates.states.levels.stages.entities.animations.tiles.TileManager;

public class LM
{
	//LevelManager allows us to switch between different levels.
	private Level currentLevel;
	private SpriteManager smanage;
	private TileManager tmanage;
	private Screen screen;
	private Game game;
	
	public LM(String stageType, GSM gsm)
	{
		game = gsm.getGame();
		smanage = new SpriteManager(stageType);
		tmanage = new TileManager(smanage);
		screen = new Screen(game.getWindowWidth(), game.getWindowHeight());
		if(stageType.equals("Starter")){setLevel(LevelHolder.starterStage1);}
	}
	
	private void loadLevel(int level)
	{
		currentLevel = null;
		if(level == LevelHolder.starterStage1) currentLevel = new StarterStage1(new DynamicLevelBuilder("/textures/stages/starter/Starter1.png"), this);
		if(level == LevelHolder.starterStage2) currentLevel = new StarterStage2(new DynamicLevelBuilder("/textures/stages/starter/Starter2.png"), this);
		if(level == LevelHolder.starterStage3) currentLevel = new StarterStage3(new DynamicLevelBuilder("/textures/stages/starter/Starter3.png"), this);
	}
	
	void setLevel(int level){loadLevel(level);}
	public void update()
	{
		currentLevel.update();
	}
	
	public void render(Graphics g)
	{
		int xScroll =  0;///-screen.getWidth();
		int yScroll =  0; //-screen.getHeight();
		currentLevel.render(xScroll, yScroll, screen);
		BufferedImage image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.getPixels()[i];
		}
		g.drawImage(image, 0, 0, game.getWidth(), game.getHeight(), null);
	}
	
	SpriteManager getSmanage(){return smanage;}
	TileManager getTmanager(){return tmanage;}
}