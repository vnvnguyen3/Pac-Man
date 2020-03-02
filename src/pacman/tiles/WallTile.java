package pacman.tiles;

import pacman.gfx.Assets;

public class WallTile extends Tile{

	public WallTile(int id) {
		super(Assets.blue,id);
	}
	
	public boolean isSolid() {
		return true;
	}
}
