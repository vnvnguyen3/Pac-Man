package pacman.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile blackTile = new BlackTile(0);
	public static Tile wallTile = new WallTile(1);
	
	public static final int TILE_WIDTH = 30, TILE_HEIGHT = 30;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT,null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
