package pacman.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import pacman.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected boolean active = true;
	
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(1,1, width-2, height-2);
	}
	
	public abstract void die();
	
	public Rectangle getCollisionBounds() {
		return new Rectangle((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
}
