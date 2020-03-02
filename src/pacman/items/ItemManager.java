package pacman.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import pacman.Handler;
import pacman.gfx.Assets;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;
	private Fruit fruit;
	
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
		addItem(new PowerPellet(30,60));
		addItem(new PowerPellet(510,60));
		addItem(new PowerPellet(30,450));
		addItem(new PowerPellet(510,450));
		
		addItem(new Pellet(30, 30));
		addItem(new Pellet(60, 30));
		addItem(new Pellet(90, 30));
		addItem(new Pellet(120, 30));
		addItem(new Pellet(150, 30));
		addItem(new Pellet(180, 30));
		addItem(new Pellet(210, 30));
		addItem(new Pellet(240, 30));
		addItem(new Pellet(300, 30));
		addItem(new Pellet(330, 30));
		addItem(new Pellet(360, 30));
		addItem(new Pellet(390, 30));
		addItem(new Pellet(420, 30));
		addItem(new Pellet(450, 30));
		addItem(new Pellet(480, 30));
		addItem(new Pellet(510, 30));
		
		addItem(new Pellet(120, 60));
		addItem(new Pellet(240, 60));
		addItem(new Pellet(300, 60));
		addItem(new Pellet(420, 60));

		addItem(new Pellet(30, 90));
		addItem(new Pellet(60, 90));
		addItem(new Pellet(90, 90));
		addItem(new Pellet(120, 90));
		addItem(new Pellet(150, 90));
		addItem(new Pellet(180, 90));
		addItem(new Pellet(210, 90));
		addItem(new Pellet(240, 90));
		addItem(new Pellet(270, 90));
		addItem(new Pellet(300, 90));
		addItem(new Pellet(330, 90));
		addItem(new Pellet(360, 90));
		addItem(new Pellet(390, 90));
		addItem(new Pellet(420, 90));
		addItem(new Pellet(450, 90));
		addItem(new Pellet(480, 90));
		addItem(new Pellet(510, 90));
		
		addItem(new Pellet(30, 120));
		addItem(new Pellet(120, 120));
		addItem(new Pellet(180, 120));
		addItem(new Pellet(360, 120));
		addItem(new Pellet(420, 120));
		addItem(new Pellet(510, 120));
		
		addItem(new Pellet(30, 150));
		addItem(new Pellet(60, 150));
		addItem(new Pellet(90, 150));
		addItem(new Pellet(120, 150));
		addItem(new Pellet(180, 150));
		addItem(new Pellet(210, 150));
		addItem(new Pellet(240, 150));
		addItem(new Pellet(300, 150));
		addItem(new Pellet(330, 150));
		addItem(new Pellet(360, 150));
		addItem(new Pellet(420, 150));
		addItem(new Pellet(450, 150));
		addItem(new Pellet(480, 150));
		addItem(new Pellet(510, 150));
		
		addItem(new Pellet(120, 180));
		addItem(new Pellet(420, 180));
		addItem(new Pellet(120, 210));
		addItem(new Pellet(420, 210));
		addItem(new Pellet(120, 240));
		addItem(new Pellet(420, 240));
		addItem(new Pellet(120, 270));
		addItem(new Pellet(420, 270));
		addItem(new Pellet(120, 300));
		addItem(new Pellet(420, 300));
		addItem(new Pellet(120, 330));
		addItem(new Pellet(420, 330));
		addItem(new Pellet(120, 360));
		addItem(new Pellet(420, 360));
		
		addItem(new Pellet(30, 390));
		addItem(new Pellet(60, 390));
		addItem(new Pellet(90, 390));
		addItem(new Pellet(120, 390));
		addItem(new Pellet(150, 390));
		addItem(new Pellet(180, 390));
		addItem(new Pellet(210, 390));
		addItem(new Pellet(240, 390));
		addItem(new Pellet(300, 390));
		addItem(new Pellet(330, 390));
		addItem(new Pellet(360, 390));
		addItem(new Pellet(390, 390));
		addItem(new Pellet(420, 390));
		addItem(new Pellet(450, 390));
		addItem(new Pellet(480, 390));
		addItem(new Pellet(510, 390));
		
		addItem(new Pellet(30, 420));
		addItem(new Pellet(120, 420));
		addItem(new Pellet(240, 420));
		addItem(new Pellet(300, 420));
		addItem(new Pellet(420, 420));
		addItem(new Pellet(510, 420));
		
		addItem(new Pellet(60, 450));
		addItem(new Pellet(120, 450));
		addItem(new Pellet(150, 450));
		addItem(new Pellet(180, 450));
		addItem(new Pellet(210, 450));
		addItem(new Pellet(240, 450));
		addItem(new Pellet(300, 450));
		addItem(new Pellet(330, 450));
		addItem(new Pellet(360, 450));
		addItem(new Pellet(390, 450));
		addItem(new Pellet(420, 450));
		addItem(new Pellet(480, 450));
		
		addItem(new Pellet(60, 480));
		addItem(new Pellet(120, 480));
		addItem(new Pellet(180, 480));
		addItem(new Pellet(360, 480));
		addItem(new Pellet(420, 480));
		addItem(new Pellet(480, 480));
		
		addItem(new Pellet(30, 510));
		addItem(new Pellet(60, 510));
		addItem(new Pellet(90, 510));
		addItem(new Pellet(120, 510));
		addItem(new Pellet(180, 510));
		addItem(new Pellet(210, 510));
		addItem(new Pellet(240, 510));
		addItem(new Pellet(300, 510));
		addItem(new Pellet(330, 510));
		addItem(new Pellet(360, 510));
		addItem(new Pellet(420, 510));
		addItem(new Pellet(450, 510));
		addItem(new Pellet(480, 510));
		addItem(new Pellet(510, 510));
		
		addItem(new Pellet(30, 540));
		addItem(new Pellet(240, 540));
		addItem(new Pellet(300, 540));
		addItem(new Pellet(510, 540));
		
		addItem(new Pellet(30, 570));
		addItem(new Pellet(60, 570));
		addItem(new Pellet(90, 570));
		addItem(new Pellet(120, 570));
		addItem(new Pellet(150, 570));
		addItem(new Pellet(180, 570));
		addItem(new Pellet(210, 570));
		addItem(new Pellet(240, 570));
		addItem(new Pellet(270, 570));
		addItem(new Pellet(300, 570));
		addItem(new Pellet(330, 570));
		addItem(new Pellet(360, 570));
		addItem(new Pellet(390, 570));
		addItem(new Pellet(420, 570));
		addItem(new Pellet(450, 570));
		addItem(new Pellet(480, 570));
		addItem(new Pellet(510, 570));
		
		setFruit(1);
	}
	
	public void tick() {
		Iterator<Item> it = items.iterator();
		if(!fruit.isPickedUp()) {
			fruit.tick();
		}
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPickedUp()) {
				it.remove();
			}
		}
	}
	
	public void render(Graphics g) {
		if(!fruit.isPickedUp()) {
			fruit.render(g);
		}
		for(Item i: items) {
			i.render(g);
		}
	}
	
	public boolean isEmpty() {
		return items.size() == 0;
	}
	
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}
	
	public void setFruit(int level) {
		if(level == 1) {
			fruit = new Fruit(Assets.cherry,270,330,100);
			fruit.setHandler(handler);
		}
		else if(level == 2) {
			fruit = new Fruit(Assets.strawberry,270,330,300);
			fruit.setHandler(handler);
		}
		else if(level == 3) {
			fruit = new Fruit(Assets.orange,270,330,500);
			fruit.setHandler(handler);
		}
		else if(level == 4) {
			fruit = new Fruit(Assets.apple,270,330,700);
			fruit.setHandler(handler);
		}
		else if(level == 5) {
			fruit = new Fruit(Assets.melon,270,330,1000);
			fruit.setHandler(handler);
		}
		else if(level == 6) {
			fruit = new Fruit(Assets.ship,270,330,2000);
			fruit.setHandler(handler);
		}
		else if(level == 7) {
			fruit = new Fruit(Assets.bell,270,330,3000);
			fruit.setHandler(handler);
		}
		else {
			fruit = new Fruit(Assets.key,270,330,5000);
			fruit.setHandler(handler);
		}
	}
}
