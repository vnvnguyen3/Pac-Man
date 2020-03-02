package pacman.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import pacman.Handler;
import pacman.gfx.Animation;
import pacman.gfx.Assets;
import pacman.tiles.Tile;

public class Ghost extends Creature{

	private final int DEFAULT_SCARED_TICK = 1900;
	private Animation animLeft, animRight, animUp, animDown;
	private boolean scared = false;
	private int scaredTick = DEFAULT_SCARED_TICK;
	private String color;
	
	public Ghost(Handler handler, float x, float y, String color) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.color = color;
		speed = 0.25f;
		setAnimation();
	}

	private void setAnimation() {
		if(scared) {
			if(scaredTick > 500) {
				animLeft = new Animation(50, Assets.scared_blue);
				animRight = new Animation(50, Assets.scared_blue);
				animUp = new Animation(50, Assets.scared_blue);
				animDown = new Animation(50, Assets.scared_blue);
			}
			else {
				animLeft = new Animation(50, Assets.scared_white);
				animRight = new Animation(50, Assets.scared_white);
				animUp = new Animation(50, Assets.scared_white);
				animDown = new Animation(50, Assets.scared_white);
			}
		}
		else {
			if(color.equals("red")) {
				animLeft = new Animation(50, Assets.red_left);
				animRight = new Animation(50, Assets.red_right);
				animUp = new Animation(50, Assets.red_up);
				animDown = new Animation(50, Assets.red_down);
			}
			if(color.equals("blue")) {
				animLeft = new Animation(50, Assets.blue_left);
				animRight = new Animation(50, Assets.blue_right);
				animUp = new Animation(50, Assets.blue_up);
				animDown = new Animation(50, Assets.blue_down);
			}
			if(color.equals("orange")) {
				animLeft = new Animation(50, Assets.orange_left);
				animRight = new Animation(50, Assets.orange_right);
				animUp = new Animation(50, Assets.orange_up);
				animDown = new Animation(50, Assets.orange_down);
			}
			if(color.equals("pink")) {
				animLeft = new Animation(50, Assets.pink_left);
				animRight = new Animation(50, Assets.pink_right);
				animUp = new Animation(50, Assets.pink_up);
				animDown = new Animation(50, Assets.pink_down);
			}
		}
	}
	
	@Override
	public void die() {
		scared = false;
		int numEaten = 0;
		for(Ghost g: handler.getWorld().getEntityManager().getGhosts()) {
			if(!g.isScared()) {
				numEaten++;
			}
		}
		if(numEaten == 1) {
			handler.getWorld().addScore(200);
		}
		if(numEaten == 2) {
			handler.getWorld().addScore(400);
		}
		if(numEaten == 3) {
			handler.getWorld().addScore(800);
		}
		if(numEaten >= 4) {
			handler.getWorld().addScore(1600);
		}
		scaredTick = DEFAULT_SCARED_TICK;
		setAnimation();
		respawn();
	}

	@Override
	public void tick() {
		if(scared) {
			scaredTick--;
		}
		if(scaredTick < 0) {
			scared = false;
			scaredTick = DEFAULT_SCARED_TICK;
			setAnimation();
		}else if(scaredTick == 300) {
			setAnimation();
		}
		animLeft.tick();
		animRight.tick();
		animUp.tick();
		animDown.tick();
		if(x % 30 == 0 && y % 30 == 0) {
			turn();
		}
		move();
	}
	
	public void turn() {
		Random rand = new Random();
		int s = 1;
		int[] directions = new int[4];
		if(xMove != speed && !collisionWithTile((int)(x-1)/Tile.TILE_WIDTH,(int)(y)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x-1)/Tile.TILE_WIDTH,(int)(y+ bounds.height)/Tile.TILE_HEIGHT)) {//left
			directions[0] = s;
			s++;
		}
		if(xMove != -speed && !collisionWithTile((int)(x+width+1)/Tile.TILE_WIDTH,(int)(y)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x+width+1)/Tile.TILE_WIDTH,(int)(y+ bounds.height)/Tile.TILE_HEIGHT)) {//right
			directions[1] = s;
			s++;
		}
		if(yMove != speed && !collisionWithTile((int)(x)/Tile.TILE_WIDTH,(int)(y-1)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x + bounds.width)/Tile.TILE_WIDTH,(int)(y-1)/Tile.TILE_HEIGHT)) {//up
			directions[2] = s;
			s++;
		}
		if(yMove != -speed && !collisionWithTile((int)(x)/Tile.TILE_WIDTH,(int)(y+height+1)/Tile.TILE_HEIGHT)&&
				!collisionWithTile((int)(x + bounds.width)/Tile.TILE_WIDTH,(int)(y+height+1)/Tile.TILE_HEIGHT)) {//down
			directions[3] = s;
			s++;
		}
		int selected = rand.nextInt(s-1)+1;
		if(directions[0] == selected) {//left
			xMove = -speed;
			yMove = 0;
		}
		if(directions[1] == selected) {//right
			xMove = speed;
			yMove = 0;
		}
		if(directions[2] == selected) {//up
			yMove = -speed;
			xMove = 0;
		}
		if(directions[3] == selected) {//down
			yMove = speed;
			xMove = 0;
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

	public boolean isScared() {
		return scared;
	}

	public void setScared(boolean scared) {
		this.scared = scared;
		scaredTick = DEFAULT_SCARED_TICK;
		if(scared) {
			xMove = -xMove;
			yMove = -yMove;
		}
		setAnimation();
	}
	
	public String getColor() {
		return color;
	}
	
	
}
