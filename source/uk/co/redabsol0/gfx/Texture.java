package uk.co.redabsol0.gfx;

import java.awt.image.BufferedImage;

import uk.co.redabsol0.libs.Images;
import uk.co.redabsol0.utils.SpriteSheet;

public class Texture 
{
	
	private SpriteSheet sheetBlock;
	private SpriteSheet sheetPlayer;
	
	public BufferedImage blockDeepGround;
	public BufferedImage blockGround;
	public BufferedImage blockGrass;
	public BufferedImage playerStill;
	
	public Texture()
	{
		sheetBlock = new SpriteSheet(Images.blocksprites, 32);
		sheetPlayer = new SpriteSheet(Images.playersprites, 30);
		
		initTextures();
	}
	
	private void initTextures()
	{
		Images.blockDeepGround = sheetBlock.getSprite(1, 1);
		Images.blockGround = sheetBlock.getSprite(2, 1);
		Images.blockGrass = sheetBlock.getSprite(3, 1);
		Images.playerStill = sheetPlayer.getSprite(1, 1);
	}
	
}
