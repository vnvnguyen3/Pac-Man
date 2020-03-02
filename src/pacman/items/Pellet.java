package pacman.items;

import java.awt.Rectangle;

import pacman.gfx.Assets;

public class Pellet extends Item{

	public Pellet(int x, int y) {
		super(Assets.pellet, x, y);
		
		bounds = new Rectangle(x+13,y+13,4,4);
	}

	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds().intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().addScore(10);
		}
	}
}
