package uk.co.redabsol0.core;

import java.awt.Graphics;

import uk.co.redabsol0.gfx.Texture;

public abstract class CoreObject
{
	protected int x, y, velx, vely;
	protected int id;
	protected Texture tex;
	
	public CoreObject(int x, int y, int id, Texture tex)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setVelx(int velx) {
		this.velx = velx;
	}

	public void setVely(int vely) {
		this.vely = vely;
	}
}