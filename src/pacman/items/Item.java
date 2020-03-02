package pacman.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import pacman.Handler;

public class Item {
	
	public static final int ITEMWIDTH = 30, ITEMHEIGHT = 30;
	
	protected Handler handler;
	protected BufferedImage texture;
	
	protected Rectangle bounds;
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, int x, int y) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		
		bounds = new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
	}
	
	public void tick() {
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds().intersects(bounds)) {
			pickedUp = true;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

	//Getters Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
}
