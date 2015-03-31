package sonar.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class LevelSelect extends GameState
{
	private Background bg;
	private int choice = 0;
	private String[] options = {"FinalBoss", "Boss1" , "Boss2", "Boss3"};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	
	LevelSelect(GameStateManager gsm)
	{
		super(gsm);
		bg = new Background("/textures/backgrounds/levelselectScreen.png");
		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Century Gothic", Font.PLAIN, 28);
		font = new Font("Arial", Font.PLAIN, 12);
	}
	
	void update()
	{
		if(getGsm().getKey().up) choice = 2;
		if(getGsm().getKey().down) choice = 0;
		if(getGsm().getKey().left) choice = 1;
		if(getGsm().getKey().right) choice = 3;
		if(getGsm().getKey().attack) select();
	}
	
	private void select()
	{
		if(choice == 0);// getGsm().setState(getGsm().lsState);
		if(choice == 1) getGsm().setState(getGsm().zstate); //getGsm().setState(getGsm().pstate);
		if(choice == 2);
		if(choice == 3);
	}
	
	void render(Graphics g)
	{
		bg.render(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Sonar Bat", 230, 30);
		
		g.setFont(font);
		for(int i = 0; i < options.length; i++)
		{
			if(i == choice)
			{
				g.setColor(Color.BLACK);
			}
			else
			{
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 280, 80 + i * 15);
		}
	}
}