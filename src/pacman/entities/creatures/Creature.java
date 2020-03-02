package pacman.entities.creatures;

import java.awt.Rectangle;

import pacman.Handler;
import pacman.entities.Entity;
import pacman.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final float DEFAULT_SPEED = 0.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 30,
							DEFAULT_CREATURE_HEIGHT = 30;
	protected float speed;
	protected float xMove, yMove;
	protected float spawnX, spawnY;
	protected Rectangle hitBox;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		spawnX = x;
		spawnY = y;
		
		hitBox = new Rectangle(10, 10, width - 20, height - 20);
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Right
			int tx = (int)(x + xMove + bounds.x + bounds.width)/Tile.TILE_WIDTH;
			if(!collisionWithTile(tx,(int)(y + bounds.y)/Tile.TILE_HEIGHT)&&
					!collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.height - 1;
			}
		}else if(xMove < 0) {//Left
			int tx = (int)(x + xMove + bounds.x)/Tile.TILE_WIDTH;
			if(!collisionWithTile(tx,(int)(y + bounds.y)/Tile.TILE_HEIGHT)&&
					!collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x + 1;
			}
		}
		if(x <= 0) {
			x = 539;
		}
		if(x >= 540) {
			x = 1;
		}
	}
	
	public void moveY() {
		if(yMove < 0) {//Up
			int ty = (int)(y + yMove + bounds.y)/Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)
					&&!collisionWithTile((int)(x+bounds.x + bounds.width)/Tile.TILE_WIDTH,ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT  + Tile.TILE_HEIGHT - bounds.y + 1;
			}
		}else if(yMove > 0) {//Down
			int ty = (int)(y + yMove + bounds.y + bounds.height)/Tile.TILE_HEIGHT;
			if(!collisionWithTile((int)(x+bounds.x)/Tile.TILE_WIDTH,ty)
					&&!collisionWithTile((int)(x+bounds.x + bounds.width)/Tile.TILE_WIDTH,ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.width - 1;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x,y).isSolid();
	}

	public void respawn() {
		x = spawnX;
		y = spawnY;
		xMove = 0;
		yMove = 0;
	}
	
	//Getters Setters
	
	public Rectangle getHitBox() {
		return new Rectangle((int)(x + hitBox.x), (int)(y + hitBox.y), hitBox.width, hitBox.height);
	}
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
}
