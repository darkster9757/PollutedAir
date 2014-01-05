package uk.co.redabsol0.entity;

import java.awt.Graphics;

import uk.co.redabsol0.core.CoreObject;
import uk.co.redabsol0.gfx.Texture;

public class Player extends CoreObject
{
	
	public Player(int x, int y, int id, Texture tex) 
	{
		super(x, y, id, tex);
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(tex.blockGrass, 100, 100, null);
	}

	@Override
	public void tick() 
	{
		x += velx;
		y += vely;
	}

}
