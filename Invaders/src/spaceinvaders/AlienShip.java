package spaceinvaders;

import java.awt.*;

/**
 *
 */
public class AlienShip {

	private int xPosition = 0;
	private int yPosition = 0;
	public static int HEIGHT; // unsure what these shot be set to as of now
	public static int WIDTH;

	// Whether this ship is alive or dead
	private boolean alive = true;

	private Image alienShipImage;

	public AlienShip(Image ship) {
		alienShipImage = ship;
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
			// Draw it if it's alive.
		}
	}

}
