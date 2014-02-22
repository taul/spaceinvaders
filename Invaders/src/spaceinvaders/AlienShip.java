package spaceinvaders;

import java.awt.*;

/**
 *
 */
public class AlienShip {

	private int xPosition = 0;
	private int yPosition = 0;
	public static int WIDTH = 53;
	public static int HEIGHT = 42;


	// Whether this ship is alive or dead
	private boolean alive = true;

	private Image alienShipImage;
	private MainWindow mw;
	public AlienShip(Image ship, MainWindow mw) {
		alienShipImage = ship;
		this.mw = mw;
	}

	public boolean isAlive() {
		return alive;
	}

	// Check if it has been hit
	public boolean hitAlien(int x, int y) {
		// check if it is alive if it is:
		// Check X and Y, if they are ok we killed it
		if (alive && (x >= xPosition) && (x <= (xPosition + WIDTH))
				&& (y >= yPosition) && (y <= (yPosition + HEIGHT))) {
			alive = false;
			return true;
		}
		return false; // If it was already dead or we missed it
	}

	// Set the current position of the ship
	public void setPosition(int x, int y) {
		xPosition = x;
		yPosition = y;
	}

	// Some getters are always nice to have
	public int getXPos() {
		return xPosition;
	}

	public int getYPos() {
		return yPosition;
	}

	public void drawAlien(Graphics g) {
		if (alive) {
			g.drawImage(alienShipImage, xPosition, yPosition, mw);
		}
	}

}
