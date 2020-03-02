package pacman;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import pacman.display.Display;
import pacman.gfx.Assets;
import pacman.input.KeyManager;
import pacman.states.GameState;
import pacman.states.State;
import pacman.states.TitleState;

public class Game implements Runnable{
	
	private Handler handler;
	private Display display;
	
	public String title;
	private int width, height;
	
	public State gameState;
	public State titleState;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private KeyManager keyManager;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}
	
	private void tick() {
		keyManager.tick();
		if(gameState != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here
		State.getState().render(g);
		//End Drawing
		bs.show();
		g.dispose();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		Assets.init();
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		titleState = new TitleState(handler);
		State.setState(titleState);
	}
	
	@Override
	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		//check fps
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
