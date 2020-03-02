package pacman.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import pacman.Handler;
import pacman.gfx.Animation;
import pacman.gfx.Assets;
import pacman.tiles.Tile;

public class Player extends Creature{

	private Animation animLeft, animRight, animUp, animDown;
	private boolean holdLeft = false, holdRight = false, holdUp = false, holdDown = false;
	private int lives = 3;
	private boolean dead = false;
	private boolean extraLife = false;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		animLeft = new Animation(50, Assets.player_left);
		animRight = new Animation(50, Assets.player_right);
		animUp = new Animation(50, Assets.player_up);
		animDown = new Animation(50, Assets.player_down);
	}

	private void getInput() {
		if(handler.getKeyManager().up) {
			holdLeft = false;
			holdRight = false;
			holdUp = true;
			holdDown = false;
		}
		if(handler.getKeyManager().down) {
			holdLeft = false;
			holdRight = false;
			holdUp = false;
			holdDown = true;
		}
		if(handler.getKeyManager().left) {
			holdLeft = true;
			holdRight = false;
			holdUp = false;
			holdDown = false;
		}
		if(handler.getKeyManager().right) {
			holdLeft = false;
			holdRight = true;
			holdUp = false;
			holdDown = false;
		}
	}
	
	@Override
	public void die() {
		lives--;
		if(lives >= 0) {
			respawn();
			for(Ghost g: handler.getWorld().getEntityManager().getGhosts()) {
				g.respawn();
				g.setScared(false);
			}
		}
		else {
			dead = true;
			xMove = 0;
			yMove = 0;
			handler.getWorld().gameOver();
		}
	}

	@Override
	public void tick() {
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		animDown.tick();
		if(!dead) {
			getInput();
		}
		if(x % 30 == 0 && y % 30 == 0) {
			turn();
		}
		move();
		checkGhostCollisions();
	}
	
	public void checkGhostCollisions() {
		for(Ghost g: handler.getWorld().getEntityManager().getGhosts()) {
			if(g.getHitBox().intersects(getHitBox())) {
				if(g.isScared()) {
					g.die();
				}
				else {
					die();
				}
			}
		}
	}
	
	public void turn() {
		if(holdLeft && !collisionWithTile((int)(x-1)/Tile.TILE_WIDTH,(int)(y)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x-1)/Tile.TILE_WIDTH,(int)(y+ bounds.height)/Tile.TILE_HEIGHT)) {
			xMove = -speed;
			yMove = 0;
			holdLeft = false;
		}
		if(holdRight && !collisionWithTile((int)(x+width+1)/Tile.TILE_WIDTH,(int)(y)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x+width+1)/Tile.TILE_WIDTH,(int)(y+ bounds.height)/Tile.TILE_HEIGHT)) {
			xMove = speed;
			yMove = 0;
			holdRight = false;
		}
		if(holdUp && !collisionWithTile((int)(x)/Tile.TILE_WIDTH,(int)(y-1)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x + bounds.width)/Tile.TILE_WIDTH,(int)(y-1)/Tile.TILE_HEIGHT)) {
			yMove = -speed;
			xMove = 0;
			holdUp = false;
		}
		if(holdDown && !collisionWithTile((int)(x)/Tile.TILE_WIDTH,(int)(y+height+1)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x + bounds.width)/Tile.TILE_WIDTH,(int)(y+height+1)/Tile.TILE_HEIGHT)) {
			yMove = speed;
			xMove = 0;
			holdDown = false;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)x, (int)y, width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}
		else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0) {
			return animUp.getCurrentFrame();
		}
		else {
			return animDown.getCurrentFrame();
		}
	}

	public void addLife() {
		lives++;
		extraLife = true;
	}
	
	public boolean gotExtraLife() {
		return extraLife;
	}
	
	public int getLives() {
		return lives;
	}
}
