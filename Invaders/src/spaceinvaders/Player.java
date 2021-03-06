package spaceinvaders;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Player implements MouseListener, MouseMotionListener {

	public static int WIDTH = 27;
	public static int HEIGHT = 21;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	private Missile missile; // Only one missile at a time for now.

	private Image playerShip;
	private AlienFleet fleet;
	private MainWindow mw;

	public Player(Image playerShip, MainWindow mw) {
		this.playerShip = playerShip;
		this.mw = mw;
		// Some fancy dynamic positioning (based on the screen size)
		xPosition = (int) ((MainWindow.WIDTH / 2) + (WIDTH / 2));
		yPosition = MainWindow.HEIGHT - HEIGHT - 20; // remember that these are
														// all measured from the
														// upper left corner, so
														// this is 20 pixels
														// from the bottom.
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
        int newX = arg0.getX();
        if (newX > (MainWindow.WIDTH-this.WIDTH-10)) {
        	xPosition = MainWindow.WIDTH-this.WIDTH-10;
        } else {
        	xPosition = newX;
        } 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Shoot!
		fleet = mw.getAlienFleet();
		missile = new Missile((int) xPosition + (WIDTH / 2), yPosition, fleet, mw);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Start the game

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Pause the game

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void drawShip(Graphics g) {
		// Draw ship and missile if it exists.
		g.drawImage(playerShip, xPosition, yPosition, mw);
		if ((missile != null) && missile.missileExists()) {
			missile.drawMissile(g);
		}
	}

	public boolean checkShot(int x, int y) {
		//Same as for the aliens I guess...
		if (alive && (x >= xPosition) && (x <= (xPosition + WIDTH))
				&& (y >= yPosition) && (y <= (yPosition + HEIGHT))) {
			alive = false; // We died :(
			mw.decreaseScore();
			return true;
		}
		return false;
	}
}
