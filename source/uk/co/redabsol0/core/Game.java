package uk.co.redabsol0.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import uk.co.redabsol0.entity.Player;
import uk.co.redabsol0.enums.GameState;
import uk.co.redabsol0.gfx.Renderer;
import uk.co.redabsol0.gfx.Texture;
import uk.co.redabsol0.input.MouseInput;
import uk.co.redabsol0.libs.Audio;
import uk.co.redabsol0.libs.Reference;
import uk.co.redabsol0.screens.Menu;
import uk.co.redabsol0.utils.AudioPlayer;
import uk.co.redabsol0.utils.ResourceLoader;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 2896149485051079739L;
	private static JFrame frame = new JFrame();
	public static final int WIDTH = 1366;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String TITLE = "Polluted Air";
	private static Game game = new Game();
	public static GameState state = GameState.MENU;
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	public Menu menu;
	private Controller controller = new Controller();
	private Texture tex;
	
	public static Game getInstance()
	{
		return game;
	}
	
	public Menu getMenu()
	{
		return menu;
	}
	
	public Controller getController()
	{
		return controller;
	}
	
	public void init()
	{
		ResourceLoader.loadImages();
		ResourceLoader.loadSounds();
		ResourceLoader.loadMusic();
		tex = new Texture();
		menu = new Menu();
		gfx = new Renderer();
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		Controller.addObject(new Player(100, 100, 1, tex));
		
		AudioPlayer.playMusic(Audio.MUSIC_FOREST);
	}
	
	public void tick()
	{
		if(state == GameState.GAME)
		{
			controller.tick();
		}
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(10, 10, 10));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//Rendering non-important objects (Background + Foreground)
		gfx.renderBackground(g);
		
		//Rendering important objects (Area where player is, enemies, etc)
		gfx.renderForeground(g);
		
		//Disposing
		g.dispose();
		bs.show();
	}

	@Override
	public void run() 
	{
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 70.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running)
		{
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1)
			{
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer+=1000;
				System.out.println(ticks + "Ticks, FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public static void main(String[] args)
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage(Reference.GUI_LOCATION + "icon.png");
		Image cursor = toolkit.getImage(Reference.GUI_LOCATION + "CursorMoon.gif");
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setTitle(TITLE);
		frame.setIconImage(icon);
		frame.setUndecorated(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		game.start();
	}
	
	private synchronized void start()
	{
		if(running)
			return;
		else
			running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop()
	{
		if(!running)
			return;
		else
			running = false;
		
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.exit(1);
	}
}
