package sonar.gamestates;

class BackgroundState extends GameState
{
	/*The backgroundState class is used to set up our image that will serve an image to
	 * the screen before something else is placed on top of it. This will be utilized
	 * by all single and dual states as everything will have an image applied to it.
	 * However only one image can be active at a time. There will never be two images
	 * active at one time. It also extends the gamestate so that all subclasses can
	 * inherit from the base class. Also in this class we set the gsm to the passed in
	 * gsm so that we can switch between states. Bg is set and unset and also utilizes
	 * a getter to perform its operation.
	 */
	private Background bg;
	BackgroundState(){}
	
	//Getters and setters used by subclasses only
	Background getBg(){return bg;}
	private void loadBg(String path){bg = new Background(path);}
	private void unloadBg(){bg = null;}
	void setBg(String path)
	{
		unloadBg();
		loadBg(path);
	}
}