package pacman.items;

import java.awt.image.BufferedImage;

public class Fruit extends Item{
	
	private int value;

	public Fruit(BufferedImage texture, int x, int y, int value) {
		super(texture, x, y);
		this.value = value;
	}

	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds().intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().addScore(value);
		}
	}
}
