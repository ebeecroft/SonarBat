package sonar;

class Start
{
	public static void main(String[] args)
	{
		Game game = new Game(300, 169, 2);
		new Window(game);
	}
}