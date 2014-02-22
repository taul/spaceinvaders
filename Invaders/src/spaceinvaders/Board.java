package spaceinvaders;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Board extends JPanel {
	
	Image background;
	Graphics2D draw;
	AlienFleet af;
	Player p;
	public Board(AlienFleet af, Player p) {
		Image bg = new ImageIcon("background.png").getImage();
		this.af = af;
		this.p = p;
	}
	
	public void paint(Graphics  g) {
		draw = (Graphics2D) g;
		draw.drawImage(background, 0, 0, null);
		af.drawFleet(g);
		p.drawShip(g);
	}
	
	public void update(Graphics g){
		paint(g);
	}

}
