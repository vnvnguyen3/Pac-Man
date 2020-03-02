package pacman.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import pacman.Handler;
import pacman.entities.creatures.Ghost;
import pacman.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Ghost> ghosts;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		ghosts = new ArrayList<Ghost>();
		addGhost(new Ghost(handler, 210,210,"red"));
	}
	
	public void tick() {
		player.tick();
		for(Entity e: ghosts) {
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		player.render(g);
		for(Entity e: ghosts) {
			e.render(g);
		}
	}
	
	public void addGhost(Ghost g) {
		ghosts.add(g);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Ghost> getGhosts() {
		return ghosts;
	}
}
