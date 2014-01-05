package uk.co.redabsol0.utils;

import java.io.IOException;

import uk.co.redabsol0.libs.Audio;
import uk.co.redabsol0.libs.Images;
import uk.co.redabsol0.libs.Reference;

public class ResourceLoader 
{
	
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages()
	{
		try
		{
			Images.title = imageLoader.loadImage(Reference.GUI_LOCATION + "title.png");
			Images.background = imageLoader.loadImage(Reference.GUI_LOCATION + "menubg.gif");
			Images.backgroundstars = imageLoader.loadImage(Reference.GUI_LOCATION + "menubgstars.gif");
			Images.backgroundmountains = imageLoader.loadImage(Reference.GUI_LOCATION + "menubgmountains.gif");
			Images.icon = imageLoader.loadImage(Reference.GUI_LOCATION + "icon.png");
			Images.blocksprites = imageLoader.loadImage(Reference.SPRITE_LOCATION + "blocksprites.gif");
			Images.playersprites = imageLoader.loadImage(Reference.SPRITE_LOCATION + "playersprites.gif");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadSounds()
	{
		AudioPlayer.addSound(Audio.SOUNDEDING, "ding.ogg");
	}
	
	public static void loadMusic()
	{
		AudioPlayer.addMusic(Audio.MUSIC_FOREST, "quietforest.ogg");
		AudioPlayer.addMusic(Audio.SPACE, "space.ogg");
	}
	
}
