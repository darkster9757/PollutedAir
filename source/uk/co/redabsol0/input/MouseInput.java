package uk.co.redabsol0.input;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import uk.co.redabsol0.core.Game;
import uk.co.redabsol0.enums.GameState;
import uk.co.redabsol0.libs.Audio;
import uk.co.redabsol0.utils.AudioPlayer;

public class MouseInput extends MouseAdapter
{
	
	
	public static boolean pressed = false;
	
	public static int MOUSE_X, MOUSE_Y;
	public static Rectangle MOUSE = new Rectangle(1, 1, 1, 1);
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int mouse = e.getButton();
		Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
		
		if(mouse == MouseEvent.BUTTON1)
		{
			
			switch(Game.state)
			{
			case ACHIEVMENTS:
				break;
			case GAME:
				break;
			case MENU:
				if(rect.intersects(Game.getInstance().menu.play))
				{
					AudioPlayer.playSound(Audio.SOUNDEDING);
					Game.state = GameState.GAME;
					AudioPlayer.stopMusic(Audio.MUSIC_FOREST);
					AudioPlayer.loopMusic(Audio.SPACE);
				}
				if(rect.intersects(Game.getInstance().menu.quit))
				{
					AudioPlayer.playSound(Audio.SOUNDEDING);
					System.out.println("Succesfully closed!");
					System.exit(1);
				}
				if(rect.intersects(Game.getInstance().menu.website))
				{
					try
					{
						String url = "http://redabsol0.co.uk/PollutedAir.html";
						String cmd = "cmd.exe /c start" + url;
						Runtime.getRuntime().exec(cmd);
					}
					catch(Exception ex)
					{
						
					}
				}
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
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		pressed = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		pressed = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		MOUSE_X = e.getX();
		MOUSE_Y = e.getY();
		MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
		}
	
}
