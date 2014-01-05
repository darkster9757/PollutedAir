package uk.co.redabsol0.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import uk.co.redabsol0.input.MouseInput;

@SuppressWarnings("serial")
public class Button extends Rectangle 
{
	
	private String text;

	public Button() 
	{
		super();
	}

	public Button(Rectangle r) 
	{
		super(r);
	}

	public Button(Point p) 
	{
		super(p);
	}

	public Button(Dimension d) 
	{
		super(d);
	}

	public Button(int width, int height) 
	{
		super(width, height);
	}

	public Button(Point p, Dimension d) 
	{
		super(p, d);
	}

	public Button(int x, int y, int width, int height) 
	{
		super(x, y, width, height);
	}
	
	public Button setText(String text)
	{
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset)
	{
		int xx = x + ((width / 2) - offset);
		int yy = y + 38;
		g.drawString(text, xx, yy);
		if(MouseInput.MOUSE.intersects(this))
		{
			g.setColor(Color.RED);
		}
		else
			g.setColor(Color.WHITE);
		if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
			g.drawRect(x, y, width, height);
		else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this))
			g.fillRect(x, y, width, height);
		g.drawString(text, xx, yy);
	}

}
