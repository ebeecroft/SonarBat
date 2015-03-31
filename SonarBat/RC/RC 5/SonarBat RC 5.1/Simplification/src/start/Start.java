package start;

//Making this class default since no other classes will ever call this one
class Start
{
	/*
	1) A window 
	2) some graphics 
	3) some objects
	4) some input
	5) some physics*/
	
	public static void main(String[] args)
	{
		//Create the game with a width, height and a scale
		Game game = new Game(300, 200, 2);
		//Create the window and pass game into it
		new Window(game);
	}
}