package uk.co.redabsol0.gfx;

import java.awt.Color;
import java.awt.Graphics;

import uk.co.redabsol0.core.Game;
import uk.co.redabsol0.screens.Menu;

public class Renderer 
{
	
	//private static Game game = Game.getInstance();
	
	public void renderBackground(Graphics g)
	{
		switch(Game.state)
		{
		case ACHIEVMENTS:
			break;
		case GAME:
			break;
		case MENU:
			Game.getInstance().menu.render(g);
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case WEBSITE:
			
			break;
		default:
			g.setColor(Color.RED);
			g.drawString("UNKNOWN GAMESTATE", 683, 384);
			break;
		
		}
	}
	
	public void renderForeground(Graphics g)
	{
		switch(Game.state)
		{
		case ACHIEVMENTS:
			break;
		case GAME:
			Game.getInstance().getController().render(g);
			break;
		case MENU:
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case WEBSITE:
			break;
		default:
			break;
		
		}
	}
	
}
