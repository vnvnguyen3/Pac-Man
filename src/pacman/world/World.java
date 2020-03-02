package pacman.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pacman.Handler;
import pacman.entities.EntityManager;
import pacman.entities.creatures.Ghost;
import pacman.entities.creatures.Player;
import pacman.gfx.Assets;
import pacman.items.ItemManager;
import pacman.states.State;
import pacman.tiles.Tile;
import pacman.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private int score = 0, hiScore = 10000;
	private int level = 1;
	private boolean gameOver = false;
	private int titleTransition = 1300;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 270, 450));
		itemManager = new ItemManager(handler);
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		if(titleTransition < 0) {
			State.setState(handler.getGame().titleState);
		}
		if(!gameOver) {
			if(score > 10000 && !entityManager.getPlayer().gotExtraLife()) {
				entityManager.getPlayer().addLife();
			}
			itemManager.tick();
			entityManager.tick();
			if(itemManager.isEmpty()) {
				levelUp();
			}
		}
		else {
			titleTransition--;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.map, 0, 0, null);
		g.setFont(new Font("Rockwell", Font.BOLD, 30));
		g.setColor(Color.RED);
		g.drawString("HI-SCORE", 600, 50);
		g.drawString("1UP", 600, 150);
		g.setColor(Color.WHITE);
		g.drawString(""+hiScore, 650, 100);
		g.drawString(""+score, 650, 200);
		for(int i = 0; i < entityManager.getPlayer().getLives();i++) {
			g.drawImage(Assets.player_left[1], 600 + i * 40, 500, null);
		}
		itemManager.render(g);
		g.drawImage(Assets.cherry,600, 400, null);
		if(level > 1) {
			g.drawImage(Assets.strawberry,640, 400, null);
		}
		if(level > 2) {
			g.drawImage(Assets.orange,680, 400, null);
		}
		if(level > 3) {
			g.drawImage(Assets.apple,720, 400, null);
		}
		if(level > 4) {
			g.drawImage(Assets.melon,600, 440, null);
		}
		if(level > 5) {
			g.drawImage(Assets.ship,640, 440, null);
		}
		if(level > 6) {
			g.drawImage(Assets.bell,680, 440, null);
		}
		if(level > 7) {
			g.drawImage(Assets.key,720, 440, null);
		}
		if(!gameOver) {
			entityManager.render(g);
		}
		else {
			g.drawString("GAME OVER", 190, 355);
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x > width || y > height) {
			return Tile.blackTile;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.blackTile;
		}
		return t;
	}
	
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		tiles = new int[width][height];
		for(int y = 0;y < height;y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
			}
		}
	}

	public void addScore(int points) {
		score += points;
		if(score > hiScore) {
			hiScore = score;
		}
	}
	
	public void levelUp() {
		level++;
		entityManager.getPlayer().respawn();
		if(level % 4 == 1) {
			entityManager.addGhost(new Ghost(handler,210, 210, "red"));
		}
		else if(level % 4 == 2) {
			entityManager.addGhost(new Ghost(handler,240, 210, "blue"));
		}
		else if(level % 4 == 3) {
			entityManager.addGhost(new Ghost(handler,300, 210, "orange"));
		}
		else if(level % 4 == 0) {
			entityManager.addGhost(new Ghost(handler,330, 210, "pink"));
		}
		for(Ghost g: entityManager.getGhosts()) {
			g.respawn();
			g.setScared(false);
		}
		itemManager = new ItemManager(handler);
		itemManager.setFruit(level);
	}
	
	public void reset() {
		gameOver = false;
		titleTransition = 1300;
		score = 0;
		level = 1;
		entityManager = new EntityManager(handler, new Player(handler, 270, 450));
		itemManager = new ItemManager(handler);
	}
	
	public int getLevel() {
		return level;
	}
	
	public void gameOver() {
		gameOver = true;
	}
	
	public int getScore() {
		return score;
	}

	public int getHiScore() {
		return hiScore;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
