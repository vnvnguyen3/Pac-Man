package pacman.states;

import java.awt.Graphics;

import pacman.Handler;
import pacman.world.World;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world");
		handler.setWorld(world);
	}

	public void tick() {
		world.tick();
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
}
