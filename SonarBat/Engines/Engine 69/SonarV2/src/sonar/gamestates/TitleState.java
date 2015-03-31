package sonar.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class TitleState extends GameState
{
	//The layout of the menu
	private Background bg;
	
	private int choice = 0;
	private String[] options = {"Start" , "Password"};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	TitleState(GameStateManager gsm)
	{
		super(gsm);
		bg = new Background("/textures/backgrounds/titleScreen.png");
		//Background needs to be here.
		titleColor = new Color(128, 0, 0);
		titleFont = new Font("Century Gothic", Font.PLAIN, 28);
		font = new Font("Arial", Font.PLAIN, 12);
	}
	
	void update()
	{
		if(getGsm().getKey().up && choice > 0) choice--;
		if(getGsm().getKey().down && choice < 1) choice++;
		if(getGsm().getKey().attack) select();
	}
	
	private void select()
	{
		if(choice == 0) getGsm().setState(getGsm().lsState);
		if(choice == 1) getGsm().setState(getGsm().pstate);
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