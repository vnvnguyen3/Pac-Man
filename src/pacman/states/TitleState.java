package pacman.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import pacman.Handler;
import pacman.gfx.Assets;

public class TitleState extends State{

	public TitleState(Handler handler) {
		super(handler);
	}

	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
			handler.getWorld().reset();
			State.setState(handler.getGame().gameState);
		}
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("Bauhaus 93", Font.BOLD, 130));
		g.setColor(Color.YELLOW);
		g.drawString("PAC-MAN",100, 200);
		
		g.setFont(new Font("Rockwell", Font.BOLD, 30));
		g.setColor(Color.RED);
		g.drawString("1UP", 50, 50);
		g.drawString("HI-SCORE", 300, 50);
		g.drawString("2UP", 600, 50);
		
		g.setFont(new Font("Rockwell", Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString(""+handler.getWorld().getScore(), 100, 80);
		g.drawString(""+handler.getWorld().getHiScore(), 350, 80);
		g.drawString("0", 650, 80);
		
		g.setFont(new Font("Rockwell", Font.BOLD, 50));
		g.setColor(Color.WHITE);
		g.drawString("PRESS ENTER",200, 300);
		
		g.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		g.setColor(Color.RED);
		g.drawString("MADE BY VINCENT NGUYEN",200, 550);

		g.drawImage(Assets.powerPellet, 60, 580, null);
		g.drawImage(Assets.player_left[1], 100, 580, null);
		g.drawImage(Assets.red_left[1], 140, 580, null);
		g.drawImage(Assets.blue_up[1], 180, 580, null);
		g.drawImage(Assets.orange_down[1], 220, 580, null);
		g.drawImage(Assets.pink_right[1], 260, 580, null);
		g.drawImage(Assets.scared_blue[1], 300, 580, null);
		g.drawImage(Assets.scared_white[0], 340, 580, null);
		g.drawImage(Assets.cherry, 380, 580, null);
		g.drawImage(Assets.strawberry, 420, 580, null);
		g.drawImage(Assets.orange, 460, 580, null);
		g.drawImage(Assets.apple, 500, 580, null);
		g.drawImage(Assets.melon, 540, 580, null);
		g.drawImage(Assets.ship, 580, 580, null);
		g.drawImage(Assets.bell, 620, 580, null);
		g.drawImage(Assets.key, 660, 580, null);
		g.drawImage(Assets.pellet, 700, 580, null);
	}
}
