package sonar;

public class Start
{
	public static void main(String[] args)
	{
		//Creates the physical Game that will soon be run
		Game game = new Game();
		new Window(game);
	}
}