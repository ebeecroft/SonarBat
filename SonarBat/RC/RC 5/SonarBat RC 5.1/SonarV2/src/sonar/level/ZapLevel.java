package sonar.level;

class ZapLevel extends Level
{
	ZapLevel(LevelManager lm, String path){super(lm, path); if(path == null) System.out.println("Zaps path is null");}
}