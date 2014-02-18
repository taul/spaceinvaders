package spaceinvaders;

import java.awt.*;

/**
 *
 */
public class Missile implements Runnable {

	private int WIDTH;
	private int HEIGHT;

	private int xPosition = 0;
	private int yPosition = 0;

	private int missileSpeed; // how long, in milliseconds, between moving 2 pixels. is this a
								// good way to do it?
	boolean missileExists = true;

	AlienFleet fleet;

	public Missile(int x, int y, AlienFleet fleet) {
		xPosition = x;// Set the shot direction
		yPosition = y;
		this.fleet = fleet;
		Thread thread = new Thread(this);
		thread.start();
	}

	private boolean move() {

		// check if we hit anything.
		if (fleet.checkShot(xPosition, yPosition)) {
			// We killed an alien!
			System.out.println("We killed an alien ship!");
			missileExists = false;
			return true;
		}

		yPosition -= 2; // is 2 pixels too little?

		// check if it's gone of screen
		if (yPosition < 0) {
			missileExists = false;
			return true;
		}

		return false;
	}

	public void drawMissile(Graphics g) {
		if (missileExists) {

		} else {

		}

	}

	public boolean missileExists() {
		return missileExists;
	}

	// The wonderful thread run method that makes the missile move
	public void run() {
		while (true) {
			try {
				Thread.sleep(missileSpeed);
			} catch (InterruptedException ie) {
				// damn exceptions, stop trying to interrupt me.
			}

			if (move()) {
				break;
			}
		}
	}

}