package uk.co.redabsol0.core;

import java.awt.Graphics;
import java.util.ArrayList;

public class Controller 
{
	
	private static ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
	
	public void tick()
	{
		for(CoreObject obj : objects)
		{
			obj.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(CoreObject obj : objects)
		{
			obj.render(g);
		}
	}
	
	public static void addObject(CoreObject instance)
	{
		objects.add(instance);
	}
	
	public static void removeObject(CoreObject instance)
	{
		objects.remove(instance);
	}
	
	public static ArrayList<CoreObject> getObjects()
	{
		return objects;
	}
	
}
