package spaceinvaders;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Board extends JPanel {
	
	Image background;
	
	public Board() {
		ImageIcon bg = new ImageIcon(this.getClass().getResource("background.png"));
		background = bg.getImage();
	}
	
	public void paint(Graphics  g) {
		Graphics2D draw = (Graphics2D) g;
		draw.drawImage(background, 0, 0, null);
	}

}
