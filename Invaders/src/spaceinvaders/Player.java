package spaceinvaders;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Player implements MouseListener, MouseMotionListener {

	public static int WIDTH; // We'll have to figure something out later.
	public static int HEIGHT;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	private Missile missile; // Only one missile at a time for now.

	Image playerShip;
	AlienFleet fleet;

	public Player(Image playerShip) {
		this.playerShip = playerShip;
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
		// Move ship

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Shoot!
		// Get the current alien fleet from somewhere (board? mainwindow?)
		// because the missile class will need a fleet to hit.
		// Create a new missile at xPosition+(SHIP_WIDTH/2), yPosition
		missile = new Missile((int) xPosition + (WIDTH / 2), yPosition, fleet);
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

		if ((missile != null) && missile.missileExists()) {
			missile.drawMissile(g);
		}
	}

	public boolean checkShot(int x, int y) {
		if (alive && (x >= xPosition) && (x <= (xPosition + WIDTH))
				&& (y >= yPosition) && (y <= (yPosition + HEIGHT))) {
			alive = false; // We died :(
			return true;
		}
		return false;
	}
}