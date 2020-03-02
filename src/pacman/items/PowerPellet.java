package pacman.items;

import java.awt.Rectangle;

import pacman.entities.creatures.Ghost;
import pacman.gfx.Assets;

public class PowerPellet extends Item {

	public PowerPellet(int x, int y) {
		super(Assets.powerPellet, x, y);
		
		bounds = new Rectangle(x+5,y+5,20,20);
	}
	
	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds().intersects(bounds)) {
			pickedUp = true;
			for(Ghost g: handler.getWorld().getEntityManager().getGhosts()) {
				g.setScared(true);
			}
			handler.getWorld().addScore(50);
		}
	}
}
