package uk.co.redabsol0.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import uk.co.redabsol0.libs.Audio;
import uk.co.redabsol0.libs.Images;
import uk.co.redabsol0.libs.Reference;
import uk.co.redabsol0.utils.AudioPlayer;
import uk.co.redabsol0.utils.Button;

public class Menu 
{
	
	public Button play, options, website, achievments, quit; 
	// private static int centerY = Game.HEIGHT / 2;
	
	public Menu()
	{
		int fillerY = 350;
		play = new Button(Reference.CENTER_X - 145, fillerY, 300, 50).setText("Play");
		options = new Button(Reference.CENTER_X - 145, fillerY += 75, 300, 50).setText("Options");
		website = new Button(Reference.CENTER_X - 145, fillerY += 75, 300, 50).setText("Website");
		achievments = new Button(Reference.CENTER_X - 145, fillerY += 75, 300, 50).setText("Achievments");
		quit = new Button(Reference.CENTER_X - 145, fillerY += 75, 300, 50).setText("Quit");
	}
	
	public void drawButton(Graphics g, Rectangle rect, String recttext, int offsetX)
	{
		
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(recttext, rect.x + offsetX, rect.y + 40);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawImage(Images.backgroundmountains, 0, 0, null);
		g.drawImage(Images.title, Reference.CENTER_X - 320, 70, null);
		g.drawImage(Images.playerStill, 0, 738, null);
		
		Font tempFont = new Font("Arial", Font.BOLD, 48);
		g.setFont(tempFont);
		
		play.drawButton(g, 55);
		options.drawButton(g, 90);
		website.drawButton(g, 90);
		achievments.drawButton(g, 148);
		quit.drawButton(g, 50);
	}
	
}
