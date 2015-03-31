package sonar.screen;

import sonar.Mobile;

public class Input
{
	public void update(Mobile mobile)
	{
		mobile.getPlayer().getKeyboard().update();
		mobile.getPlayer().update();
	}
}