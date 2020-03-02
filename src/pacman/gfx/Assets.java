package pacman.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 30, height = 30;
	
	public static BufferedImage black, blue;
	public static BufferedImage map;
	public static BufferedImage pellet, powerPellet;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	
	public static BufferedImage[] red_right;
	public static BufferedImage[] red_left;
	public static BufferedImage[] red_up;
	public static BufferedImage[] red_down;
	
	public static BufferedImage[] blue_right;
	public static BufferedImage[] blue_left;
	public static BufferedImage[] blue_up;
	public static BufferedImage[] blue_down;
	
	public static BufferedImage[] orange_right;
	public static BufferedImage[] orange_left;
	public static BufferedImage[] orange_up;
	public static BufferedImage[] orange_down;
	
	public static BufferedImage[] pink_right;
	public static BufferedImage[] pink_left;
	public static BufferedImage[] pink_up;
	public static BufferedImage[] pink_down;
	
	public static BufferedImage[] scared_blue;
	public static BufferedImage[] scared_white;
	
	public static BufferedImage cherry, strawberry, orange, apple, melon, ship, bell, key;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/World Sheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Player Sheet.png"));
		SpriteSheet ghostSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Ghost Sheet.png"));
		
		black = sheet.crop(0, 0, width, height);
		blue = sheet.crop(width, 0, width, height);
		map = ImageLoader.loadImage("/textures/Map.png");
		
		pellet = sheet.crop(width*2, 0, width, height);
		powerPellet = sheet.crop(width*3, 0, width, height);
		
		cherry = sheet.crop(0, height, width, height);
		strawberry = sheet.crop(width, height, width, height);
		orange = sheet.crop(width*2, height, width, height);
		apple = sheet.crop(width*3, height, width, height);
		melon = sheet.crop(0, height*2, width, height);
		ship = sheet.crop(width, height*2, width, height);
		bell = sheet.crop(width*2, height*2, width, height);
		key = sheet.crop(width*3, height*2, width, height);
		
		player_right = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_down = new BufferedImage[4];
		
		player_right[0] =playerSheet.crop(0,0,width, height);
		player_right[1] =playerSheet.crop(width,0,width, height);
		player_right[2] =playerSheet.crop(width*2,0,width, height);
		player_right[3] =playerSheet.crop(width,0,width, height);
		
		player_left[0] =playerSheet.crop(0,0,width, height);
		player_left[1] =playerSheet.crop(width,height,width, height);
		player_left[2] =playerSheet.crop(width*2,height,width, height);
		player_left[3] =playerSheet.crop(width,height,width, height);
		
		player_up[0] =playerSheet.crop(0,0,width, height);
		player_up[1] =playerSheet.crop(width,height*2,width, height);
		player_up[2] =playerSheet.crop(width*2,height*2,width, height);
		player_up[3] =playerSheet.crop(width,height*2,width, height);
		
		player_down[0] =playerSheet.crop(0,0,width, height);
		player_down[1] =playerSheet.crop(width,height*3,width, height);
		player_down[2] =playerSheet.crop(width*2,height*3,width, height);
		player_down[3] =playerSheet.crop(width,height*3,width, height);
		
		red_right = new BufferedImage[2];
		red_left = new BufferedImage[2];
		red_up = new BufferedImage[2];
		red_down = new BufferedImage[2];
		
		blue_right = new BufferedImage[2];
		blue_left = new BufferedImage[2];
		blue_up = new BufferedImage[2];
		blue_down = new BufferedImage[2];
		
		orange_right = new BufferedImage[2];
		orange_left = new BufferedImage[2];
		orange_up = new BufferedImage[2];
		orange_down = new BufferedImage[2];
		
		pink_right = new BufferedImage[2];
		pink_left = new BufferedImage[2];
		pink_up = new BufferedImage[2];
		pink_down = new BufferedImage[2];
		
		scared_blue = new BufferedImage[2];
		scared_white = new BufferedImage[2];
		
		red_right[0] = ghostSheet.crop(0, 0, width, height);
		red_right[1] = ghostSheet.crop(width, 0, width, height);
		red_left[0] = ghostSheet.crop(0, height, width, height);
		red_left[1] = ghostSheet.crop(width, height, width, height);
		red_up[0] = ghostSheet.crop(0, height*2, width, height);
		red_up[1] = ghostSheet.crop(width, height*2, width, height);
		red_down[0] = ghostSheet.crop(0, height*3, width, height);
		red_down[1] = ghostSheet.crop(width, height*3, width, height);
		
		blue_right[0] = ghostSheet.crop(width*2, 0, width, height);
		blue_right[1] = ghostSheet.crop(width*3, 0, width, height);
		blue_left[0] = ghostSheet.crop(width*2, height, width, height);
		blue_left[1] = ghostSheet.crop(width*3, height, width, height);
		blue_up[0] = ghostSheet.crop(width*2, height*2, width, height);
		blue_up[1] = ghostSheet.crop(width*3, height*2, width, height);
		blue_down[0] = ghostSheet.crop(width*2, height*3, width, height);
		blue_down[1] = ghostSheet.crop(width*3, height*3, width, height);
		
		orange_right[0] = ghostSheet.crop(width*4, 0, width, height);
		orange_right[1] = ghostSheet.crop(width*5, 0, width, height);
		orange_left[0] = ghostSheet.crop(width*4, height, width, height);
		orange_left[1] = ghostSheet.crop(width*5, height, width, height);
		orange_up[0] = ghostSheet.crop(width*4, height*2, width, height);
		orange_up[1] = ghostSheet.crop(width*5, height*2, width, height);
		orange_down[0] = ghostSheet.crop(width*4, height*3, width, height);
		orange_down[1] = ghostSheet.crop(width*5, height*3, width, height);
		
		pink_right[0] = ghostSheet.crop(width*6, 0, width, height);
		pink_right[1] = ghostSheet.crop(width*7, 0, width, height);
		pink_left[0] = ghostSheet.crop(width*6, height, width, height);
		pink_left[1] = ghostSheet.crop(width*7, height, width, height);
		pink_up[0] = ghostSheet.crop(width*6, height*2, width, height);
		pink_up[1] = ghostSheet.crop(width*7, height*2, width, height);
		pink_down[0] = ghostSheet.crop(width*6, height*3, width, height);
		pink_down[1] = ghostSheet.crop(width*7, height*3, width, height);
		
		scared_blue[0] = ghostSheet.crop(width*8, 0, width, height);
		scared_blue[1] = ghostSheet.crop(width*9, 0, width, height);
		
		scared_white[0] = ghostSheet.crop(width*8, height, width, height);
		scared_white[1] = ghostSheet.crop(width*9, 0, width, height);
	}
}
