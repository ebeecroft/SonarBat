package sonar.gamestates.levels;

import java.util.Stack;

class LevelLoader
{
	/*The LevelLoader class is utilized to switch the various different levels. To do
	 * this we implement a stack to do so. A stack uses a peak, pop and push
	 * functionality. In order to prevent the levelLoader from being overwhelmed with
	 * levels we will use a levelHolder to keep the levels that are available. We
	 * also need to remember to return the current level to the LM. We push on the
	 * new level and removed the old one. Every level needs to have a lm so that we
	 * can switch in the levels.
	 */
	
	private Stack<Level> levels;
	private Level newLevel;
	private LevelHolder hold;
	private LevelManager lm;
	
	public LevelLoader(LevelManager lm, String levelType)
	{
		this.lm = lm;
		levels = new Stack<Level>();
		hold = new LevelHolder();
		
		if(levelType == "Zap")
		{
			setLevel(hold.zapLevel1);	
		}
		else if(levelType == "Blaze")
		{
			
		}
		else if(levelType == "Dyna")
		{
			
		}
		else
		{
			System.err.println("Error you used a state that shouldn't have been accessed.");
		}
	}
	
	private void pushLevel(int level)
	{
		newLevel = null;
		if(level == hold.zapLevel1) newLevel = new ZapLevel1(lm, "/textures/level/zap/zap1.png"); 
		levels.push(newLevel);
	}
	private void popLevel(){if(newLevel != null) levels.pop();}
	void setLevel(int level)
	{
		popLevel();
		pushLevel(level);
	}
	
	Level getCurrent(){return levels.peek();}
}