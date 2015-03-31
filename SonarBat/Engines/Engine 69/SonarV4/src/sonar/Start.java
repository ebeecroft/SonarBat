package sonar;

class Start
{
	public static void main(String[] args)
	{
		/*In the Start class I want to perform two basic tasks. The first one is
		 * to create the Game itself. The game will need to take four parameters
		 * the first one is the width of the game itself, this means how wide
		 * the screen will be. The next parameter is height which will be how
		 * tall the screen will be. The third parameter is scale which tells the
		 * screen by how much we want to scale the screen by. The fourth and
		 * final parameter is the title. The title is a string that gives the
		 * name of the actual game I am trying to create.
		 * 
		 * The other class that will need to be created is the window class.
		 * This class will take in the game parameter and will effectively build
		 * the actual window for the game. After that the Start class will be
		 * done. Also as an added measure I tend to make my classes default for
		 * the first four to prevent them from being utilized by other classes
		 * that do not belong to the same package as these will never be used by
		 * classes in other packages.*/
		
		Game game = new Game(300, 169, 2, "SonarBat V1.1");
		new Window(game);
	}
}